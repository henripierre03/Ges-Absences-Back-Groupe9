package ism.groupe9.gestion_absence.mobile.controllers.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.repositories.CourRepository;
import ism.groupe9.gestion_absence.data.repositories.DetailCourRepository;
import ism.groupe9.gestion_absence.mobile.controllers.MobileCoursController;
import ism.groupe9.gestion_absence.mobile.dto.request.CourCreateRequest;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MobileCoursControllerImpl implements MobileCoursController {

  private final CourRepository courRepository;
  private final DetailCourRepository detailCourRepository;

  @Override
  public ResponseEntity<Map<String, Object>> create(CourCreateRequest request) {
    try {
      if (request.getDetailCours() == null || request.getDetailCours().isEmpty()) {
        return new ResponseEntity<>(
            RestResponse.response(HttpStatus.BAD_REQUEST, "Aucun détail de cours fourni", "error"),
            HttpStatus.BAD_REQUEST);
      }


      Cours cours = new Cours();
      cours.setModule(request.getModule());
      cours.setSalleId(request.getSalleId());
      Cours savedCours = courRepository.save(cours); // 👈 Obtenir l'ID


      List<DetailCour> details = new ArrayList<>();

      for (DetailCour detail : request.getDetailCours()) {
        DetailCour detailCour = new DetailCour();
        detailCour.setDate(LocalDateTime.of(
            request.getDate().toLocalDate(),
            LocalTime.of(request.getDate().getHour(), request.getDate().getMinute())));
        detailCour.setHeureDebut(LocalTime.of(request.getDate().getHour(), request.getDate().getMinute()));
        detailCour.setHeureFin(LocalTime.of(request.getDate().getHour() + 2, request.getDate().getMinute()));
        detailCour.setClasseId(detail.getClasseId());
        detailCour.setCourId(savedCours.getId()); // 👈 liaison avec cours
        DetailCour savedDetail = detailCourRepository.save(detailCour);
        details.add(savedDetail);
      }

      savedCours.setDetailCours(details);
      courRepository.save(savedCours);

      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.CREATED, savedCours, "cours"),
          HttpStatus.CREATED);

    } catch (Exception e) {
      return new ResponseEntity<>(
          RestResponse.response(HttpStatus.INTERNAL_SERVER_ERROR,
              "Erreur lors de la création du cours: " + e.getMessage(), "error"),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
