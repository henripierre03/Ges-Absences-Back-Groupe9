package ism.groupe9.gestion_absence.mobile.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Représente une requête pour créer une absence d'un étudiant.")

public class AbsenceCreateRequest {
  private String etudiantId;
  private String vigileId;
  private LocalDateTime date;
  private TypeAbsence typeAbsence;
  private String justificationId;
  private String courId;
}
