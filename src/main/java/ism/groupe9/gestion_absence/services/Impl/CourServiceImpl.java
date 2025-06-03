package ism.groupe9.gestion_absence.services.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.enums.TypeAbsence;
import ism.groupe9.gestion_absence.data.repositories.AbsenceRepository;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.services.CourService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourServiceImpl implements CourService {

  private final CourRepository courRepository;
  private final EtudiantRepository etudiantRepository;
  private final AbsenceRepository absenceRepository;

  @Override
  public List<Cours> getAllCours() {
    return courRepository.findAll();
  }

  // @Override
  // public List<Cours> getCoursTerminer(LocalDateTime maintenant , String
  // classeId) {
  // List<Cours> cours = courRepository.findAll();
  // List<Cours> coursTerminer = new ArrayList<>();
  // for (Cours c : cours) {
  // for (var detailCour : c.getDetailCours()) {
  // if (detailCour.getDate().isBefore(maintenant)) {
  // coursTerminer.add(c);
  // }
  // }
  // }
  // return coursTerminer;
  // }

  @Override
  public List<Cours> getCoursTerminer(LocalDateTime maintenant, String classeId) {
    return courRepository.findAll().stream()
        .filter(cours -> cours.getDetailCours().stream()
            .anyMatch(detail -> {
              // Vérifie si le cours est du jour même
              boolean memeJour = detail.getDate().toLocalDate().equals(maintenant.toLocalDate());
              // Vérifie si le cours est terminé (date et heure avant maintenant)
              boolean estTermine = detail.getDate().isBefore(maintenant);
              // Vérifie si c'est le bon cours pour la classe
              boolean bonneClasse = detail.getClasseId().equals(classeId);

              return memeJour && estTermine && bonneClasse;
            }))
        .distinct()
        .toList();
  }

  @Override
  public void marquerAbsencesPourCoursTermines(LocalDateTime maintenant, String classeId) {
    List<Cours> coursTermines = getCoursTerminer(maintenant, classeId);

    for (Cours cours : coursTermines) {
      for (DetailCour detailCour : cours.getDetailCours()) {
        if (detailCour.getDate().isBefore(maintenant)
            && detailCour.getClasseId().equals(classeId)) {

          // Récupérer tous les étudiants de la classe
          List<Etudiant> etudiants = etudiantRepository.findByClasseId(classeId);

          for (Etudiant etudiant : etudiants) {
            // Vérifier si l'étudiant a déjà une absence pour ce cours
            boolean dejaAbsent = absenceRepository.findByEtudiantId(etudiant.getId()).stream()
                .anyMatch(a -> a.getCourId().equals(cours.getId())
                    && a.getDate().equals(detailCour.getDate()));

            if (!dejaAbsent) {
              Absence absence = new Absence();
              absence.setEtudiantId(etudiant.getId());
              absence.setDate(detailCour.getDate());
              absence.setCourId(cours.getId());
              absence.setTypeAbsence(TypeAbsence.ABSENCE);

              absenceRepository.save(absence);
              etudiant.addAbsence(absence);
              etudiantRepository.save(etudiant);
            }
          }
        }
      }
    }
  }

}
