package ism.groupe9.gestion_absence.services;

import java.util.List;

import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.entities.Etudiant;

public interface EtudiantService {

  List<Etudiant> getAll();

  Etudiant update(String id, Etudiant etudiant);

  Etudiant getById(String id);

  Etudiant save(Etudiant etudiant);

  Etudiant getByMatricule(String matricule);

  // Etudiant pointage(String matricule);

  DetailCour getProchainCoursAujourdHui(String matricule);
}
