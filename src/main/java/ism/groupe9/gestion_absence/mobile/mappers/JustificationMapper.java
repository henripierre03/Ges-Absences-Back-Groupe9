package ism.groupe9.gestion_absence.mobile.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.mobile.dto.request.JustificationCreateRequest;
import ism.groupe9.gestion_absence.mobile.dto.response.JustificationSimpleResponse;

@Mapper(componentModel = "spring")
public interface JustificationMapper {

  Justification toEntity(JustificationCreateRequest justificationCreateRequest);

  JustificationSimpleResponse toJustificationSimpleResponse(Justification justification);
}
