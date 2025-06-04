package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Salle;
import ism.groupe9.gestion_absence.web.dto.response.SalleSimpleResponse;

@Mapper(componentModel = "spring")
public interface SalleMapper {

  SalleSimpleResponse toSalleSimpleResponse(Salle salle);

}
