package ism.groupe9.gestion_absence.web.controllers.Impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.web.controllers.JustificationController;
import ism.groupe9.gestion_absence.web.dto.request.JustificationUpdateRequest;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import ism.groupe9.gestion_absence.web.mappers.JustificationMapper;
import ism.groupe9.gestion_absence.web.mappers.JustificationMapperManuelle;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://gestion-absences-one.vercel.app" })
public class JustificationControllerImpl implements JustificationController {
  private final JustificationMapperManuelle justificationMapper;
  private final JustificationService justificationService;
  private final JustificationMapper justificationMapper2;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByAbsenceId(String absenceId) {

    Justification justification = justificationService.getByAbsence(absenceId);
    if (justification == null) {
      return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, "Justification introuvable", "string"),
          HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(RestResponse.response(HttpStatus.OK,
        justificationMapper.toJustificationResponse(justification), "JustificationResponse"), HttpStatus.OK);

  }

  @Override
  public ResponseEntity<Map<String, Object>> validationJustification(String id, JustificationUpdateRequest justification) {
    Justification updatedJustification = justificationService.update(id, justification);
    if (updatedJustification == null) {
      return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, "Justification introuvable", "string"),
          HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(RestResponse.response(HttpStatus.OK,
        justificationMapper2.toJustificationSimpleResponse(updatedJustification), "JustificationResponse"),
        HttpStatus.OK);
  }
}
