package ism.groupe9.gestion_absence.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Vigile;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.VigileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// @Component
// @Order(1)
public class VigileMock implements CommandLineRunner {

  private final VigileRepository vigileRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    List<Vigile> vigiles = new ArrayList<>();

    for (int i = 1; i <= 5; i++) {
      Vigile vigile = new Vigile();
      vigile.setEmail("vigile" + i + "@example.com");
      vigile.setNom("Vigile " + i);
      vigile.setPrenom("Prenom " + i);
      vigile.setPassword(passwordEncoder.encode("password" + i));
      vigile.setRole(UserRole.VIGILE);
      vigiles.add(vigile);
    }
    vigileRepository.saveAll(vigiles);
  }
}
