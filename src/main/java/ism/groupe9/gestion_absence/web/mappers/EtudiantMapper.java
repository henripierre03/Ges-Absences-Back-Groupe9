package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.web.dto.request.web.EtudiantCreateRequest;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

  @Mapping(target = "classeId", source = "classeId")
  Etudiant toEntity(EtudiantCreateRequest etudiantCreateRequest);

}
