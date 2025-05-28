package ism.groupe9.gestion_absence.web.dto.request.mobile;
import java.time.LocalDateTime;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceCreateRequest {

  private String id;
  private String etudiantId;
  private LocalDateTime date;
  private TypeAbsence typeAbsence;
  private String justificationId;
  private String courId;

}
