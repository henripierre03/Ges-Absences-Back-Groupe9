package ism.groupe9.gestion_absence.data.mock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Admin;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class AdminMock implements CommandLineRunner {

  private final AdminRepository adminRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 1; i <= 3; i++) {
      Admin admin = new Admin();
      admin.setEmail("admin" + i + "@example.com");
      admin.setNom("Admin " + i);
      admin.setPrenom("Prenom " + i);
      admin.setPassword(passwordEncoder.encode("password" + i));
      admin.setRole(UserRole.ADMIN);
      adminRepository.save(admin);
    }
  }

}
