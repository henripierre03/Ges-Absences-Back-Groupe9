package ism.groupe9.gestion_absence.mobile.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class PointageSimpleResponse {

    @Schema(description = "Statut de l'opération", example = "Présence enregistrée")
    private String message;

    public PointageSimpleResponse(String message) {
        this.message = message;
    }

    public PointageSimpleResponse() {
        //TODO Auto-generated constructor stub
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDateTime date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTypeAbsence(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTypeAbsence'");
    }
}