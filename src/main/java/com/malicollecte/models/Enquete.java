package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Enquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // L'identifiant de l'enquête

    private String libelle; // Le libellé de l'enquête
    private String description; // La description de l'enquête
    private String datedebut; // La date de début de l'enquête
    private String datefin; // La date de fin de l'enquête
    private String statut; // Le statut de l'enquête

    //private String nomOrganisation;
    private Boolean etat = false; // L'état de l'enquête (active ou non)

    private String type; // Le type d'enquête

    private String images; // Les images associées à l'enquête

    @ManyToOne
    @JsonIgnore
    private User utilisateur; // L'utilisateur associé à l'enquête

    @OneToOne(orphanRemoval = true)
    @JsonIgnore
    @JoinTable(name = "enquete_resultat", // Le nom de la table d'association entre l'enquête et le résultat
            joinColumns = @JoinColumn(name = "enquete_id"), // Le nom de la colonne dans la table d'association correspondant à l'enquête
            inverseJoinColumns = @JoinColumn(name = "resultat_id")) // Le nom de la colonne dans la table d'association correspondant au résultat
    private Resultat resultat; // Le résultat associé à l'enquête

}
