package ism.groupe9.gestion_absence.mobile.dto.response;

import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class LoginResponse {
  private String token;
  private String email;
  private UserRole role;
  private String type = "Bearer";
}
