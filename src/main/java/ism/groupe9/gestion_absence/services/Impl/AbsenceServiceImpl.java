package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;


public class AbsenceServiceImpl {
@Autowired
private AbsenceRepository absenceRepository;


public List<Absence> getByEtudiant(String id) {
    return absenceRepository.findByEtudiantId(id);
}

}
