package fr.esgi.flutter_auth_api.service;

import fr.esgi.flutter_auth_api.business.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Utilisateur findById(Long id) throws Exception;
    Utilisateur update(Long id, Utilisateur utilisateurUpdated);
    void delete(Long id);
}
