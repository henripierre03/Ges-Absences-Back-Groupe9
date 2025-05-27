package ism.groupe9.gestion_absence.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/justification")
public interface JustificationController {

  @GetMapping("")
  ResponseEntity <Map<String, Object>> getAll();

  @GetMapping("/{id}")
  ResponseEntity <Map<String, Object>> getById(String id);

  @GetMapping("/absence/{absenceId}")
  ResponseEntity <Map<String, Object>> getByAbsenceId(String absenceId);

  @PutMapping("/{id}")
  ResponseEntity <Map<String, Object>> validationJustification(String id); 
}
