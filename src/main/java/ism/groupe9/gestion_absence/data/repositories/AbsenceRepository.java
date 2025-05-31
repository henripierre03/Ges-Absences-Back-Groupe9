package ism.groupe9.gestion_absence.data.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Absence;

public interface AbsenceRepository extends MongoRepository<Absence, String> {

  List<Absence> findByEtudiantMatricule(String matricule);
  List<Absence> findByEtudiantMatriculeAndDate(String matricule, LocalDate date);

}
