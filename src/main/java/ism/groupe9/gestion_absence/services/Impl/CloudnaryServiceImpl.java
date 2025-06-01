package ism.groupe9.gestion_absence.services.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ism.groupe9.gestion_absence.services.CloudnaryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudnaryServiceImpl implements CloudnaryService {

  private final Cloudinary cloudinary;

  @Override
  public List<String> uploadFiles(List<MultipartFile> files) throws IOException {
    List<String> urls = new ArrayList<>();
        
        for (MultipartFile file : files) {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap("resource_type", "auto")
            );
            urls.add((String) uploadResult.get("secure_url"));
        }
        
        return urls;
    
  }
  
}
