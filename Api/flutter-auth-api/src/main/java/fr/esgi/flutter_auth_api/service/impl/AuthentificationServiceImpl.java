package fr.esgi.flutter_auth_api.service.impl;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.exception.LoginErrorException;
import fr.esgi.flutter_auth_api.service.AuthentificationService;
import fr.esgi.flutter_auth_api.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {
    private final UtilisateurService utilisateurService;

    public AuthentificationServiceImpl(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    public Utilisateur login(String email, String password) {
        for (Utilisateur utilisateur : utilisateurService.findAll()) {
            if (utilisateur.getEmail().equals(email)) {
                String hashedInputPassword = hashPassword(password);
                if (utilisateur.getPassword().equals(hashedInputPassword)) {
                    return utilisateur;
                }
            }
        }
        throw new LoginErrorException(email);
    }

    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
