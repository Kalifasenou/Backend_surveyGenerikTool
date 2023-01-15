package com.APISurvey.Application.generique.denquete.Modeles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sondage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String libelle;
    

    private boolean etatsondage;
    

    private Date datedebut;
    

    private Date datefin;


    

    @OneToOne()
    private Resultat resultat;


    @OneToOne( targetEntity=Question.class, fetch = FetchType.LAZY)
    private Question question;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "sondage_users",
            joinColumns = @JoinColumn(name = "sondage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user = new ArrayList<>();




}
