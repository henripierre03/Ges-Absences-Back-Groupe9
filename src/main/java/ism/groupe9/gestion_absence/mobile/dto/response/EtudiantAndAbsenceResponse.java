package ism.groupe9.gestion_absence.mobile.dto.response;

import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EtudiantAndAbsenceResponse {

  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String password;
  private UserRole role;
  private String absenceId;

}
