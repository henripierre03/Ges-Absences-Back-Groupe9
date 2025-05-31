package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
  Admin findByEmail(String email);
}
