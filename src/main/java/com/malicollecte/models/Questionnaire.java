package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // L'identifiant du questionnaire

    private String libellequestionnaire; // Le libellé du questionnaire

    private int nombrequestions;

    @OneToOne
    private Enquete enquete;// L'enquête associée au questionnaire

    @OneToMany
    private List<Question> questions; // La liste des questions du questionnaire

    private String etatAvancement; // L'état d'avancement du questionnaire

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_questionnaire",
            joinColumns = @JoinColumn(name = "questionnaire_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> utilisateur_id;

}
