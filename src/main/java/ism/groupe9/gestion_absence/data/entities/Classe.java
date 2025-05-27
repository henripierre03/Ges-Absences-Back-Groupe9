package ism.groupe9.gestion_absence.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ism.groupe9.gestion_absence.data.enums.Niveau;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Classe {

  @Id
  private String id;
  private String nom;
  private Niveau niveau;
  
}
