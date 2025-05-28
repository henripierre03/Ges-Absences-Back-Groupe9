package ism.groupe9.gestion_absence.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import ism.groupe9.gestion_absence.data.enums.Niveau;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Etudiant extends User {

  private String matricule;
  private Niveau niveau;
  private String classeId;
  private List<Absence> absences = new ArrayList<>();

  public void addAbsence(Absence absence) {

    this.absences.add(absence);
  }

}
