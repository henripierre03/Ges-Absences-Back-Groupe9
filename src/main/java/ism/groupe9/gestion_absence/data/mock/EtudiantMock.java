package ism.groupe9.gestion_absence.data.mock;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.data.entities.Vigile;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.data.repositories.JustificationRepository;
import ism.groupe9.gestion_absence.data.repositories.VigileRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class EtudiantMock implements CommandLineRunner {

  private final EtudiantRepository etudiantRepository;
  private final AbsenceRepository absenceRepository;
  private final JustificationRepository justificationRepository;
  private final VigileRepository vigileRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {

    for (int i = 1; i <= 10; i++) {
      Etudiant etudiant = new Etudiant();
      etudiant.setNom("Etudiant " + i);
      etudiant.setPrenom("Prenom " + i);
      etudiant.setEmail("etudiant" + i + "@example.com");
      etudiant.setMatricule("MATRICULE" + i);
      etudiant.setArePayed(true);
      etudiant.setPassword(passwordEncoder.encode("password" + i));
      etudiant.setRole(UserRole.ETUDIANT);

      // 1. Enregistre d'abord l'étudiant pour obtenir son ID
      Etudiant savedEtudiant = etudiantRepository.save(etudiant);
      var vigiles = vigileRepository.findAll();
      // 2. Ensuite, gère ses absences
      if (i % 2 == 0) {
        for (int j = 1; j <= 2; j++) {

          Absence absence = new Absence();
          absence.setEtudiantId(savedEtudiant.getId());
          absence.setDate(LocalDateTime.now());

          if (j % 2 == 0) {
            Vigile vigile = vigiles.get(j % vigiles.size());

            absence.setTypeAbsence(TypeAbsence.ABSENCE);
            absence.setVigileId(vigile.getId());

            // 3. Sauve l'absence AVANT d'associer la justification
            Absence savedAbsence = absenceRepository.save(absence);

            Justification justification = new Justification();
            justification.setMessage("Justification " + j + " for Etudiant " + i);
            justification.setDate(LocalDateTime.now());
            justification.setValidation(true);
            justification.setEtudiantId(savedEtudiant.getId());
            justification.setAbsenceId(savedAbsence.getId());

            Justification savedJustification = justificationRepository.save(justification);

            // 4. Mise à jour de l'absence avec la justification
            savedAbsence.setJustificationId(savedJustification.getId());
            absenceRepository.save(savedAbsence);
          } else {
            absence.setTypeAbsence(TypeAbsence.PRESENCE);
            absence.setJustificationId(null);
            absenceRepository.save(absence);
          }
        }
      }
    }

  }
}
