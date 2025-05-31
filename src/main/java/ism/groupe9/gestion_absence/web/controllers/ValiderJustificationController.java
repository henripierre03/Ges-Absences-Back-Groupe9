package ism.groupe9.gestion_absence.web.controllers;


import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/justification")
@RequiredArgsConstructor
public class ValiderJustificationController {

    private final JustificationService justificationService;

    @PutMapping("/valider/{id}")
    public ResponseEntity<JustificationResponse> validerJustification(@PathVariable String id) {
        JustificationResponse justificationValidee = justificationService.validerJustification(id);
        return ResponseEntity.ok(justificationValidee);
    }
}