package ism.groupe9.gestion_absence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Absence;
import java.util.List;


public interface AbsenceRepository extends MongoRepository<Absence, String> {
  List<Absence> findByVigileId(String vigileId);
  List<Absence> findByEtudiantId(String etudiantId);

}
