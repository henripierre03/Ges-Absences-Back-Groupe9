package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.mobile.dto.response.JustificationSimpleResponse;

@Mapper(componentModel = "spring")
public interface JustificationMapperMobile {

  JustificationSimpleResponse toJustificationSimpleResponse(Justification justification);
}
