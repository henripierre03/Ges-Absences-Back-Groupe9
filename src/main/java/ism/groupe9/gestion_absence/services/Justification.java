package ism.groupe9.gestion_absence.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface Justification {
  List<Justification> getAll();
  Justification getByEtudiant(String id);
  Justification getByAbsence(String id);
  Justification save(Justification justification);
  
}
