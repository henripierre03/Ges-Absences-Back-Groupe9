package ism.groupe9.gestion_absence.services.Impl;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Salle;
import ism.groupe9.gestion_absence.data.repositories.SalleRepository;
import ism.groupe9.gestion_absence.services.SalleService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalleServiceImpl implements SalleService {

  private final SalleRepository salleRepository;

  @Override
  public Salle getById(String id) {
    return salleRepository.findById(id).orElse(null);

  }

}
