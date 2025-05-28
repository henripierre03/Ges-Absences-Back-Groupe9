package ism.groupe9.gestion_absence.mobile.dto.response;
import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceAndJusticationResponse {

  private String id;
  private String etudiantId;
  private Date date;
  private TypeAbsence absence;
  private JustificationResponse justification;

}
