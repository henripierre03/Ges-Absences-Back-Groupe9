package ism.groupe9.gestion_absence.services.Impl;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.mobile.dto.response.PointageSimpleResponse;
import ism.groupe9.gestion_absence.services.PointageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointageServiceImpl implements PointageService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public List<PointageSimpleResponse> getPointagesByMatricule(String matricule, LocalDate date) {
        List<Absence> absences = absenceRepository.findByEtudiantMatriculeAndDate(matricule, date);
        return absences.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PointageSimpleResponse> getPointagesByMatricule(String matricule) {
        List<Absence> absences = absenceRepository.findByEtudiantMatricule(matricule);
        return absences.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    private PointageSimpleResponse mapToResponse(Absence absence) {
        PointageSimpleResponse response = new PointageSimpleResponse();
        response.setDate(absence.getDate());
        response.setTypeAbsence(absence.getTypeAbsence().name()); //
        return response;
    }
}
