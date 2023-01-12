package com.APISurvey.Application.generique.denquete.Modeles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Formulaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String libelle;
    

    private boolean etatformulaire;
    
    

    @OneToMany
    @JoinColumn(name = "question_id")
    private Question question;
    

    private Set<Enquete> enquete;


    private Long getId() {
        return this.id;
    }
    

    private Long setId(Long id) {
        this.id = id;
        return id;
    }
    

    private String getLibelle() {
        return this.libelle;
    }
    

    private String setLibelle(String libelle) {
        this.libelle = libelle;
        return libelle;
    }
    
    

    private boolean getEtatformulaire() {
        return this.etatformulaire;
    }
    

    private boolean setEtatformulaire(Boolean etatformulaire) {
        this.etatformulaire = etatformulaire;
        return etatformulaire;
    }
    
    
    

    public Set<Enquete> getEnquete() {
        if (this.enquete == null) {
            this.enquete = new HashSet<Enquete>();
        }
        return this.enquete;
    }
    

    public Set<Enquete> setEnquete(Enquete enquete) {
        this.enquete = (Set<Enquete>) enquete;
        return (Set<Enquete>) enquete;
    }
    
    

    public Question getQuestion() {
        return this.question;
    }
    

    public Question setQuestion(Question question) {
        this.question = question;
        return question;
    }
    
    

    
}
