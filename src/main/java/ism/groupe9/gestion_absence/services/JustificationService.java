package ism.groupe9.gestion_absence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Justification;

@Service
public interface JustificationService {
  List<Justification> getAll();
  Justification getByEtudiant(String id);
  Justification getByAbsence(String id);
  Justification create(Justification justification);
  
}
