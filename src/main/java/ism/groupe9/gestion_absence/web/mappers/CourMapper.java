package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Cours;
import ism.groupe9.gestion_absence.web.dto.response.CourSimpleResponse;

@Mapper(componentModel = "spring")
public interface CourMapper {

  CourSimpleResponse toCourSimpleResponse(Cours cour);

}
