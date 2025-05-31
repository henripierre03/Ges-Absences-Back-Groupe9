package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.mobile.controllers.MobileEtudiantController;
import ism.groupe9.gestion_absence.mobile.mappers.EtudiantMapper;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MobileEtudiantControllerImpl implements MobileEtudiantController {

  private final EtudiantService etudiantService;
  private final EtudiantMapper etudiantMapper;

  @Override
  public ResponseEntity<Map<String, Object>> getAll(User userConnect) {
    var etudiants = etudiantService.getAll();
    var etudiantResponse = etudiants.stream().map(etudiantMapper::toEtudiantAllResponse).toList();
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, etudiantResponse, "etudiantAllResponse"),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> getByMatricule(String matricule) {
    var etudiant = etudiantService.getByMatricule(matricule);
    if (etudiant == null) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "string"),
          HttpStatus.NOT_FOUND);
    }
    var etudiantResponse = etudiantMapper.toEtudiantSimpleResponse(etudiant);
    return new ResponseEntity<>(
        RestResponse.response(HttpStatus.OK, etudiantResponse, "etudiantSimpleResponse"),
        HttpStatus.OK);

  }

}
