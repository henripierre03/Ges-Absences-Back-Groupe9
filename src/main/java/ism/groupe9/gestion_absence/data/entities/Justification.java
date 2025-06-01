package ism.groupe9.gestion_absence.data.entities;

import java.time.LocalDateTime;

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
  private String absenceId;
  private LocalDateTime date;
  private String message;
  private boolean validation;
}
