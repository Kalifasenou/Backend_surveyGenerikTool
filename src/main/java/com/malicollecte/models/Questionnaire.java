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
    private Long id;


    private String libellequestionnaire;


    @OneToOne
    private Enquete enquete;

    @OneToMany
    @JsonIgnore
    private List<Question> questions;

    private String etatAvancement;


}
