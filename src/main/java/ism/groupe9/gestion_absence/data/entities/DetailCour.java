package ism.groupe9.gestion_absence.data.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class DetailCour {
  @Id
  private String id;
  private LocalDateTime date;
  private String coursId;
  private String ClasseId;
}
