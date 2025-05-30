package ism.groupe9.gestion_absence.services.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.repositories.EtudiantRepository;
import ism.groupe9.gestion_absence.services.EtudiantService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {

    private static final Logger logger = LoggerFactory.getLogger(EtudiantServiceImpl.class);
    private final EtudiantRepository etudiantRepository;

    /**
     * Récupère tous les étudiants de la base de données.
     *
     * @return une liste de tous les étudiants
     */
    @Override
    public List<Etudiant> getAll() {
        logger.info("Récupération de tous les étudiants");
        return etudiantRepository.findAll();
    }

    /**
     * Récupère un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'étudiant à récupérer
     * @return l'étudiant correspondant à l'identifiant
     * @throws RuntimeException si aucun étudiant n'est trouvé avec l'identifiant donné
     */
    @Override
    public Etudiant getById(String id) {
        logger.info("Récupération de l'étudiant avec l'identifiant : {}", id);
        return etudiantRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Aucun étudiant trouvé avec l'identifiant : {}", id);
                    return new RuntimeException("Etudiant not found with id: " + id);
                });
    }

    /**
     * Sauvegarde un étudiant dans la base de données.
     *
     * @param etudiant l'étudiant à sauvegarder
     * @return l'étudiant sauvegardé
     * @throws IllegalArgumentException si l'étudiant est null
     */
    @Override
    public Etudiant save(Etudiant etudiant) {
        if (etudiant == null) {
            logger.error("L'étudiant ne peut pas être null");
            throw new IllegalArgumentException("L'étudiant ne peut pas être null");
        }
        logger.info("Sauvegarde de l'étudiant : {}", etudiant);
        return etudiantRepository.save(etudiant);
    }
}
