package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Formulaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String libelle;
    

    private boolean etatformulaire;



    @OneToMany(mappedBy = "formulaire")
    private List<Question> questions = new ArrayList<>();


    @OneToOne
    private Enquete enquete;



    @ManyToMany
    @JoinTable(
            name = "Sondage_forms",
            joinColumns = @JoinColumn(name = "sondage_id"),
            inverseJoinColumns = @JoinColumn(name = "forms_id"))
    Set<Sondage> sondages;

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public Enquete getEnquete() {
        return enquete;
    }



/*

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



*/

}
