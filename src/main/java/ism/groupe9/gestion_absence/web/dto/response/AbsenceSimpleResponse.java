package ism.groupe9.gestion_absence.web.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder
public class AbsenceSimpleResponse {

  private String id;
  private LocalDateTime date;
  private TypeAbsence typeAbsence;
  private CourSimpleResponse cours;
}
