package ism.groupe9.gestion_absence.data.mock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.AnneeScolaire;
import ism.groupe9.gestion_absence.data.repositories.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// @Component
// @Order(1)
public class AnneeScolaireMock implements CommandLineRunner {
  private final AnneeScolaireRepository anneeScolaireRepository;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 1; i <= 5; i++) {
      AnneeScolaire anneeScolaire = new AnneeScolaire();
      anneeScolaire.setAnnee("202" + i);
      anneeScolaireRepository.save(anneeScolaire);
    }
  }

}
