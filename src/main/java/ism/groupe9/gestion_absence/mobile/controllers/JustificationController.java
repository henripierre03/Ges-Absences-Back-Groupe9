package ism.groupe9.gestion_absence.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api/justification")
public interface JustificationController {

  @GetMapping("/absence/{absenceId}")
  @Operation(summary = "Recuperer la justification par absence", description = "Cette méthode permet de récupérer la justification associée à une absence spécifique.")
  @ApiResponse(responseCode = "200", description = "Justification récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune justification trouvée pour l'absence spécifiée.")
  ResponseEntity<Map<String, Object>> getByAbsenceId(String absenceId);

}
