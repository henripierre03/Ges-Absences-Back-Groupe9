package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Classe;
import ism.groupe9.gestion_absence.web.dto.response.ClasseSimpleResponse;

@Mapper(componentModel = "spring")
public interface ClasseMapper {
  ClasseSimpleResponse toClasseSimpleResponse(Classe classe);

}
