package ism.groupe9.gestion_absence.mobile.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag; 
import ism.groupe9.gestion_absence.mobile.dto.response.PointageSimpleResponse;
import ism.groupe9.gestion_absence.services.PointageService;

@RestController
@RequestMapping("/api/mobile/vigile")
@Tag(name = "Pointage", description = "API de pointage des étudiants")
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @PostMapping("/pointages")
    @Operation(
        summary = "Lister les pointages d’un étudiant",
        description = "Retourne tous les pointages d’un étudiant pour une date précise (ou tous si aucune date n’est donnée)."
    )
    public List<PointageSimpleResponse> getPointagesByMatricule(
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
