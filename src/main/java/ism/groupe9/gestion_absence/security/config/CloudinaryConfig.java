package ism.groupe9.gestion_absence.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

  @Bean
  public Cloudinary cloudinary() {
    Map<String, String> config = new HashMap<>();
    config.put("cloud_name", "dlzhxk6wp");
    config.put("api_key", "453679135931264");
    config.put("api_secret", "qzxOqiQ_Oy9OZ54oKrwHqkOTz5w");
    return new Cloudinary(config);
  }
}