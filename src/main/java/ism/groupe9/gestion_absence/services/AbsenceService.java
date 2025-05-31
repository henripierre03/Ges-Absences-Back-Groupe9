package ism.groupe9.gestion_absence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Absence;

@Service
public interface AbsenceService {
  List<Absence> getAll();

  List<Absence> getByEtudiant(String id);

  Absence save(Absence absence);

  Absence getById(String id);
  List<Absence> getByVigileId(String id);

}
