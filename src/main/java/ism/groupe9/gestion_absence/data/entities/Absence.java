package ism.groupe9.gestion_absence.data.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Absence {

  @Id
  private String id;
  private String etudiantId;
  private String vigileId;
  private LocalDateTime date;
  private TypeAbsence typeAbsence;
  private String justificationId;
  private String courId;
  private boolean hasJustification;
}
