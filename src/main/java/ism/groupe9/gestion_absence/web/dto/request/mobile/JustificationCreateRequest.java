package ism.groupe9.gestion_absence.web.dto.request.mobile;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JustificationCreateRequest {

  private String id;
  private String etudiantId;
  private Date date;
  private String justificatif;
  private boolean validation;

}
