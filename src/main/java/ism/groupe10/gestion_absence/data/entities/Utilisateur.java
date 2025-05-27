package ism.groupe10.gestion_absence.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Utilisateur {

  @Id
  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String password;
  private String role;
}
