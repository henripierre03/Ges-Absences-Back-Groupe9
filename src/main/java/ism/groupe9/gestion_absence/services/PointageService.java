package ism.groupe9.gestion_absence.services;

import ism.groupe9.gestion_absence.mobile.dto.response.PointageSimpResponse;

import java.time.LocalDate;
import java.util.List;

public interface PointageService {
    List<PointageSimpResponse> getPointagesByMatricule(String matricule, LocalDate date);
    List<PointageSimpResponse> getPointagesByMatricule(String matricule);
}