package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // L'identifiant de la réponse

    private String typetexte; // reponse de type texte

    private String typechiffre; // reponse de type chiffre

    private String typechoixunique; // reponse de type choix unique

    private String typechoixmultiple; // reponse de type choix multiple



    @ManyToOne
    @JoinColumn(name = "question")
    private Question question; // La question à laquelle la réponse est associée

    @JsonIgnore
    @ManyToOne
    private User user; //

}
