package com.APISurvey.Application.generique.denquete.Modeles;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String libelle;
    

    private boolean etatrole;


    private Set<Utilisateur> utilisateur;
    

    private int getId() {
        return this.id;
    }
    

    private int setId(Integer id) {
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
    

    private boolean getEtatrole() {
        return this.etatrole;
    }
    

    private boolean setEtatrole(Boolean etatrole) {
        this.etatrole = etatrole;
        return etatrole;
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
    

}
