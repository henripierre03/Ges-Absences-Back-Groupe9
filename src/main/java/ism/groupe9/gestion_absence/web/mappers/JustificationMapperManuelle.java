package ism.groupe9.gestion_absence.web.mappers;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.services.AbsenceService;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JustificationMapperManuelle {

  private final EtudiantService etudiantService;
  private final AbsenceService absenceService;
  private final AbsenceMapperManual absenceMapper;
  private final EtudiantMapperManual etudiantMapper;

  public JustificationResponse toJustificationResponse(Justification justification) {
    if (justification == null) {
      return null;
    }

    return JustificationResponse.builder()
        .id(justification.getId())
        .date(justification.getDate())
        .message(justification.getMessage())
        .justificatifs(justification.getJustificatifs())
        .validation(justification.isValidation())
        .etudiant(etudiantMapper.toEtudiantSimpleResponse(
            etudiantService.getById(justification.getEtudiantId())))
        .absence(absenceMapper.toAbsenceSimpleResponse(
            absenceService.getById(justification.getAbsenceId())))
        .build();

  }

}
