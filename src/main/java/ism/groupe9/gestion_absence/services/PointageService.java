package ism.groupe9.gestion_absence.services;

import ism.groupe9.gestion_absence.mobile.dto.response.PointageSimpleResponse;

import java.time.LocalDate;
import java.util.List;

public interface PointageService {
    List<PointageSimpleResponse> getPointagesByMatricule(String matricule, LocalDate date);
    List<PointageSimpleResponse> getPointagesByMatricule(String matricule);
}