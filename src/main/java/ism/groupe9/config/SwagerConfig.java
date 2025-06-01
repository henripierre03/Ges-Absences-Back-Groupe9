package ism.groupe9.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwagerConfig {

  @Value("${spring.application.version}")
  private String version;

  @Bean
  public OpenAPI openAPI() {
    final String securitySchemeName = "bearerAuth";

    return new OpenAPI()
        .info(new Info()
            .title("Gestion des absences")
            .description("API pour la gestion des absences des étudiants")
            .version(version))
        .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
        .components(new Components().addSecuritySchemes(securitySchemeName,
            new SecurityScheme()
                .name(securitySchemeName)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")));
  }
}
