package ism.groupe9.gestion_absence.data.entities;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ism.groupe9.gestion_absence.data.enums.Module;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Cours {

  @Id
  private String id;
  private Module module;
  private List<DetailCour> detailCours;
  private String salleId;

}
