package com.malicollecte.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

 // @NotBlank
  //@Size(max = 20)
  private String username;

 // @NotBlank
  //@Size(max = 50)

  private String email;

  //@NotBlank
  @Size(min = 2, max = 120)
  private String password;

  //@NotBlank
 // @Size(min = 2, max = 15)
  private String prenom;

  //@NotBlank
  //@Size(min = 2, max = 20)
  private String nom;

  //@NotBlank
  //@Size(max = 8)
  private String numero;

  //NotBlank
  //@Size(max = 100)
  private String localite;

  private String organisation;

  //NotBlank
  private String genre;




  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();



  public User(String prenom, String nom, String numero, String localite, String genre, String organisation, String username, String email, String password) {
    this.prenom = prenom;
    this.nom = nom;
    this.numero = numero;
    this.localite = localite;
    this.genre = genre;
    this.organisation = organisation;
    this.username = username;
    this.email = email;
    this.password = password;

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }


  @OneToMany(mappedBy = "utilisateur")
  @JsonIgnore
  private List<Enquete> enquetes;

  @ManyToMany()
  @JsonIgnore
  List<Questionnaire> questionnairess;


}
