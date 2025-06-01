package ism.groupe9.gestion_absence.web.dto.response;

public class LoginResponse {
    private String token;
    private String refreshToken;
    private String nomComplet;
    private String role;

    public LoginResponse(String token, String refreshToken, String nomComplet, String role) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.nomComplet = nomComplet;
        this.role = role;
    }

    // Getters et setters
}
    