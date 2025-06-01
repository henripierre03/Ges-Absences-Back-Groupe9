package ism.groupe9.gestion_absence.web.controllers.Impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.mobile.mappers.EtudiantMapper;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.controllers.EtudiantController;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantControllerImpl implements EtudiantController {

  private final EtudiantService etudiantService;
  private final EtudiantMapper etudiantMapper;

  @Override
  public ResponseEntity<Map<String, Object>> getAll() {
    var etudiants = etudiantService.getAll();
    var etudiantResponse = etudiants.stream().map(etudiantMapper::toEtudiantAllResponse).toList();
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, etudiantResponse, "etudiantAllResponse"),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByEtudiant(String matricule) {
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

  @Override
  public ResponseEntity<Map<String, Object>> getAbsencesByEtuduiant(String matricule) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAbsencesByMatricule'");
  }

}
