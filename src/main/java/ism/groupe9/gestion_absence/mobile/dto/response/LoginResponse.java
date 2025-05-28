package ism.groupe9.gestion_absence.mobile.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginResponse {
  private String token;
  private String email;
  private String role;
  private String type = "Bearer";
}
