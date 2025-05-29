package ism.groupe9.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ism.groupe9.gestion_absence.mobile.dto.request.LoginRequest;

@RequestMapping("/api/auth")
public interface AuthController {
  
  @RequestMapping("/login")
  ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);
}
