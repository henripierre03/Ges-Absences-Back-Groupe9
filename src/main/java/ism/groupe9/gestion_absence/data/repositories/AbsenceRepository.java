package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Absence;

public interface AbsenceRepository extends MongoRepository<Absence, String> {

  // Define custom query methods if needed
  // For example, to find absences by student ID or date range

}
