package ism.groupe9.gestion_absence.services;

import java.util.List;

import ism.groupe9.gestion_absence.data.entities.Etudiant;

public interface EtudiantService {

  List<Etudiant> getAll();
  Etudiant update(Etudiant etudiant);
  Etudiant getById(String id);
  Etudiant save(Etudiant etudiant);
  
}
