package ism.groupe9.gestion_absence.data.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Etudiant extends User {

  private String matricule;
}
