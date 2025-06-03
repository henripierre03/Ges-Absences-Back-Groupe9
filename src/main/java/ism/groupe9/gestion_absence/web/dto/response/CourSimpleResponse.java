package ism.groupe9.gestion_absence.web.dto.response;

import ism.groupe9.gestion_absence.data.enums.Module;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourSimpleResponse {

  private String id;
  private Module module;
  private SalleSimpleResponse salle;
}
