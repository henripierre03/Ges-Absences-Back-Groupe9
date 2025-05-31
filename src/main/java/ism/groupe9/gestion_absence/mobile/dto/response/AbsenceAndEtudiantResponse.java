package ism.groupe9.gestion_absence.mobile.dto.response;

import java.util.Date;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AbsenceAndEtudiantResponse {

  private String id;
  private Date date;
  private TypeAbsence typeAbsence;
  private String courId;
  // private String etudiantId;
  private EtudiantAllResponse etudiant;
}
