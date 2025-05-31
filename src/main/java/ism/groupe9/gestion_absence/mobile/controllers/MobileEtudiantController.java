package ism.groupe9.gestion_absence.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.mobile.dto.request.PointageRequest;

@RequestMapping("/api/mobile/etudiant")

public interface MobileEtudiantController {


  @GetMapping("")
  @Operation(summary = "Recuperer tous les étudiants", description = "Cette méthode permet de récupérer la liste de tous les étudiants.")
  @ApiResponse(responseCode = "200", description = "Liste des étudiants récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucun étudiant trouvé.")
  ResponseEntity<Map<String, Object>> getAll(User userConnect);

  @GetMapping("/{matricule}")
  ResponseEntity<Map<String, Object>> getByMatricule(
      @Parameter(description = "Matricule de l'etudiant", required = true) @PathVariable String matricule);

  @PostMapping("/pointage")
  @Operation(summary = "Pointage de l'étudiant", description = "Cette méthode permet de récupérer les informations de l'étudiant pointé par un vigile.")
    ResponseEntity<Map<String, Object>> pointageEtudiant(@RequestBody PointageRequest request);

}

