package ism.groupe9.gestion_absence.mobile.dto.request;

import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import java.time.LocalDateTime;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Schema(description = "Représente une requête pour créer un pointage d'absence d'un étudiant.")
public class PointageCreateRequest {
    
    private String matricule;
    private LocalDateTime dateHeurePointage;
    private TypeAbsence typeAbsence;
    private String heureDebut;
    private String heureFin;
}
