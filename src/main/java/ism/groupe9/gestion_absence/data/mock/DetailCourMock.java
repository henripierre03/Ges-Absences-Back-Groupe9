package ism.groupe9.gestion_absence.data.mock;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.DetailCourRepository;
import lombok.RequiredArgsConstructor;

// @Component
@RequiredArgsConstructor
// @Order(3)
public class DetailCourMock implements CommandLineRunner {

  private final CourRepository courRepository;
  private final ClasseRepository classeRepository;
  private final DetailCourRepository detailCourRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Cours> cours = courRepository.findAll();
    List<Classe> classes = classeRepository.findAll();

    for (Cours c : cours) {
      List<DetailCour> details = new ArrayList<>();

      // Créer 3 détails de cours pour chaque cours
      for (int i = 0; i < 3; i++) {
        DetailCour detail = new DetailCour();
        detail.setDate(LocalDateTime.of(2025, 06, 16, 8, 0));
        detail.setHeureDebut(LocalTime.of(8, 0));
        detail.setHeureFin(LocalTime.of(10, 0));
        detail.setCourId(c.getId());

        // Utiliser une classe existante de manière cyclique
        Classe classe = classes.get(i % classes.size());
        detail.setClasseId(classe.getId());

        // Sauvegarder le détail
        DetailCour savedDetail = detailCourRepository.save(detail);

        // Ajouter le détail à la liste des détails du cours
        details.add(savedDetail);

        // Ajouter le détail à la liste des détails de la classe
        if (classe.getDetailCours() == null) {
          classe.setDetailCours(new ArrayList<>());
        }
        classe.getDetailCours().add(savedDetail);
        classeRepository.save(classe);
      }

      // Mettre à jour le cours avec ses détails
      c.setDetailCours(details);
      courRepository.save(c);
    }
  }
}