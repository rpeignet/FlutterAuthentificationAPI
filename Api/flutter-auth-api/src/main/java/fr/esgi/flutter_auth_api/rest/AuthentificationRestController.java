package fr.esgi.flutter_auth_api.rest;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.dto.request.LoginRequestDTO;
import fr.esgi.flutter_auth_api.dto.response.LoginResponseDTO;
import fr.esgi.flutter_auth_api.service.AuthentificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationRestController {
    private final AuthentificationService authentificationService;

    public AuthentificationRestController(AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        Utilisateur utilisateur = authentificationService.login(loginRequestDTO.email, loginRequestDTO.password);
        return new LoginResponseDTO(
                utilisateur.getId(),
                utilisateur.getFirstName(),
                utilisateur.getLastName(),
                utilisateur.getEmail(),
                utilisateur.getRole(),
                200,
                "Success"
        );
    }
}
