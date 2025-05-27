package ism.groupe9.gestion_absence.data.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Absence {
  
  @Id
  private String id;
  
  private Etudiant etudiant;
  private Date date;
  private String justificationId;
  private String validation;
}
