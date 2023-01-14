package com.APISurvey.Application.generique.denquete.Modeles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enquete {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String libelle;
    

    private boolean etatenquete;
    

    private String datedebut;
    

    private LocalDate datefin;
    

    private String statut;
    
    

    @OneToOne
    @JoinColumn(name = "resultat_id")
    private Resultat resultat;


    @ManyToMany
    @JoinTable(
            name = "enquete_forms",
            joinColumns = @JoinColumn(name = "forms_id"),
            inverseJoinColumns = @JoinColumn(name = "enquete_id"))
    Set<Formulaire> formulaires;


    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Question> question = new ArrayList<>();



}
