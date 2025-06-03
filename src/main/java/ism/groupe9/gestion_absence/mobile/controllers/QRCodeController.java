package ism.groupe9.gestion_absence.mobile.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/api/qrcode")
public interface QRCodeController {

  @GetMapping("/{matricule}")
  @Operation(summary = "Generer un QR code pour un étudiant", description = "Génère un QR code contenant le matricule de l'étudiant.")
  public ResponseEntity<byte[]> generateQRCode(@PathVariable String matricule);
}
