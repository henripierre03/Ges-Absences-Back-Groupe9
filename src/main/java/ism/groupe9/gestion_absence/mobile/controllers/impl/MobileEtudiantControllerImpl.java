package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import ism.groupe9.gestion_absence.mobile.controllers.MobileEtudiantController;
import ism.groupe9.gestion_absence.mobile.dto.request.PointageRequest;
import ism.groupe9.gestion_absence.mobile.mappers.MobileAbsenceMapperManuel;
import ism.groupe9.gestion_absence.mobile.mappers.MobileEtudiantMapper;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MobileEtudiantControllerImpl implements MobileEtudiantController {

  private final EtudiantService etudiantService;
  private final AbsenceService absenceService;
  private final MobileEtudiantMapper etudiantMapper;
  private final MobileAbsenceMapperManuel absenceMapper;

  @Override
  public ResponseEntity<Map<String, Object>> getAll(User userConnect) {
    var etudiants = etudiantService.getAll();
    var etudiantResponse = etudiants.stream().map(etudiantMapper::toEtudiantAllResponse).toList();
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, etudiantResponse, "etudiantAllResponse"),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByMatricule(String matricule) {
    var etudiant = etudiantService.getByMatricule(matricule);
    if (etudiant == null) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "string"),
          HttpStatus.NOT_FOUND);
    }
    var etudiantResponse = etudiantMapper.toEtudiantSimpleResponse(etudiant);
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, etudiantResponse, "etudiantSimpleResponse"),
        HttpStatus.OK);

  }

  int TOLERANCE_RETARD_MINUTES = 15;

  @Override
  public ResponseEntity<Map<String, Object>> pointageEtudiant(PointageRequest request) {

    var etudiant = etudiantService.getByMatricule(request.getMatricule());
    if (etudiant == null) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Étudiant non trouvé", "string"),
          HttpStatus.NOT_FOUND);
    }
    if (!etudiant.isArePayed()) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.BAD_REQUEST, "Étudiant n'as pas encore payé pour ce mois", "string"),
          HttpStatus.BAD_REQUEST);
      
    }
    DetailCour prochainCours = etudiantService.getProchainCoursAujourdHui(request.getMatricule());

    boolean dejaPointe = absenceService.getByEtudiantId(etudiant.getId()).stream()
        .anyMatch(a -> a.getDate().equals(prochainCours.getDate()) && a.getTypeAbsence() == TypeAbsence.PRESENCE);

    if (dejaPointe) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.BAD_REQUEST, "Vous avez déjà pointé cet etudiant pour ce cours",
              "string"),
          HttpStatus.BAD_REQUEST);
    }
    Absence absence = new Absence();
    absence.setEtudiantId(etudiant.getId());
    absence.setVigileId(request.getVigileId());
    absence.setDate(prochainCours.getDate());
    absence.setCourId(prochainCours.getId());

    var heureDebut = prochainCours.getHeureDebut();
    var minutesRetard = calculerMinutesRetard(heureDebut, LocalTime.now());
    absence.setTypeAbsence(determinerTypeAbsence(minutesRetard));

    var savedAbsence = absenceService.save(absence);

    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.CREATED,
            absenceMapper.toAbsenceAndEtudiantResponse(savedAbsence),
            "absenceSimpleResponse"),
        HttpStatus.CREATED);
  }

  private int calculerMinutesRetard(LocalTime heureDebut, LocalTime heureArrivee) {
    if (heureArrivee.isBefore(heureDebut) || heureArrivee.equals(heureDebut)) {
      return 0;
    }
    return (int) Duration.between(heureDebut, heureArrivee).toMinutes();
  }

  private TypeAbsence determinerTypeAbsence(int minutesRetard) {
    if (minutesRetard <= TOLERANCE_RETARD_MINUTES) {
      return TypeAbsence.PRESENCE;
    } else {
      return TypeAbsence.RETARD;
    }
  }
}
