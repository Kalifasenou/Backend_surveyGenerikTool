package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String libelle;
    

    private boolean etatresultat = false;
    


    @OneToOne(mappedBy = "question")
    private Sondage sondage;
    

    @OneToOne
    @JoinColumn(name = "presentation_id")
    private Presentation presentation;
    

    @OneToOne
    @JoinColumn(name = "enquete_id")
    private Enquete enquete;


}
