package ism.groupe9.gestion_absence.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class User {

  @Id
  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String password;
  private UserRole role;
}
