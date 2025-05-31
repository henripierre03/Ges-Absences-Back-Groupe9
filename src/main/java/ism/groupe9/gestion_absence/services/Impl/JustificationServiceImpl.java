package ism.groupe9.gestion_absence.services.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.JustificationRepository;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;
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
    Justification justification = justificationRepository.findByAbsenceId(id);
    return justification != null ? justification : null;
  }

  @Override
  public Justification create(Justification justification) {

    Absence absence = absenceRepository.findById(justification.getAbsenceId())
        .orElse(null);
    if (absence == null) {
      return justificationRepository.save(justification);
    }
    throw new IllegalArgumentException("cette absence a déjà une justification");

  }

public JustificationResponse validerJustification(String id) {
    Justification justification = justificationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Justification non trouvée"));

    justification.setValidation(true);
    justificationRepository.save(justification);

    return mapToResponse(justification);
}

private JustificationResponse mapToResponse(Justification justification) {
    JustificationResponse response = new JustificationResponse();
    response.setId(justification.getId());
    response.setDate(justification.getDate());
    response.setJustificatif(justification.getJustificatif());
    response.setValidation(justification.isValidation());
    return response;
}


  



}
