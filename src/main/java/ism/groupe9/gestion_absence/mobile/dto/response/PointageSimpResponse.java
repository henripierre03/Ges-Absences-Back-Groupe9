package ism.groupe9.gestion_absence.mobile.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PointageSimpResponse {

    @Schema(description = "Statut de l'opération", example = "Présence enregistrée")
    private String message;

    public PointageSimpResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}