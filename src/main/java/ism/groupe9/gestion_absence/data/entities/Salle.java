package ism.groupe9.gestion_absence.data.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Salle {
  @Id
  private String id;
  private String nom;
  private String capacite;
  private List<Cours> cours;
}
