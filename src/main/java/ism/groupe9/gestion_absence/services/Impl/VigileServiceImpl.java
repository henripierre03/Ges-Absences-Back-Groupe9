package ism.groupe9.gestion_absence.services.Impl;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Vigile;
import ism.groupe9.gestion_absence.data.repositories.VigileRepository;
import ism.groupe9.gestion_absence.services.VigileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VigileServiceImpl implements VigileService {

  private final VigileRepository vigileRepository;

  @Override
  public Vigile getById(String id) {
    return vigileRepository.findById(id)
        .orElse(null);
  }
}
