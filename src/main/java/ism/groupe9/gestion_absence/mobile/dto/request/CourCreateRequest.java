package ism.groupe9.gestion_absence.mobile.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import ism.groupe9.gestion_absence.data.entities.DetailCour;
import ism.groupe9.gestion_absence.data.enums.Module;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourCreateRequest {

  private String id;
  private Module module;
  private LocalDateTime date;
  private String salleId;
  private List<DetailCour> detailCours;
}
