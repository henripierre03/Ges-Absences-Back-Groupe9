package ism.groupe9.gestion_absence.data.mock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Salle;
import ism.groupe9.gestion_absence.data.repositories.SalleRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class SalleMock implements CommandLineRunner {

  private final SalleRepository salleRepository;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 1; i <= 10; i++) {
      Salle salle = new Salle();
      salle.setNom("Salle " + i);
      salle.setCapacite(String.valueOf(30 + i));
      salleRepository.save(salle);
    }
  }
}
