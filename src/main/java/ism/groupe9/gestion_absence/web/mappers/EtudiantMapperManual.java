package ism.groupe9.gestion_absence.web.mappers;

import org.springframework.stereotype.Component;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.repositories.ClasseRepository;
import ism.groupe9.gestion_absence.services.ClasseService;
import ism.groupe9.gestion_absence.web.dto.response.EtudiantSimpleResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EtudiantMapperManual {

  private final ClasseService classeService;
  private final ClasseMapper classeMapper;

  EtudiantSimpleResponse toEtudiantSimpleResponse(Etudiant etudiant) {
    if (etudiant == null) {
      return null;
    }

    return EtudiantSimpleResponse.builder()
        .id(etudiant.getId())
        .nom(etudiant.getNom())
        .matricule(etudiant.getMatricule())
        .email(etudiant.getEmail())
        .role(etudiant.getRole())
        .filiere(etudiant.getFiliere())
        .niveau(etudiant.getNiveau())
        .prenom(etudiant.getPrenom())
        .email(etudiant.getEmail())
        .classe(classeMapper.toClasseSimpleResponse(classeService.getByid(etudiant.getClasseId())))
        .build();
  }
}
