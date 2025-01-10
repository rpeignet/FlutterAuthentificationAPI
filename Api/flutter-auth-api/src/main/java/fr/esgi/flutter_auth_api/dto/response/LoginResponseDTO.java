package fr.esgi.flutter_auth_api.dto.response;

public class LoginResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String role;
    public int status;
    public String message;

    public LoginResponseDTO(Long id, String firstName, String lastName, String email, String role, int status, String message) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.message = message;
    }
}
