package ism.groupe9.gestion_absence.web.dto.request;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JustificationCreateRequest {

  private String id;
  private String etudiantId;
  private Date date;
  private List<String> justificatifs;
  private String justificatif;
  private boolean validation;

}
