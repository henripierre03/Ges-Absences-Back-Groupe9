package ism.groupe9.gestion_absence.mobile.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;
import ism.groupe9.gestion_absence.mobile.dto.response.AbsenceAndEtudiantResponse;
import ism.groupe9.gestion_absence.mobile.dto.response.AbsenceSimpleResponse;
import ism.groupe9.gestion_absence.mobile.dto.response.EtudiantAllResponse;

@Mapper(componentModel = "spring")
public interface MobileAbsenceMapper {

  Absence toEntity(AbsenceCreateRequest absenceCreateRequest);

  AbsenceSimpleResponse toAbsenceSimpleResponse(Absence absence);

  @Mapping(target = "etudiant", source = "etudiantId")
  AbsenceAndEtudiantResponse toAbsenceAndEtudiantResponse(Absence absence);

  default EtudiantAllResponse map(String etudiantId) {
    if (etudiantId == null)
      return null;
    EtudiantAllResponse response = new EtudiantAllResponse();
    response.setId(etudiantId);
    return response;
  }

}
