package ism.groupe9.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseCleanerConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    CommandLineRunner cleanDatabase() {
        return args -> {
            mongoTemplate.getCollectionNames().forEach(collectionName -> {
                mongoTemplate.dropCollection(collectionName);
            });
        };
    }
}