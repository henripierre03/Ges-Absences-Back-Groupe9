package ism.groupe9.gestion_absence.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ism.groupe9.gestion_absence.data.entities.Absence;

@RequestMapping("/api/absence")
public interface AbsenceController {

  @GetMapping("")
  ResponseEntity<Map<String, Object>> getAll();

  @GetMapping("/{id}")
  ResponseEntity<Map<String, Object>> getByEtudiantId(@PathVariable String id);

  @PostMapping
  ResponseEntity<Map<String, Object>> create(@RequestBody Absence absence);

  

}
