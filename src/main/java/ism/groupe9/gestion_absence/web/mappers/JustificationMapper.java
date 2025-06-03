package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.web.dto.response.JustificationSimpleResponse;

@Mapper(componentModel = "spring")
public interface JustificationMapper {

  JustificationSimpleResponse toJustificationSimpleResponse(Justification justification);
}
