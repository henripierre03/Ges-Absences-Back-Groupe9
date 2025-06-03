package ism.groupe9.gestion_absence.services;

import java.io.IOException;

import com.google.zxing.WriterException;

public interface QRCodeService {
  
  public byte[] generateQRCode(String matricule) throws WriterException, IOException;
}
