package ism.groupe9.gestion_absence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwagerConfig {
  
  @Value("${spring.application.version}")
  private String version;

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Gestion des absences ")
            .description("API pour la gestion des absences des étudiants")
            .version(version));
  }
}
