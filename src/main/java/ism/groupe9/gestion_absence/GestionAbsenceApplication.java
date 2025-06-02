package ism.groupe9.gestion_absence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionAbsenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAbsenceApplication.class, args);
	}

}
