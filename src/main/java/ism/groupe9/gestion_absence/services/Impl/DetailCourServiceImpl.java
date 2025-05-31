package ism.groupe9.gestion_absence.services.Impl;

import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.repositories.DetailCourRepository;
import ism.groupe9.gestion_absence.services.DetailCourService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class DetailCourServiceImpl implements DetailCourService {

  private final DetailCourRepository detailCourRepository;

  @Override
  public DetailCour getDetailCourById(String id) {
    return detailCourRepository.findById(id)
        .orElse(null);

  }

}
