package ism.groupe9.gestion_absence.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Etudiant extends User {

  @Id
  private String id;
  @Field("nom")
  private String nom;
  private String prenom;
  private String email;
  private String password;
}
