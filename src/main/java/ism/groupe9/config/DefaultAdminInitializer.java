package ism.groupe9.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Admin;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DefaultAdminInitializer implements CommandLineRunner {

  private final AdminRepository adminRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) {
    // Vérifier si l'admin existe déjà
    if (adminRepository.findByEmail("admin@ism.edu.sn") == null) {
      Admin admin = new Admin();
      admin.setNom("Admin");
      admin.setPrenom("System");
      admin.setEmail("admin@ism.edu.sn");
      admin.setPassword(passwordEncoder.encode("admin123"));
      admin.setRole(UserRole.ADMIN);
      adminRepository.save(admin);
      System.out.println("Admin par défaut créé avec succès!");
    }
  }
}
