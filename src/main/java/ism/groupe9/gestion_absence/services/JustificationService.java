package ism.groupe9.gestion_absence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;

@Service
public interface JustificationService {
  List<Justification> getAll();
  Justification getByEtudiant(String id);
  Justification getByAbsence(String id);
  Justification create(Justification justification);
  JustificationResponse validerJustification(String id);


  
}
