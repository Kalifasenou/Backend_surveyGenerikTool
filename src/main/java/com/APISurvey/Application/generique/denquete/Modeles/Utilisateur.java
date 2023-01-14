package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Utilisateur {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    private String nom;
    

    private String prenom;
    

    private String pseudo;
    

    private String mail;
    

    private String motdepasse;
    

    private boolean etatuser = false;
    
    

    @OneToMany(mappedBy = "utilisateur")
   // @JoinColumn(name = "question_id")
    private List<Question> question = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "sondage_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sondage_id"))
    private List<Sondage> sondage = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Set<Role> roles = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "enquete_id"))
    private List<Enquete> enquete = new ArrayList<>();


}
