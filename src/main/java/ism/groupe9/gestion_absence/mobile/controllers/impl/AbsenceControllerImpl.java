package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.web.controllers.AbsenceController;
@RestController
public class AbsenceControllerImpl implements AbsenceController {
  private final AbsenceService absenceService;
  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
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

  public ResponseEntity<Map<String, Object>> getAbsencesByEtudiantId(String id) {
    List<Absence> absences = absenceService.getByEtudiant(id);

    if (absences.isEmpty()) {
      return ResponseEntity.status(404).body(Map.of("message", "Aucune absence trouvée pour cet étudiant."));
    }

    return ResponseEntity.ok(Map.of("absences", absences));
  }
  @Autowired
  public AbsenceControllerImpl(AbsenceService absenceService) {
    this.absenceService = absenceService;
  };
}
