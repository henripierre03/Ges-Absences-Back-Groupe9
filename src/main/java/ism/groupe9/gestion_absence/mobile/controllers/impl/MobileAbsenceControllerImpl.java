package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.controllers.MobileAbsenceController;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;
import ism.groupe9.gestion_absence.mobile.mappers.AbsenceMapper;
import ism.groupe9.gestion_absence.mobile.mappers.AbsenceMapperManuel;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MobileAbsenceControllerImpl implements MobileAbsenceController {

  private final AbsenceMapper absenceMapper;
  private final AbsenceService absenceService;
  private final AbsenceMapperManuel absenceMapperManuel;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> create(AbsenceCreateRequest absenceRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
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

}
