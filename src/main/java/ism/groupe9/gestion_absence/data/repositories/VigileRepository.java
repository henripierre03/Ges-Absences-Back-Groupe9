package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Vigile;


public interface VigileRepository extends MongoRepository<Vigile, String> {
  Vigile findByEmail(String email);
}
