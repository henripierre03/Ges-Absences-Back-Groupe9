package ism.groupe9.gestion_absence.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ism.groupe9.gestion_absence.data.entities.Etudiant;

@RequestMapping("/api/etudiant")
public interface EtudiantController {

  @GetMapping("")
  @Operation(summary = "Recuperer tous les étudiants", description = "Cette méthode permet de récupérer la liste de tous les étudiants.")
  @ApiResponse(responseCode = "200", description = "Liste des étudiants récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucun étudiant trouvé.")
  ResponseEntity<Map<String, Object>> getAll();

  @GetMapping("/{matricule}")
  ResponseEntity<Map<String, Object>> getByEtudiant(@Parameter(description = "Matricule de l'etudiant",required = true) @PathVariable String matricule);

  @PostMapping
  @Operation(summary = "Créer un nouvel étudiant", description = "Cette méthode permet de créer un nouvel étudiant.")
  @ApiResponse(responseCode = "201", description = "Étudiant créé avec succès.")
  @ApiResponse(responseCode = "400", description = "Requête invalide, les données fournies ne sont pas valides.")
  @ApiResponse(responseCode = "409", description = "Conflit, l'étudiant existe déjà.")
  ResponseEntity<Map<String, Object>> create(@RequestBody Etudiant etudiant);

  @PutMapping("/{id}")
  ResponseEntity<Map<String, Object>> update(@PathVariable String id, @RequestBody Etudiant etudiant);

  @DeleteMapping("/{id}")
  ResponseEntity<Map<String, Object>> delete(@PathVariable String id);

  @GetMapping("/absence/{matricule}")
  ResponseEntity<Map<String, Object>> getAbsencesByEtuduiant(@PathVariable String matricule);

}
