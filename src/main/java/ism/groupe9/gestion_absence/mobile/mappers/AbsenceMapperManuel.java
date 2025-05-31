package ism.groupe9.gestion_absence.mobile.mappers;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.dto.response.AbsenceAndEtudiantResponse;
import ism.groupe9.gestion_absence.services.EtudiantService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbsenceMapperManuel {
  private final EtudiantService etudiantService;
  private final EtudiantMapper etudiantMapper;

  public AbsenceAndEtudiantResponse toAbsenceAndEtudiantResponse(Absence absence) {
    var etudiant = etudiantService.getById(absence.getEtudiantId());
    return AbsenceAndEtudiantResponse.builder()
        .id(absence.getId())
        .typeAbsence(absence.getTypeAbsence())
        .etudiant(etudiantMapper.toEtudiantAllResponse(etudiant))
        .build();
  }
}
