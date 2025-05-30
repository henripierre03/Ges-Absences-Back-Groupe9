package ism.groupe9.gestion_absence.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ism.groupe9.gestion_absence.mobile.dto.request.JustificationCreateRequest;

@RequestMapping("/api/mobile/justification")
public interface MobileJustificationController {

  @GetMapping("/absence/{absenceId}")
  @Operation(summary = "Recuperer la justification par absence", description = "Cette méthode permet de récupérer la justification associée à une absence spécifique.")
  @ApiResponse(responseCode = "200", description = "Justification récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune justification trouvée pour l'absence spécifiée.")
  ResponseEntity<Map<String, Object>> getByAbsenceId(String absenceId);

  @PostMapping("/absence/{absenceId}")
  @Operation(summary = "Créer une nouvelle justification", description = "Cette méthode permet de créer une nouvelle justification d'absence pour un étudiant.")
  @ApiResponse(responseCode = "201", description = "Justification creee avec succes.")
  @ApiResponse(responseCode = "400", description = "Requete invalide, les donnees fournies ne sont pas valides.")
  @ApiResponse(responseCode = "409", description = "Conflit, la justification existe deja.")
  ResponseEntity<Map<String, Object>> create (@PathVariable String absenceId , @RequestBody JustificationCreateRequest request);

}
