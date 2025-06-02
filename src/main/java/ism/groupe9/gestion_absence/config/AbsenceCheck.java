package ism.groupe9.gestion_absence.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import ism.groupe9.gestion_absence.services.CourService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbsenceCheck {

  private final CourService courService;
  private final ClasseRepository classeRepository;

  // Exécute toutes les 5 minutes (300000 ms)
  @Scheduled(fixedRate = 300000)
  public void checkAbsences() {
    LocalDateTime maintenant = LocalDateTime.now();
    List<Classe> classes = classeRepository.findAll();

    for (Classe classe : classes) {
      courService.marquerAbsencesPourCoursTermines(maintenant, classe.getId());
    }

  }
}