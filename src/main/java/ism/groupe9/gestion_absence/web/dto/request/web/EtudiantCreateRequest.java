package ism.groupe9.gestion_absence.web.dto.request.web;

import java.util.List;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.enums.Niveau;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EtudiantCreateRequest {

  private String matricule;
  private Niveau niveau;
  private String classeId;
  private List<Absence> absences;

}
