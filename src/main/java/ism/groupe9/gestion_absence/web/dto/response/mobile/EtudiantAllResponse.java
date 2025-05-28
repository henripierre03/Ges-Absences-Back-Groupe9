package ism.groupe9.gestion_absence.web.dto.response.mobile;

import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EtudiantAllResponse {
  
  private String id;
  private String nom;
  private String prenom;
  private UserRole role;
  
}
