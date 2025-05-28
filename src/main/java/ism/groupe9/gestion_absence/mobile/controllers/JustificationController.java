package ism.groupe9.gestion_absence.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ism.groupe9.gestion_absence.data.entities.Justification;

@RequestMapping("/api/justification")
public interface JustificationController {

  @GetMapping("")
  @Operation(summary = "Recuperer toutes les justifications", description = "Cette méthode permet de récupérer la liste de toutes les justifications.")
  @ApiResponse(responseCode = "200", description = "Liste des justifications récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune justification trouvée.")
  ResponseEntity<Map<String, Object>> getAll();

  @GetMapping("/absence/{absenceId}")
  @Operation(summary = "Recuperer la justification par absence", description = "Cette méthode permet de récupérer la justification associée à une absence spécifique.")
  @ApiResponse(responseCode = "200", description = "Justification récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune justification trouvée pour l'absence spécifiée.")
  ResponseEntity<Map<String, Object>> getByAbsenceId(String absenceId);

  @PutMapping("/{id}")
  @Operation(summary = "Valider la justification", description = "Cette méthode permet de valider une justification d'absence.")
  @ApiResponse(responseCode = "200", description = "Justification validée avec succès.")
  @ApiResponse(responseCode = "404", description = "Justification non trouvée ou déjà validée.")
  @ApiResponse(responseCode = "400", description = "Requête invalide, les données fournies ne sont pas valides.")
  ResponseEntity<Map<String, Object>> validationJustification(String id, @RequestBody Justification justification);
}
