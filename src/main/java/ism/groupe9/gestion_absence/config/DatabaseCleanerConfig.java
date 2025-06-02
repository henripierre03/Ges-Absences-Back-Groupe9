package ism.groupe9.gestion_absence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

// @Configuration
// @Component
public class DatabaseCleanerConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    CommandLineRunner cleanDatabase() {
        return args -> {
            System.out.println("Nettoyage de la base de données en cours...");
            mongoTemplate.getCollectionNames().forEach(collectionName -> {
                System.out.println("Suppression de la collection: " + collectionName);
                mongoTemplate.dropCollection(collectionName);
            });
            System.out.println("Nettoyage de la base de données terminé avec succès!");
        };
    }
}