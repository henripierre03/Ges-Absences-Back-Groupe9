package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.services.EtudiantService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {

  private final EtudiantRepository etudiantRepository;

  @Override
  public List<Etudiant> getAll() {
    return etudiantRepository.findAll();
  }

  @Override
  public Etudiant getById(String id) {
    return etudiantRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
  }

  @Override
  public Etudiant save(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
  }

  @Override
  public Etudiant update(String id, Etudiant etudiant) {
    Etudiant existingEtudiant = etudiantRepository.findById(id).orElse(null);
    if (existingEtudiant != null) {
      existingEtudiant.setNom(etudiant.getNom());
      existingEtudiant.setPrenom(etudiant.getPrenom());
      existingEtudiant.setEmail(etudiant.getEmail());
      existingEtudiant.setMatricule(etudiant.getMatricule());
      existingEtudiant.setPassword(etudiant.getPassword());
      existingEtudiant.setRole(etudiant.getRole());
      return etudiantRepository.save(existingEtudiant);
    } else {
      throw new RuntimeException("Etudiant not found with id: " + id);
    }
  }

  @Override
  public Etudiant getByMatricule(String matricule) {
    return etudiantRepository.findByMatricule(matricule);
  }

}
