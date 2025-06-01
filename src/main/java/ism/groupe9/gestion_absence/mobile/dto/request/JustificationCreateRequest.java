package ism.groupe9.gestion_absence.mobile.dto.request;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Schema(description = "Représente une requête pour créer une justification d'absence d'un étudiant.")
public class JustificationCreateRequest {

  private String id;
  private String etudiantId;
  private String absenceId;
  private Date date;
  private String message;
  private List<String> justificatifs;
  private boolean validation;

}
