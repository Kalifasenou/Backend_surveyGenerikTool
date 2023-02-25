package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // L'identifiant de la question

    private String intitule; // L'intitulé de la question
    private String type; // Le type de la question

    @JoinColumn(name = "questionnaire_id") // La clé étrangère vers le questionnaire
    @ManyToOne
    private Questionnaire questionnaire; // Le questionnaire associé à la question

}
