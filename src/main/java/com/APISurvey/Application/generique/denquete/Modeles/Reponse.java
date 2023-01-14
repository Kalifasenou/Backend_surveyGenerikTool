package com.APISurvey.Application.generique.denquete.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    private Boolean etatreponse=false;


    @OneToOne( targetEntity=Typedonnee.class, fetch = FetchType.LAZY)
    private Typedonnee typesdonnee;

    //@ManyToOne(fetch = FetchType.LAZY,
           // cascade = {CascadeType.PERSIST,CascadeType.MERGE})
   // @JsonIgnore
    @OneToOne
    private Question questions;

}
