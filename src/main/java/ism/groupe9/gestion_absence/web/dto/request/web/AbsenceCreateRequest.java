package ism.groupe9.gestion_absence.web.dto.request.web;

import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceCreateRequest {

  private String id;
  private String etudiantId;
  private Date date;
  private TypeAbsence typeAbsence;
  private String justificationId;
  private String courId;

}
