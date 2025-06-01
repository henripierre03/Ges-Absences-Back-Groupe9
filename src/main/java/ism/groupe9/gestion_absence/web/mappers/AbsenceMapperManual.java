package ism.groupe9.gestion_absence.web.mappers;

import java.time.ZoneId;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.services.EtudiantService;
import ism.groupe9.gestion_absence.web.dto.response.AbsenceAndJustication;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AbsenceMapperManual {
    private final EtudiantMapperMobile etudiantMapper;
    private final EtudiantService etudiantService;

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

}
