package fr.esgi.flutter_auth_api.repository;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
