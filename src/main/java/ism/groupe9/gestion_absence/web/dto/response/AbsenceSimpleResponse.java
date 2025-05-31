package ism.groupe9.gestion_absence.web.dto.response;

import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceSimpleResponse {

  private String id;
  private Date date;
  private TypeAbsence typeAbsence;
  private String courId;
}
