package ism.groupe9.gestion_absence.web.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder
public class JustificationResponse {

  private String id;
  private LocalDateTime date;
  private String message;
  private List<String> justificatifs;
  private boolean validation;
  private EtudiantSimpleResponse etudiant;
  private AbsenceSimpleResponse absence;

}
