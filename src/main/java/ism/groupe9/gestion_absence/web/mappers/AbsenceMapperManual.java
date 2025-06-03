package ism.groupe9.gestion_absence.web.mappers;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.services.CourService;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.web.dto.response.AbsenceAndEtudiantResponse;
import ism.groupe9.gestion_absence.web.dto.response.AbsenceAndJustication;
import ism.groupe9.gestion_absence.web.dto.response.AbsenceSimpleResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbsenceMapperManual {
  private final EtudiantMapper etudiantMapper;
  private final JustificationMapper justificationMapper;
  private final EtudiantService etudiantService;
  private final JustificationService justificationService;
  private final CourService courService;
  private final CourMapperManual courMapper;
  private final CourMapper courMapper2;

  public AbsenceAndJustication toAbsenceAndJustification(Absence absence) {
    AbsenceAndJustication response = new AbsenceAndJustication();
    response.setId(absence.getId());
    response.setJustificationId(absence.getJustificationId());
    Etudiant etudiant = etudiantService.getById(absence.getEtudiantId());
    response.setEtudiantId(etudiantMapper.toEtudiantAllResponse(etudiant).getId());
    response.setDate(Date.from(absence.getDate().atZone(ZoneId.systemDefault()).toInstant()));
    response.setAbsence(absence.getTypeAbsence());
    return response;
  }

  public AbsenceAndEtudiantResponse toAbsenceAndEtudiantResponse(Absence absence) {
    var etudiant = etudiantService.getById(absence.getEtudiantId());
    var builder = AbsenceAndEtudiantResponse.builder()
        .id(absence.getId())
        .date(Date.from(absence.getDate().atZone(ZoneId.systemDefault()).toInstant()))
        .typeAbsence(absence.getTypeAbsence())
        .etudiant(etudiantMapper.toEtudiantAllResponse(etudiant));

    var justification = justificationService.getByAbsence(absence.getId());
    if (justification != null) {
      builder.justification(justificationMapper.toJustificationSimpleResponse(justification));
    }
    var cour = courService.getById(absence.getCourId());
    if (cour != null) {
      builder.cour(courMapper2.toCourSimpleResponse(cour));
    }

    return builder.build();
  }

  AbsenceSimpleResponse toAbsenceSimpleResponse(Absence absence) {
    if (absence == null) {
      return null;
    }

    return AbsenceSimpleResponse.builder()
        .id(absence.getId())
        .date(absence.getDate())
        .typeAbsence(absence.getTypeAbsence())
        .cours(courMapper.toCourSimpleResponse(courService.getById(absence.getCourId())))
        .build();

  }
}
