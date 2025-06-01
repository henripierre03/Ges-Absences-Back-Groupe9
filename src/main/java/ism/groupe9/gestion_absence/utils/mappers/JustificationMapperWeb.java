package ism.groupe9.gestion_absence.utils.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Justification;
import ism.groupe9.gestion_absence.web.dto.response.JustificationResponse;

@Mapper(componentModel = "spring")
public interface JustificationMapperWeb {
    JustificationResponse toDto(Justification justification);
}
