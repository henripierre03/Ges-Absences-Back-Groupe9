package ism.groupe9.gestion_absence.mobile.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.mobile.dto.response.EtudiantAllResponse;
import ism.groupe9.gestion_absence.web.dto.request.EtudiantCreateRequest;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {


  @Mapping(target = "anneesScolaires", ignore = true)
  Etudiant toEntity(EtudiantCreateRequest etudiantCreateRequest);


  EtudiantAllResponse toEtudiantAllResponse(Etudiant etudiant);
  
  EtudiantAllResponse toEtudiantAllResponseWeb(Etudiant etudiant);

}
