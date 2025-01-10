package fr.esgi.flutter_auth_api.service;

import fr.esgi.flutter_auth_api.business.Utilisateur;

import java.util.Optional;

public interface AuthentificationService {
    public Utilisateur login(String email, String password);
    public String hashPassword(String password);
}
