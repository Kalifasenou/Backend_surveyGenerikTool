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
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String nom;
    

    private String prenom;

    

    private String email;

    

    private boolean etatuser = false;

    private String username;

    private String password;
    
    

    @OneToMany(mappedBy = "user")
   // @JoinColumn(name = "question_id")
    private List<Question> question = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "sondage_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sondage_id"))
    private List<Sondage> sondage = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Role> role = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_enquetes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "enquete_id"))
    private List<Enquete> enquete = new ArrayList<>();

    public User(String username, String email, String password, String prenom, String nom) {
        this.nom=nom;
        this.prenom=prenom;
        this.username=username;
        this.email = email;
        this.password=password;

    }



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
