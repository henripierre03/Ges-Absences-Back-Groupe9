package ism.groupe9.gestion_absence.security.services;

import ism.groupe9.gestion_absence.web.dto.request.LoginRequest;
import ism.groupe9.gestion_absence.web.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}

