package ism.groupe9.gestion_absence.web.dto.response;

import java.util.List;

public class CourSimpleResponse {
  
  private String id;
  private Module module;
  private List<DetailSimpleResponse> detailCours;
  private String salleId;
}
