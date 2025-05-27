package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Etudiant;

public interface EtudiantRepository extends MongoRepository<Etudiant,String> {
  
  
}
