package fr.esgi.flutter_auth_api.exception;

public class LoginErrorException extends RuntimeException{
    public LoginErrorException(String email){
        super("Erreur lors de la connexion avec l'email : " + email);
    }
}
