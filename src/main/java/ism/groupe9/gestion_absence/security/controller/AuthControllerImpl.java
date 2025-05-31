package ism.groupe9.gestion_absence.security.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.data.entities.Etudiant;
import ism.groupe9.gestion_absence.data.entities.User;
import ism.groupe9.gestion_absence.mobile.dto.request.LoginRequest;
import ism.groupe9.gestion_absence.mobile.dto.response.LoginResponse;
import ism.groupe9.gestion_absence.security.entity.UserAuth;
import ism.groupe9.gestion_absence.security.services.JwtTokenUtil;
import ism.groupe9.gestion_absence.security.services.TokenBlacklistService;
import ism.groupe9.gestion_absence.security.services.UserAuthService;
import ism.groupe9.gestion_absence.web.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserAuthService userAuthService;
  private final TokenBlacklistService tokenBlacklistService;

  @Override
  public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getEmail(),
            loginRequest.getPassword()));

    UserAuth userAuth = (UserAuth) authentication.getPrincipal();
    String token = jwtTokenUtil.generateToken(userAuth);
    User user = userAuth.getUser();
    String matricule = user instanceof Etudiant etudiant ? etudiant.getMatricule() : null;

    return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, new LoginResponse(
        token,
        user.getEmail(),
        matricule,
        user.getRole(),
        "Bearer"), "LoginResponse"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Map<String, Object>> logout(@RequestHeader("Authorization") String token) {
    if (token != null && token.startsWith("Bearer ")) {
      String jwt = token.substring(7);
      tokenBlacklistService.blacklistToken(jwt);
      return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, "Déconnexion réussie", "string"),
          HttpStatus.OK);

    }
    return new ResponseEntity<>(RestResponse.response(HttpStatus.UNAUTHORIZED, "Invalid token", "string"),
        HttpStatus.UNAUTHORIZED);
  }
}
