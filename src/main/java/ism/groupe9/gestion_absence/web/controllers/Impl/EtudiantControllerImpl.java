package ism.groupe9.gestion_absence.web.controllers.Impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.controllers.EtudiantController;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EtudiantControllerImpl implements EtudiantController {

  private final EtudiantService etudiantService;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, etudiantService.getAll(), "Etudiants"),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> getById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> create(Etudiant etudiant) {
    var response = etudiantService.save(etudiant);
    return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, response, "Etudiant"), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Map<String, Object>> update(String id, Etudiant etudiant) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public ResponseEntity<Map<String, Object>> delete(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
