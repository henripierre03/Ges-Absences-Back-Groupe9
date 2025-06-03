package ism.groupe9.gestion_absence.web.dto.response;

import ism.groupe9.gestion_absence.data.enums.Module;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourSimpleResponse {
  
  private String id;
  private Module module;
  private String salleId;
}
