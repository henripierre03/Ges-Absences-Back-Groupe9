package ism.groupe9.gestion_absence.mobile.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Schema(description = "Représente une requête pour créer un pointage d'absence d'un étudiant.")
public class PointageCreateRequest {
    
    // private String matricule;
    // private LocalDateTime dateHeurePointage;
    // private TypeAbsence typeAbsence;
    // private String heureDebut;
    // private String heureFin;

    @Schema(description = "Matricule de l'étudiant à pointer", example = "ETU12345")
    private String matricule;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
}
