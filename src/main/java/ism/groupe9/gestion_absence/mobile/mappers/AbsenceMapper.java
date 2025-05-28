package ism.groupe9.gestion_absence.mobile.mappers;

import org.mapstruct.Mapper;

import ism.groupe9.gestion_absence.data.entities.Absence;
import ism.groupe9.gestion_absence.mobile.dto.request.AbsenceCreateRequest;

@Mapper(componentModel = "spring")
public interface AbsenceMapper {
  

  Absence toEntity(AbsenceCreateRequest absenceCreateRequest);

}
