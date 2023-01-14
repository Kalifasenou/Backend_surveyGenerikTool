package com.APISurvey.Application.generique.denquete.Modeles;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
public class Typedonnee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String texte;

    private Long chiffre;

    private Date date;

    //private Point geolocalisation;

    private String choixunique;

    private String choixmultiple;
    @OneToOne(mappedBy = "typesdonnee")
    private Reponse reponse;



}
