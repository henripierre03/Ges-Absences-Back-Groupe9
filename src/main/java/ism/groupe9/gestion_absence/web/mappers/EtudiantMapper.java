package ism.groupe9.gestion_absence.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.web.dto.request.EtudiantCreateRequest;
import ism.groupe9.gestion_absence.web.dto.response.EtudiantAllResponse;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

  @Mapping(target = "anneesScolaires", ignore = true)
  Etudiant toEntity(EtudiantCreateRequest etudiantCreateRequest);

  EtudiantAllResponse toEtudiantAllResponse(Etudiant etudiant);
  // EtudiantSimpleResponse toEtudiantSimpleResponse(Etudiant etudiant);

}
