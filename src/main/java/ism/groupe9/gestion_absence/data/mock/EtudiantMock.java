package ism.groupe9.gestion_absence.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class EtudiantMock implements CommandLineRunner {

  private final EtudiantRepository etudiantRepository;
  private final PasswordEncoder passwordEncoder;


  @Override
  public void run(String... args) throws Exception {
    List<Etudiant> etudiants = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      Etudiant etudiant = new Etudiant();

      etudiant.setNom("Etudiant " + i);
      etudiant.setPrenom("Prenom " + i);
      etudiant.setEmail("etudiant" + i + "@example.com");
      etudiant.setMatricule("MATRICULE" + i);
      etudiant.setPassword(passwordEncoder.encode("password" + i));
      etudiant.setRole(UserRole.ETUDIANT);

      etudiants.add(etudiant);
    }

    etudiantRepository.saveAll(etudiants);
  }

}
