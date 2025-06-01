package ism.groupe9.gestion_absence.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudnaryService {
  
  String uploadImage(MultipartFile file) throws IOException ;

}
