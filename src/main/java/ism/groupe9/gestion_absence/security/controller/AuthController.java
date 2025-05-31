package ism.groupe9.gestion_absence.security.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import ism.groupe9.gestion_absence.mobile.dto.request.LoginRequest;

@RequestMapping("/api/auth")
public interface AuthController {

  @PostMapping("/login")
  ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest);

  @GetMapping("/logout")
  ResponseEntity<Map<String, Object>> logout(@RequestHeader("Authorization") String token);
}
