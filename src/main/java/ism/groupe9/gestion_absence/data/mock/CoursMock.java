package ism.groupe9.gestion_absence.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.Salle;
import ism.groupe9.gestion_absence.data.enums.Module;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.SalleRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(2)
@RequiredArgsConstructor
public class CoursMock implements CommandLineRunner {

  private final SalleRepository salleRepository;
  private final CourRepository coursRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Salle> salles = salleRepository.findAll();
    for (int i = 1; i <= 10; i++) {
      Cours cours = new Cours();
      cours.setModule(Module.ALGO);
      cours.setSalleId(null);
      Salle sale = salles.get(i % salles.size());
      cours.setSalleId(sale.getId());
      cours.setDetailCours(new ArrayList<>());
      coursRepository.save(cours);
    }
  }

}
