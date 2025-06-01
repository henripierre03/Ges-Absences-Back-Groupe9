package ism.groupe9.gestion_absence.mobile.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JustificationResponse {
  private String id;
  private String etudiantId;
  private String absenceId;
  private String date;
  private String message;
  private boolean validation;
  private List<String> justificatifs; // URLs des fichiers
}