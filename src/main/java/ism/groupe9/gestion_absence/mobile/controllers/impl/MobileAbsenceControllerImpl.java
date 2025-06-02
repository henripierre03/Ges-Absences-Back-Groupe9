package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.controllers.MobileAbsenceController;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;
import ism.groupe9.gestion_absence.mobile.mappers.MobileAbsenceMapper;
import ism.groupe9.gestion_absence.mobile.mappers.MobileAbsenceMapperManuel;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MobileAbsenceControllerImpl implements MobileAbsenceController {

  private final MobileAbsenceMapper absenceMapper;
  private final AbsenceService absenceService;
  private final MobileAbsenceMapperManuel absenceMapperManuel;
  private final MobileAbsenceMapper mapper;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    List<Absence> absences = absenceService.getAll();

    if (absences.isEmpty()) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Aucune absence trouvée", "string"), HttpStatus.NOT_FOUND);
    }

    var absencesResponse = absences.stream()
        .map(absenceMapper::toAbsenceSimpleResponse)
        .toList();
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, absencesResponse, "absenceAndEtudiantResponse"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> create(AbsenceCreateRequest absenceRequest) {
    Map<String, Object> response = new HashMap<>();

    try {
      if (absenceRequest.getEtudiantId() == null || absenceRequest.getDate() == null) {
        response.put("message", "Les champs obligatoires sont manquants");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
      }
      List<Absence> existing = absenceService.getByEtudiantId(absenceRequest.getEtudiantId());
      boolean absenceExists = existing.stream()
          .anyMatch(a -> a.getDate().toLocalDate().equals(absenceRequest.getDate().toLocalDate())
              && Objects.equals(a.getCourId(), absenceRequest.getCourId()));
      if (absenceExists) {
        response.put("message", "Cette absence existe déjà.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
      }
      Absence absenceToSave = mapper.toEntity(absenceRequest);
      Absence savedAbsence = absenceService.save(absenceToSave);

      response.put("message", "Absence créée avec succès.");
      response.put("absence", mapper.toAbsenceSimpleResponse(savedAbsence));
      return ResponseEntity.status(HttpStatus.CREATED).body(response);

    } catch (Exception e) {
      e.printStackTrace();
      response.put("message", "Erreur interne du serveur");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByVigileId(String id) {
    List<Absence> absenceScanner = absenceService.getByVigileId(id);

    if (absenceScanner.isEmpty()) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Aucune absence trouvée pour ce vigile", "string"),
          HttpStatus.NOT_FOUND);
    } else {
      var absenceResponse = absenceScanner.stream()
          .map(absenceMapperManuel::toAbsenceAndEtudiantResponse).toList();
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.OK, absenceResponse, "absenceAndEtudiantResponse"),
          HttpStatus.OK);

    }
  }

  @Override
  public ResponseEntity<Map<String, Object>> getAbsencesByEtudiantId(String id) {
    List<Absence> absences = absenceService.getByEtudiant(id);

    if (absences.isEmpty()) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Aucune absence trouvée pour cet étudiant", "string"),
          HttpStatus.NOT_FOUND);
    }

    var absencesResponse = absences.stream()
        .map(absenceMapper::toAbsenceSimpleResponse)
        .toList();
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, absencesResponse, "absenceAndEtudiantResponse"), HttpStatus.OK);
  }

}
