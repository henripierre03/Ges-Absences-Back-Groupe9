package ism.groupe9.gestion_absence.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JustificationUpdateRequest {
  
  private String id;
  private boolean validation;
}
