package com.APISurvey.Application.generique.denquete.Modeles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Presentation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String libelle;
    

    private boolean etatpresentation;
    

    private String datepublication;
    

    @OneToOne(mappedBy = "presentation")
    @JoinColumn(name = "resultat_id")
    private Resultat resultats;


    @OneToOne
    @JoinColumn(name = "resultat_id")
    private Sondage sondages;


}
