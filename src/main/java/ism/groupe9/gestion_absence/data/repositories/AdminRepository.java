package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ism.groupe9.gestion_absence.data.entities.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
  Admin findByEmail(String email);
}
