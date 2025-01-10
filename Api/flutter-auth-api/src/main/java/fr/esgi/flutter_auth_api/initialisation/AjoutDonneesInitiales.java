package fr.esgi.flutter_auth_api.initialisation;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.service.AuthentificationService;
import fr.esgi.flutter_auth_api.service.UtilisateurService;
import fr.esgi.flutter_auth_api.service.impl.AuthentificationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final UtilisateurService utilisateurService;
    private final AuthentificationService authentificationService;

    public AjoutDonneesInitiales(UtilisateurService utilisateurService, AuthentificationService authentificationService){
        this.utilisateurService = utilisateurService;
        this.authentificationService = authentificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        addUtilisateur();
    }

    private void addUtilisateur(){
        utilisateurService.create(new Utilisateur("robin@gmail.com", authentificationService.hashPassword("rpeignet"), "robin", "peignet", "admin"));
    }


}
