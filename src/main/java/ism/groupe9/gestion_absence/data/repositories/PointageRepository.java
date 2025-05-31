package ism.groupe9.gestion_absence.data.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import ism.groupe9.gestion_absence.data.entities.Absence;

public interface PointageRepository extends MongoRepository<Absence, String> {

    // Méthode pour trouver un pointage par étudiant et date
    Absence findByEtudiantIdAndDate(String etudiantId, LocalDate date);

    // Méthode pour compter les pointages d'un étudiant pour une date donnée
    long countByEtudiantIdAndDate(String etudiantId, LocalDate date);
    
}

