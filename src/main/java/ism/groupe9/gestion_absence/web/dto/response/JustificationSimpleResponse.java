package ism.groupe9.gestion_absence.web.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JustificationSimpleResponse {

  private String id;
  private String message;
  private boolean validation;
  private List<String> justificatifs;
  
}
