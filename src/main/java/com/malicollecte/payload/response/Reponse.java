package com.malicollecte.payload.response;

import lombok.Data;

@Data
public class Reponse {
    private String message;
    private int status;

    public Reponse(String questionAjouté, int i) {
        this.message = questionAjouté;
        this.status = i;
    }
}
