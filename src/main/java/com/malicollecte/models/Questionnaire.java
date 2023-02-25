package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // L'identifiant du questionnaire

    private String libellequestionnaire; // Le libellé du questionnaire

    private int nombrequestions;

    @OneToOne
    private Enquete enquete; // L'enquête associée au questionnaire

    @OneToMany
    @JsonIgnore
    private List<Question> questions; // La liste des questions du questionnaire

    private String etatAvancement; // L'état d'avancement du questionnaire

}
