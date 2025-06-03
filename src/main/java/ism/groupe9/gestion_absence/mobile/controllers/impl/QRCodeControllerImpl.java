package ism.groupe9.gestion_absence.mobile.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ism.groupe9.gestion_absence.mobile.controllers.QRCodeController;
import ism.groupe9.gestion_absence.services.QRCodeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QRCodeControllerImpl implements QRCodeController {
  private final QRCodeService qrCodeService;

  @GetMapping("/{matricule}")
  public ResponseEntity<byte[]> generateQRCode(@PathVariable String matricule) {
    try {
      byte[] qrCode = qrCodeService.generateQRCode(matricule);
      return ResponseEntity.ok()
          .contentType(MediaType.IMAGE_PNG)
          .body(qrCode);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
