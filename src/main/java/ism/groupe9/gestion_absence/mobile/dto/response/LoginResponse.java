package ism.groupe9.gestion_absence.mobile.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import ism.groupe9.gestion_absence.data.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class LoginResponse {
  @JsonProperty("id")
  private String id;
  private String token;
  private String email;
  private String matricule;
  private UserRole role;
  private String type = "Bearer";
}
