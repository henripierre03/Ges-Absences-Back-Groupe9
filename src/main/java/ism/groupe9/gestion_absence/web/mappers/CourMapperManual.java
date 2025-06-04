package ism.groupe9.gestion_absence.web.mappers;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.services.SalleService;
import ism.groupe9.gestion_absence.web.dto.response.CourSimpleResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CourMapperManual {
  private final SalleService salleService;
  private final SalleMapper salleMapper;

  public CourSimpleResponse toCourSimpleResponse(Cours cour) {
    if (cour == null) {
      return null;
    }

    return CourSimpleResponse.builder()
        .id(cour.getId())
        .module(cour.getModule())
        .salle(salleMapper.toSalleSimpleResponse(salleService.getById(cour.getSalleId())))
        .build();

  }

}
