package ism.groupe9.gestion_absence.data.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Cours;

public interface CourRepository extends MongoRepository<Cours, String> {

}
