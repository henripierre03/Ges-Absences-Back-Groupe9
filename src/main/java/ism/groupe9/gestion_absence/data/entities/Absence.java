package ism.groupe9.gestion_absence.data.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Absence {
  
  private String id;
  private String etudiantId;
  private String date;
  private String justificationId;
  private String validation;
}
