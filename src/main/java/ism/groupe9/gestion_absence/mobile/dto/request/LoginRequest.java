package ism.groupe9.gestion_absence.mobile.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequest {
    private String email;
    private String password;

}
