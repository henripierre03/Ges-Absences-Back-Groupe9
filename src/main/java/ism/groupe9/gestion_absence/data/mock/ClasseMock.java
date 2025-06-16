package ism.groupe9.gestion_absence.data.mock;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class ClasseMock implements CommandLineRunner {

  private final ClasseRepository classeRepository;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 1; i <= 10; i++) {
      Classe classe = new Classe();
      classe.setNom("Classe " + i);
      classe.setDetailCours(new ArrayList<>());
      classeRepository.save(classe);
    }
  }

}
