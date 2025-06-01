package ism.groupe9.gestion_absence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @SpringBootApplication
// public class GestionAbsenceApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(GestionAbsenceApplication.class, args);
// 	}
// }

@SpringBootApplication
public class GestionAbsenceApplication {
	@Configuration
	public class CorsConfig {
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/") // Autoriser toutes les routes
							.allowedOrigins("http://localhost:4200") // Autoriser Angular (changer si besoin)
							.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
							.allowedHeaders("*")
							.allowCredentials(true);
				}
			};
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionAbsenceApplication.class, args);
	}
}
