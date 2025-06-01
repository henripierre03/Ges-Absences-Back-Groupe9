package ism.groupe9.gestion_absence.web.controllers.Impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.utils.exceptions.EntityNotFoundExceptions;
import ism.groupe9.gestion_absence.utils.mappers.JustificationMapperWeb;
import ism.groupe9.gestion_absence.web.controllers.JustificationController;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JustificationControllerImpl implements JustificationController {
  private final JustificationMapperWeb justificationMapperWeb;
  private final JustificationService justificationService;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByAbsenceId(String absenceId) {
    try {
      Justification justification = justificationService.getByAbsence(absenceId);
      JustificationResponse dto = justificationMapperWeb.toDto(justification);

      return ResponseEntity.ok(
          RestResponse.response(HttpStatus.OK, dto, "justification"));
    } catch (EntityNotFoundExceptions ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(RestResponse.response(HttpStatus.NOT_FOUND, ex.getMessage(), "justification"));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(RestResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur interne", "justification"));
    }
  }

  @Override
  public ResponseEntity<Map<String, Object>> validationJustification(String id, Justification justification) {
    throw new UnsupportedOperationException("Unimplemented method 'validationJustification'");
  }
}
