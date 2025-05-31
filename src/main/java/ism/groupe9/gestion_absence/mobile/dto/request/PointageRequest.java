package ism.groupe9.gestion_absence.mobile.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointageRequest {

  private String matricule;
  private String vigileId;
  private String date;

}
