package ism.groupe9.gestion_absence.data.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;

@Component
@Order(2)
@RequiredArgsConstructor
public class AbsenceMock implements CommandLineRunner {

  private final AbsenceRepository absenceRepository;
  private final EtudiantRepository etudiantRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Absence> absences = new ArrayList<>();
    List<Etudiant> etudiantsModifies = new ArrayList<>();
    var etudiants = etudiantRepository.findAll();
    
    for (var etudiant : etudiants) {
      for (int i = 1; i <= 2; i++) {
        
          Absence absence = new Absence();
          absence.setEtudiantId(etudiant.getId());
          absence.setDate(LocalDateTime.now());
          absence.setJustificationId(null);
          etudiant.addAbsence(absence);
          absences.add(absence);
        
      }
      etudiantsModifies.add(etudiant);
    }
    
    absenceRepository.saveAll(absences);
    etudiantRepository.saveAll(etudiantsModifies);
  }

}
