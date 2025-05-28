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
import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;

@RequestMapping("/api/absence")
public interface AbsenceController {

  @GetMapping("")
  @Operation(summary = "Recuperer toutes les absences", description = "Cette méthode permet de récupérer la liste de toutes les absences.")
  @ApiResponse(responseCode = "200", description = "Liste des absences récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune absence trouvée.")
  ResponseEntity<Map<String, Object>> getAll();

  @PostMapping("")
  @Operation(summary = "Créer une nouvelle absence", description = "Cette méthode permet de créer une nouvelle absence.")
  @ApiResponse(responseCode = "201", description = "Absence créée avec succès.")
  @ApiResponse(responseCode = "400", description = "Requête invalide, les données fournies ne sont pas valides.")
  @ApiResponse(responseCode = "409", description = "Conflit, l'absence existe déjà.")
  ResponseEntity<Map<String, Object>> create(@RequestBody AbsenceCreateRequest absenceRequest);


}
