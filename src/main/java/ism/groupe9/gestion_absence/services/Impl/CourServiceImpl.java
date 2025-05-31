package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.services.CourService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourServiceImpl implements CourService {

  private final CourRepository courRepository;

  @Override
  public List<Cours> getAllCours() {
    return courRepository.findAll();
  }

}
