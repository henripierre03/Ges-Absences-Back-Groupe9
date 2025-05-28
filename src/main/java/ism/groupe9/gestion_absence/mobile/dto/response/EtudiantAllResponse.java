package ism.groupe9.gestion_absence.mobile.dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import ism.groupe9.gestion_absence.data.enums.Filiere;
import ism.groupe9.gestion_absence.data.enums.Niveau;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Schema(description = "Représente un étudiant avec des informations détaillées pour les réponses mobiles.")
public class EtudiantAllResponse {

  private String id;
  private String nom;
  private String prenom;
  private String matricule;
  private String email;
  private UserRole role;
  private Filiere filiere;
  private Niveau niveau;
  private List<AbsenceOnlyResponse> absences;

}
