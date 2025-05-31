package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import ism.groupe9.gestion_absence.mobile.controllers.MobileEtudiantController;
import ism.groupe9.gestion_absence.mobile.dto.request.PointageRequest;
import ism.groupe9.gestion_absence.mobile.mappers.AbsenceMapperManuel;
import ism.groupe9.gestion_absence.mobile.mappers.EtudiantMapper;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MobileEtudiantControllerImpl implements MobileEtudiantController {

  private final EtudiantService etudiantService;
  private final AbsenceService absenceService;
  private final EtudiantMapper etudiantMapper;
  private final AbsenceMapperManuel absenceMapper;

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

  @Override
  public ResponseEntity<Map<String, Object>> pointageEtudiant(PointageRequest request) {
    System.out.println("Pointage request: " + request.getVigileId());
    var etudiant = etudiantService.getByMatricule(request.getMatricule());
    if (etudiant == null) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Étudiant non trouvé", "string"),
          HttpStatus.NOT_FOUND);
    }
    Absence absence = new Absence();
    absence.setEtudiantId(etudiant.getId());
    absence.setVigileId(request.getVigileId());
    absence.setDate(LocalDateTime.parse(request.getDate()));
    absence.setTypeAbsence(TypeAbsence.PRESENCE);

    var savedAbsence = absenceService.save(absence);

    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.CREATED,
            absenceMapper.toAbsenceAndEtudiantResponse(savedAbsence),
            "absenceSimpleResponse"),
        HttpStatus.CREATED);
  }
}
