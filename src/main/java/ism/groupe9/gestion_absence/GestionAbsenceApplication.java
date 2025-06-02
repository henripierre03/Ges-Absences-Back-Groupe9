package ism.groupe9.gestion_absence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class GestionAbsenceApplication {

	@Configuration
	public class CorsConfig {
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				public void addCorsMappings(@NonNull CorsRegistry registry) {
					registry.addMapping("/**") // Autoriser toutes les routes (/** au lieu de /)
							.allowedOriginPatterns("*") // Autoriser tous les origins (pour Flutter mobile)
							.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
							.allowedHeaders("*")
							.allowCredentials(false) // Mettre à false pour allowedOriginPatterns("*")
							.maxAge(3600); // Cache preflight pendant 1 heure
				}
			};
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionAbsenceApplication.class, args);
	}
}