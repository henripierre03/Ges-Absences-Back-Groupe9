package ism.groupe9.gestion_absence.services.Impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.DetailCourRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.services.EtudiantService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {

  private final EtudiantRepository etudiantRepository;
  private final CourRepository courRepository;
  private final DetailCourRepository detailCourRepository;

  @Override
  public List<Etudiant> getAll() {
    return etudiantRepository.findAll();
  }

  @Override
  public Etudiant getById(String id) {
    return etudiantRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
  }

  @Override
  public Etudiant save(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
  }

  @Override
  public Etudiant update(String id, Etudiant etudiant) {
    Etudiant existingEtudiant = etudiantRepository.findById(id).orElse(null);
    if (existingEtudiant != null) {
      existingEtudiant.setNom(etudiant.getNom());
      existingEtudiant.setPrenom(etudiant.getPrenom());
      existingEtudiant.setEmail(etudiant.getEmail());
      existingEtudiant.setMatricule(etudiant.getMatricule());
      existingEtudiant.setPassword(etudiant.getPassword());
      existingEtudiant.setRole(etudiant.getRole());
      return etudiantRepository.save(existingEtudiant);
    } else {
      throw new RuntimeException("Etudiant not found with id: " + id);
    }
  }

  @Override
  public Etudiant getByMatricule(String matricule) {
    return etudiantRepository.findByMatricule(matricule);
  }

  // @Override
  // public Etudiant pointage(String matricule) {
  //   var etudiant = etudiantRepository.findByMatricule(matricule);
  //   if (etudiant == null) {
  //     throw new RuntimeException("Etudiant not found with matricule: " + matricule);
  //   }
  //   DetailCour prochainCours = this.getProchainCoursAujourdHui(matricule);
  //   var cours = courRepository.findAll();
  //   List<DetailCour> detailCours = new ArrayList<>();
  //   for (Cours cour : cours) {
  //     for (DetailCour detailCour : cour.getDetailCours()) {
  //       if (detailCour.getDate().toLocalDate().equals(LocalDateTime.now().toLocalDate())) {
  //         if(detailCour.getClasseId().equals(etudiant.getClasseId())){
  //           detailCours.add(detailCour);
  //         }
  //       }
  //     }
  //   }
    

  //   return etudiant;

  // }



  @Override 
  public DetailCour getProchainCoursAujourdHui(String matricule) {
    Etudiant etudiant = etudiantRepository.findByMatricule(matricule);
    if (etudiant == null) {
        throw new RuntimeException("Étudiant introuvable avec le matricule: " + matricule);
    }

    LocalDateTime maintenant = LocalDateTime.now();
    LocalDate aujourdhui = maintenant.toLocalDate();

    List<Cours> allCours = courRepository.findAll();
    
    List<DetailCour> coursValides = new ArrayList<>();

    for (Cours cours : allCours) {
        for (DetailCour detailCours : cours.getDetailCours()) {
            if (detailCours.getDate().toLocalDate().equals(aujourdhui) &&
                detailCours.getClasseId().equals(etudiant.getClasseId()) &&
                detailCours.getDate().isAfter(maintenant)) {
                
                coursValides.add(detailCours);
            }
        }
    }
    if (coursValides.isEmpty()) {
        return null;
    }
    
    // Trier les cours par heure
    coursValides.sort((cours1, cours2) -> cours1.getDate().compareTo(cours2.getDate()));
    return coursValides.get(0);
}
  
}
