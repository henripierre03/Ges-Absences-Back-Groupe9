package ism.groupe9.gestion_absence.services.Impl;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import ism.groupe9.gestion_absence.services.ClasseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

  private final ClasseRepository classeRepository;

  @Override
  public Classe getByid(String id) {
    return classeRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Classe not found with id: " + id));
  }

}
