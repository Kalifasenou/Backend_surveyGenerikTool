package com.APISurvey.Application.generique.denquete.Modeles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
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



    

/*    private Set<Question> question;
    

    private Set<Formulaire> formulaire;
    

    private Set<Utilisateur> utilisateur;


    private String getLibelle() {
        return this.libelle;
    }
    

    private String setLibelle(String libelle) {
        this.libelle = libelle;
        return libelle;
    }
    
    

    private boolean getEtatenquete() {
        return this.etatenquete;
    }
    

    private boolean setEtatenquete(Boolean etatenquete) {
        this.etatenquete = etatenquete;
        return etatenquete;
    }


    private String getDatedebut() {
        return this.datedebut;
    }
    

    private String setDatedebut(String datedebut) {
        this.datedebut = datedebut;
        return datedebut;
    }
    

    private String getDatefin() {
        return this.datefin;
    }
    

    private String setDatefin(String datefin) {
        this.datefin = datefin;
        return datefin;
    }
    

    private String getStatut() {
        return this.statut;
    }
    

    private String setStatut(String statut) {
        this.statut = statut;
        return statut;
    }
    

    public Set<Formulaire> getFormulaire() {
        if (this.formulaire == null) {
            this.formulaire = new HashSet<Formulaire>();
        }
        return this.formulaire;
    }
    

    public Set<Formulaire> setFormulaire(Formulaire formulaire) {
        this.formulaire = (Set<Formulaire>) formulaire;
        return (Set<Formulaire>) formulaire;
    }
    

    public Resultat getResultat() {
        return this.resultat;
    }


    public Resultat setResultat(Resultat resultat) {
        this.resultat = resultat;
        return resultat;
    }
    

    public Set<Utilisateur> getUtilisateur() {
        if (this.utilisateur == null) {
            this.utilisateur = new HashSet<Utilisateur>();
        }
        return this.utilisateur;
    }



    public Set<Utilisateur> setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        return utilisateur;
    }


    public Set<Question> getQuestion() {
        if (this.question == null) {
            this.question = new HashSet<Question>();
        }
        return this.question;
    }
    

    public Set<Question> setQuestion(Question question) {
        this.question = (Set<Question>) question;
        return (Set<Question>) question;
    }
    */
}
