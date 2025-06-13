package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.zxing.NotFoundException;

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

  @Override
  public List<Absence> getByEtudiantId(String id) {
    return absenceRepository.findByEtudiantId(id);
  }

  @Override
  public Absence update(String id, Absence absence) {
    return absenceRepository.findById(id)
        .map(existingAbsence -> {
          existingAbsence.setDate(absence.getDate());
          existingAbsence.setCourId(absence.getCourId());
          existingAbsence.setEtudiantId(absence.getEtudiantId());
          existingAbsence.setVigileId(absence.getVigileId());
          existingAbsence.setTypeAbsence(absence.getTypeAbsence());
          existingAbsence.setHasJustification(absence.isHasJustification());
          existingAbsence.setJustificationId(absence.getJustificationId());

          return absenceRepository.save(existingAbsence);
        })
        .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
  }

}
