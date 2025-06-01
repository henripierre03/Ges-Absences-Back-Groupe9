package ism.groupe9.gestion_absence.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface CloudnaryService {
  
  List<String> uploadFiles(List<MultipartFile> files) throws IOException ;

}
