package ism.groupe9.gestion_absence.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class Pointage {
    
    @Id
    private String id;
    //private String etudiantId;
    private String matricule;
    private String date;

}
