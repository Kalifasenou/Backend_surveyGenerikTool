package com.APISurvey.Application.generique.denquete.Modeles;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


@Entity
public class Sondage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String libelle;
    

    private boolean etatsondage;
    

    private String datedebut;
    

    private Date datefin;
    

    @OneToOne
    @JoinColumn(name = "resultat_id")
    private Resultat resultat;
    

    private Set<Question> question;
    

    private Utilisateur utilisateur;


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
    

    private boolean getEtatsondage() {
        return this.etatsondage;
    }
    

    private boolean setEtatsondage(Boolean etatsondage) {
        this.etatsondage = etatsondage;
        return etatsondage;
    }
    
    

    private String getDatedebut() {
        return this.datedebut;
    }
    

    private String setDatedebut(String datedebut) {
        this.datedebut = datedebut;
        return datedebut;
    }
    

    private Date getDatefin() {
        return this.datefin;
    }
    

    private Date setDatefin(Date datefin) {
        this.datefin = datefin;
        return datefin;
    }
    

    public Resultat getResultat() {
        return this.resultat;
    }
    

    public Resultat setResultat(Resultat resultat) {
        this.resultat = resultat;
        return resultat;
    }


    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }
    

    public Utilisateur setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        return utilisateur;
    }
    

    public Set<Question> getQuestion() {
        if (this.question == null) {
            this.question = new Set<Question>() {

                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<Question> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(Question question) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends Question> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public boolean equals(Object o) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 0;
                }
            };
        }
        return this.question;
    }
    

    public Set<Question> setQuestion(Question question) {
        this.question = (Set<Question>) question;
        return (Set<Question>) question;
    }


}
