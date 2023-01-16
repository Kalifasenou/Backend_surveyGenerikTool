package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    
    @Id
    private Long id;
    

    private String libelle;
    

    private boolean etatquestion;
    

    @OneToOne
    @JoinColumn(name = "sondage_id")
    private Sondage sondage;
    
    @ManyToOne
    private User user;
    

    @ManyToOne
    private Formulaire formulaire;
    


    @ManyToOne
    private Enquete enquete;


    @OneToOne(mappedBy = "questions")
    private Reponse reponses ;


    public void setType(String type) {
    }

    public void setOptions(List<String> options) {

    }
}
