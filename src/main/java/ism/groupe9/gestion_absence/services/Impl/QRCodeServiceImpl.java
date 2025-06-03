package ism.groupe9.gestion_absence.services.Impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import ism.groupe9.gestion_absence.services.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService {

  @Override
  public byte[] generateQRCode(String matricule) throws WriterException, IOException {

    // Configuration du QR code
    Map<EncodeHintType, Object> hints = new HashMap<>();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    hints.put(EncodeHintType.MARGIN, 2);

    // Création du QR code
    BitMatrix bitMatrix = new MultiFormatWriter().encode(
        matricule,
        BarcodeFormat.QR_CODE,
        200, // largeur
        200, // hauteur
        hints);

    // Conversion en image
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

    return outputStream.toByteArray();
  }

}
