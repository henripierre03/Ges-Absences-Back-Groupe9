package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.controllers.MobileAbsenceController;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;

@RestController
public class MobileAbsenceControllerImpl implements MobileAbsenceController {

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

}
