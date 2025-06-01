package ism.groupe9.gestion_absence.security.services;

import ism.groupe9.gestion_absence.security.entity.Admin;
import ism.groupe9.gestion_absence.security.repository.AdminRepository;
import ism.groupe9.gestion_absence.web.dto.request.LoginRequest;
import ism.groupe9.gestion_absence.web.dto.response.LoginResponse;
import ism.groupe9.gestion_absence.security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final AdminRepository adminRepository;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Admin admin = adminRepository.findByEmail(request.getEmail())
                        .orElseThrow(() -> new BadCredentialsException("Email introuvable"));

        String token = jwtUtil.generateToken(admin.getEmail(), "ADMIN");
        String refreshToken = jwtUtil.generateRefreshToken(admin.getEmail());

        return new LoginResponse(token, refreshToken, admin.getNomComplet(), "ADMIN");
    }
}
