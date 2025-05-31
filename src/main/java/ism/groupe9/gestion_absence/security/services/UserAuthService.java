package ism.groupe9.gestion_absence.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Admin;
import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.entities.Vigile;
import ism.groupe9.gestion_absence.data.repositories.AdminRepository;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.data.repositories.VigileRepository;
import ism.groupe9.gestion_absence.security.entity.UserAuth;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

  private final EtudiantRepository etudiantRepository;
  private final AdminRepository adminRepository;
  private final VigileRepository vigileRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    Etudiant etudiant = etudiantRepository.findByEmail(email);
    if (etudiant != null) {
      return new UserAuth(etudiant);
    }

    Admin admin = adminRepository.findByEmail(email);
    if (admin != null) {
      return new UserAuth(admin);
    }

    Vigile vigile = vigileRepository.findByEmail(email);
    if (vigile != null) {
      return new UserAuth(vigile);
    }

    throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email: " + email);
  }

}
