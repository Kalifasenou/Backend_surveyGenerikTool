package com.APISurvey.Application.generique.denquete.Modeles;

import javax.persistence.*;


@Entity
public class Resultat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String libelle;
    

    private boolean etatresultat;
    

//    private  attribute;
    
    

    @OneToOne
    @JoinColumn(name = "sondage_id")
    private Sondage sondage;
    

    @OneToOne
    @JoinColumn(name = "presentation_id")
    private Presentation presentation;
    

    @OneToOne
    @JoinColumn(name = "enquete_id")
    private Enquete enquete;


//    public void setEnquete(Enquete enquete) {
//        this.enquete = enquete;
//    }

//    public void setPresentation(Presentation presentation) {
//        this.presentation = presentation;
//    }


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
    
    

    private boolean getEtatresultat() {
        return this.etatresultat;
    }
    

    private boolean setEtatresultat(Boolean etatresultat) {
        this.etatresultat = etatresultat;
        return etatresultat;
    }
    
    

    //private  getAttribute() {
        //return this.attribute;
    //}
    

//    private  setAttribute(invalid attribute) {
//        this.attribute = attribute;
  //  }
    
    
    

    public Sondage getSondage() {
        return this.sondage;
    }
    

    public Sondage setSondage(Sondage sondage) {
        this.sondage = sondage;
        return sondage;
    }
    
    

    public Presentation getPresentation() {
        return this.presentation;
    }
    

    public Presentation setPresentation(Presentation presentation) {
        this.presentation = presentation;
        return presentation;
    }
    
    

    public Enquete getEnquete() {
        return this.enquete;
    }
    

    public Enquete setEnquete(Enquete enquete) {
        this.enquete = enquete;
        return enquete;
    }
    

}
