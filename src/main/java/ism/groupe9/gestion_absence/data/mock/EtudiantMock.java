package ism.groupe9.gestion_absence.data.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.AnneeScolaire;
import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.data.entities.Vigile;
import ism.groupe9.gestion_absence.data.enums.Filiere;
import ism.groupe9.gestion_absence.data.enums.Niveau;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import ism.groupe9.gestion_absence.data.enums.UserRole;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.AnneeScolaireRepository;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.data.repositories.JustificationRepository;
import ism.groupe9.gestion_absence.data.repositories.VigileRepository;
import lombok.RequiredArgsConstructor;

// @Component
// @Order(4)
@RequiredArgsConstructor
public class EtudiantMock implements CommandLineRunner {

  private final EtudiantRepository etudiantRepository;
  private final AbsenceRepository absenceRepository;
  private final JustificationRepository justificationRepository;
  private final VigileRepository vigileRepository;
  private final PasswordEncoder passwordEncoder;
  private final CourRepository courRepository;
  private final ClasseRepository classRepository;
  private final AnneeScolaireRepository anneeScolaireRepository;

  @Override
  public void run(String... args) throws Exception {

    List<Cours> allCours = courRepository.findAll();
    var classes = classRepository.findAll();
    ;
    List<AnneeScolaire> anneesScolaires = anneeScolaireRepository.findAll();

    for (int i = 1; i <= 10; i++) {
      Etudiant etudiant = new Etudiant();
      etudiant.setNom("Etudiant " + i);
      etudiant.setPrenom("Prenom " + i);
      etudiant.setEmail("etudiant" + i + "@example.com");
      etudiant.setMatricule("MATRICULE" + i);
      etudiant.setFiliere(Filiere.GLRS);
      etudiant.setNiveau(Niveau.L3);
      etudiant.setArePayed(true);
      etudiant.setPassword(passwordEncoder.encode("password" + i));
      etudiant.setRole(UserRole.ETUDIANT);
      Classe classe = classes.get(i % classes.size());

      etudiant.setClasseId(classe.getId());

      // Ajout des années scolaires
      List<AnneeScolaire> anneesEtudiant = new ArrayList<>();
      // Chaque étudiant aura 2 années scolaires consécutives
      int startIndex = (i % 4); // Pour varier les années scolaires entre les étudiants
      anneesEtudiant.add(anneesScolaires.get(startIndex));
      anneesEtudiant.add(anneesScolaires.get(startIndex + 1));
      etudiant.setAnneesScolaires(anneesEtudiant);

      // 1. Enregistre d'abord l'étudiant pour obtenir son ID
      Etudiant savedEtudiant = etudiantRepository.save(etudiant);
      var vigiles = vigileRepository.findAll();
      // 2. Ensuite, gère ses absences
      if (i % 2 == 0) {
        for (int j = 1; j <= 4; j++) {

          Absence absence = new Absence();
          absence.setEtudiantId(savedEtudiant.getId());
          absence.setDate(LocalDateTime.now());
          Cours cours = allCours.get(j % vigiles.size());
          absence.setCourId(cours.getId());

          if (j % 2 == 0) {

            absence.setTypeAbsence(TypeAbsence.ABSENCE);

            // 3. Sauve l'absence AVANT d'associer la justification
            Absence savedAbsence = absenceRepository.save(absence);

            if (j == 2) {
              Justification justification = new Justification();
              justification.setMessage("Justification " + j + " for Etudiant " + i);
              justification.setJustificatifs(null);
              justification.setDate(LocalDateTime.now());
              justification.setValidation(false);
              justification.setEtudiantId(savedEtudiant.getId());
              justification.setAbsenceId(savedAbsence.getId());
              List<String> justificatifs = new ArrayList<>();
              justificatifs.add("https://www.lettre-utile.fr/wp-content/uploads/2017/08/excuses-absence-travail.gif");
              justificatifs.add("https://www.lettre-utile.fr/wp-content/uploads/2017/08/excuses-absence-travail.gif");
              justification.setJustificatifs(justificatifs);

              Justification savedJustification = justificationRepository.save(justification);
              savedAbsence.setJustificationId(savedJustification.getId());
              absenceRepository.save(savedAbsence);
            } else {
              // Si pas de justification, on met l'ID à null
              savedAbsence.setJustificationId(null);
              absenceRepository.save(savedAbsence);
            }

            // 4. Mise à jour de l'absence avec la justification

          } else {
            Vigile vigile = vigiles.get(j % vigiles.size());
            absence.setVigileId(vigile.getId());
            absence.setTypeAbsence(TypeAbsence.PRESENCE);
            absence.setJustificationId(null);
            absenceRepository.save(absence);
          }
        }
      }
    }

  }
}
