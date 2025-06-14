package ism.groupe9.gestion_absence.web.controllers.Impl;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.web.controllers.AbsenceController;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import ism.groupe9.gestion_absence.web.mappers.AbsenceMapperManual;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AbsenceControllerImpl implements AbsenceController {

  private final AbsenceMapperManual absenceMapper;
  private final AbsenceService absenceService;

  @Override
  public ResponseEntity<Map<String, Object>> getAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    var absences = absenceService.getAll(pageable);
    var absenceResponse = absences.stream()
        .map(absenceMapper::toAbsenceAndEtudiantResponse)
        .toList();
    var totalPage = absences.getTotalPages();
    return new ResponseEntity<>(
        RestResponse.responsePaginate(HttpStatus.OK, absenceResponse, "absenceAndJustificationList", new int[totalPage],
            absences.getNumber(), totalPage, absences.getTotalElements(), absences.isFirst(), absences.isLast()),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> create(Absence absenceRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByCourId(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByCourId'");
  }

}
