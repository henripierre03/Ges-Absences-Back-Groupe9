package ism.groupe9.gestion_absence.mobile.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ism.groupe9.gestion_absence.mobile.dto.request.PointageCreateRequest;
import ism.groupe9.gestion_absence.mobile.dto.response.PointageSimpResponse;
import ism.groupe9.gestion_absence.services.PointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vigile")
@Tag(name = "Pointage", description = "API de pointage des étudiants")
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @PostMapping("/pointages")
    @Operation(
        summary = "Lister les pointages d’un étudiant",
        description = "Retourne tous les pointages d’un étudiant pour une date précise (ou tous si aucune date n’est donnée)."
    )
    public List<PointageSimpResponse> getPointagesByMatricule(
            @RequestParam String matricule,
            @RequestParam(required = false) String date
    ) {
        if (date != null) {
            return pointageService.getPointagesByMatricule(matricule, LocalDate.parse(date));
        } else {
            return pointageService.getPointagesByMatricule(matricule);
        }
    }
}
