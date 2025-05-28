package ism.groupe9.gestion_absence.web.dto.response;

import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceAndJustication {

  private String id;
  private String etudiantId;
  private Date date;
  private TypeAbsence absence;
  private String justificationId;

}
