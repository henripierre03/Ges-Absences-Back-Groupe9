package ism.groupe9.gestion_absence.data.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Justification {
  
  @Id
  private String id;
  private String etudiantId;
  private Date date;
  private String justificatif;
  private boolean validation;
}
