package ism.groupe9.gestion_absence.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ism.groupe9.gestion_absence.data.entities.Absence;

@RequestMapping("/api/web/absence")
public interface AbsenceController {

  @GetMapping("")
  @Operation(summary = "Recuperer toutes les absences", description = "Cette méthode permet de récupérer la liste de toutes les absences.")
  @ApiResponse(responseCode = "200", description = "Liste des absences récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune absence trouvée.")
  ResponseEntity<Map<String, Object>> getAll(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "8") int size
  );

  @GetMapping("/all")
  @Operation(summary = "Recuperer toutes les absences", description = "Cette méthode permet de récupérer la liste de toutes les absences sans la pagination .")
  @ApiResponse(responseCode = "200", description = "Liste des absences récupérée avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune absence trouvée.")
  ResponseEntity<Map<String, Object>> getAllWithoutPaginate();

  @PostMapping("")
  @Operation(summary = "Créer une nouvelle absence", description = "Cette méthode permet de créer une nouvelle absence.")
  @ApiResponse(responseCode = "201", description = "Absence créée avec succès.")
  @ApiResponse(responseCode = "400", description = "Requête invalide, les données fournies ne sont pas valides.")
  @ApiResponse(responseCode = "409", description = "Conflit, l'absence existe déjà.")
  ResponseEntity<Map<String, Object>> create(@RequestBody Absence absenceRequest);

  @GetMapping("/cour/{id}")
  @Operation(summary = "Recuperer les absences d'un cours", description = "Cette méthode permet de récupérer les absences associées à un cours spécifique.")
  @ApiResponse(responseCode = "200", description = "Absences récupérées avec succès.")
  @ApiResponse(responseCode = "404", description = "Aucune absence trouvée pour le cours spécifié.")
  ResponseEntity<Map<String, Object>> getByCourId(@PathVariable String id);

}
