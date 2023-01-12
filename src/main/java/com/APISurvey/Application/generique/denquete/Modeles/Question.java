package com.APISurvey.Application.generique.denquete.Modeles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Question {
    
    @Id
    private Long id;
    

    private String libelle;
    

    private boolean etatquestion;
    

    private Set<Sondage> sondage;
    

    private Utilisateur utilisateur;
    

    @ManyToOne
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;
    

    private Set<Enquete> enquete;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "question_question",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
    private Set<Reponse> reponses = new LinkedHashSet<>();

    public Set<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(Set<Reponse> reponses) {
        this.reponses = reponses;
    }

/*    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }*/


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
    

    private boolean getEtatquestion() {
        return this.etatquestion;
    }
    

    private boolean setEtatquestion(Boolean etatquestion) {
        this.etatquestion = etatquestion;
        return etatquestion;
    }
    

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }
    

    public Utilisateur setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        return utilisateur;
    }
    

    public Formulaire getFormulaire() {
        return this.formulaire;
    }
    

    public Formulaire setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
        return formulaire;
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
    

    public Set<Sondage> getSondage() {
        if (this.sondage == null) {
            this.sondage = new HashSet<Sondage>();
        }
        return this.sondage;
    }


    public Set<Sondage> setSondage(Sondage sondage) {
        this.sondage = (Set<Sondage>) sondage;
        return (Set<Sondage>) sondage;
    }
    

}
