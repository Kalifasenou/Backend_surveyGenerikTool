package com.APISurvey.Application.generique.denquete.Modeles;


import javax.persistence.*;

@Entity
public class Presentation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String libelle;
    

    private boolean etatpresentation;
    

    private String datepublication;
    

    @OneToOne
    @JoinColumn(name = "resultat_id")
    private Resultat resultat;



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
    
    

    private boolean getEtatpresentation() {
        return this.etatpresentation;
    }
    

    private boolean setEtatpresentation(Boolean etatpresentation) {
        this.etatpresentation = etatpresentation;
        return etatpresentation;
    }
    
    

    private String getDatepublication() {
        return this.datepublication;
    }
    

    private String setDatepublication(String datepublication) {
        this.datepublication = datepublication;
        return datepublication;
    }


    public Resultat getResultat() {
        return this.resultat;
    }
    

    public Resultat setResultat(Resultat resultat) {
        this.resultat = resultat;
        return resultat;
    }

}
