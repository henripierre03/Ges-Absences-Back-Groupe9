package ism.groupe9.gestion_absence.data.repositories;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Absence;

public interface AbsenceRepository extends MongoRepository<Absence, String> {


  List<Absence> findByEtudiantMatricule(String matricule);
  List<Absence> findByEtudiantMatriculeAndDate(String matricule, LocalDate date);

  // Define custom query methods if needed
  // For example, to find absences by student ID or date range
  List<Absence> findByEtudiantId(String etudiantId);


}
