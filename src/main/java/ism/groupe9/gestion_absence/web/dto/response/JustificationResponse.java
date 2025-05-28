package ism.groupe9.gestion_absence.web.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JustificationResponse {
  
  private String id;
  private Date date;
  private String justificatif;
  private boolean validation;

}
