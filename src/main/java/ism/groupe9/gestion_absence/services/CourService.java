package ism.groupe9.gestion_absence.services;

import java.time.LocalDateTime;
import java.util.List;

import ism.groupe9.gestion_absence.data.entities.Cours;

public interface CourService {
  List<Cours> getAllCours();

  List<Cours> getCoursTerminer(LocalDateTime maintenant, String classeId);

  void marquerAbsencesPourCoursTermines(LocalDateTime maintenant, String classeId);

  Cours getById(String id);
}
