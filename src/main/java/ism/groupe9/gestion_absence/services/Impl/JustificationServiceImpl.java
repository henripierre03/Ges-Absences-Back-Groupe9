package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.JustificationRepository;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.utils.exceptions.EntityNotFoundExceptions;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JustificationServiceImpl implements JustificationService {

  private final JustificationRepository justificationRepository;
  private final AbsenceRepository absenceRepository;

  @Override
  public List<Justification> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Justification getByEtudiant(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByEtudiant'");
  }

  @Override
  public Justification getByAbsence(String id) {
    return Optional.ofNullable(justificationRepository.findByAbsenceId(id))
        .orElse(null);
  }

@Override
public Justification create(Justification justification) {
    // Vérifier si l'absence existe
    Absence absence = absenceRepository.findById(justification.getAbsenceId())
        .orElseThrow(() -> new IllegalArgumentException("Absence non trouvée"));

    // Vérifier si une justification existe déjà pour cette absence
    Justification existingJustification = getByAbsence(justification.getAbsenceId());
    if (existingJustification != null) {
        throw new IllegalArgumentException("Cette absence a déjà une justification");
    }

    // Sauvegarder la nouvelle justification
    return justificationRepository.save(justification);
}

}
