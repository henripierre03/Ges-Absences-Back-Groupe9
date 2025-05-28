package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Justification;

public interface JustificationRepository extends MongoRepository<Justification, String> {
  
}
