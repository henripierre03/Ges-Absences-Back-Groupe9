package ism.groupe9.gestion_absence.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ism.groupe9.gestion_absence.data.entities.Etudiant;

@RequestMapping("/api/etudiant")
public interface EtudiantController {
  
  @GetMapping("")
  ResponseEntity<Map<String, Object>> getAll();

  @GetMapping("/{id}")
  ResponseEntity<Map<String, Object>> getById(@PathVariable String id);

  @PostMapping
  ResponseEntity<Map<String, Object>> create(@RequestBody Etudiant etudiant);

  @PutMapping("/{id}")
  ResponseEntity<Map<String, Object>> update(@PathVariable String id, @RequestBody Etudiant etudiant);

  @DeleteMapping("/{id}")
  ResponseEntity<Map<String, Object>> delete(@PathVariable String id);
}
