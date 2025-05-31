package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.services.AbsenceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AbsenceServiceImpl implements AbsenceService {

  private final AbsenceRepository absenceRepository;

  @Override
  public List<Absence> getAll() {
    return absenceRepository.findAll();
  }

  @Override
  public List<Absence> getByEtudiant(String id) {
    return absenceRepository.findByEtudiantId(id);
  }

  @Override
  public Absence save(Absence absence) {
    return absenceRepository.save(absence);
  }

  @Override
  public Absence getById(String id) {
    return absenceRepository.findById(id).orElse(null);
  }

  @Override
  public List<Absence> getByVigileId(String id) {
    return absenceRepository.findByVigileId(id);
  }

}
