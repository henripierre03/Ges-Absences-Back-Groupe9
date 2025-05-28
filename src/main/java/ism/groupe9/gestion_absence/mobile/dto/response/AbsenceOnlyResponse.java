package ism.groupe9.gestion_absence.mobile.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AbsenceOnlyResponse {

  private String id;
  private LocalDateTime date;
}
