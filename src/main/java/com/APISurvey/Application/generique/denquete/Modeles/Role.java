package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String libelle;
    

    private boolean etatrole = false;


    @ManyToMany
    @JoinColumn(name = "utilisateur_id")
    private List<Utilisateur> utilisateur = new ArrayList<>();
    


}
