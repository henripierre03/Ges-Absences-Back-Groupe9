package ism.groupe9.gestion_absence.web.mappers;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.mobile.dto.response.AbsenceAndEtudiantResponse;
import ism.groupe9.gestion_absence.mobile.mappers.EtudiantMapper;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.services.JustificationService;
import ism.groupe9.gestion_absence.web.dto.response.AbsenceAndJustication;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbsenceMapperManual {
    private final EtudiantMapper etudiantMapper;
    private final JustificationMapperMobile justificationMapper;
    private final EtudiantService etudiantService;
    private final JustificationService justificationService;

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
    
        return builder.build();
    }

}
