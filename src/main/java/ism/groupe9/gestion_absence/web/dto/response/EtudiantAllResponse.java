package ism.groupe9.gestion_absence.web.dto.response;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.enums.Filiere;
import ism.groupe9.gestion_absence.data.enums.Niveau;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EtudiantAllResponse {

  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String password;
  private UserRole role;
  private Filiere filiere;
  private Niveau niveau;
  private String classeId;

}
