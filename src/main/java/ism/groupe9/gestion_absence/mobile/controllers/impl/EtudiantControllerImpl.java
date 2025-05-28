package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.mobile.controllers.EtudiantController;
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
  public ResponseEntity<Map<String, Object>> getByMatricule(String matricule) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }


  }


  // @Override
  // public ResponseEntity<Map<String, Object>> getAbsencesByEtuduiant(String matricule) {
  //   // TODO Auto-generated method stub
  //   throw new UnsupportedOperationException("Unimplemented method 'getAbsencesByMatricule'");
  // }

