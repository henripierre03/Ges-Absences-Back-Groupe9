package ism.groupe9.gestion_absence.web.dto.request;

import java.util.List;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.enums.Filiere;
import ism.groupe9.gestion_absence.data.enums.Niveau;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EtudiantCreateRequest {

  private String id;
  private String nom;
  private String prenom;
  private String email;
  private String password;
  private UserRole role;
  private Filiere filiere;
  private String matricule;
  private Niveau niveau;
  private String classeId;
  private List<Absence> absences;

}
