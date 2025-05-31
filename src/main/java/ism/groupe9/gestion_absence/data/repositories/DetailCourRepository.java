package ism.groupe9.gestion_absence.data.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.DetailCour;

public interface DetailCourRepository extends MongoRepository<DetailCour, String> {
  List<DetailCour> findByCourId(String courId);

}
