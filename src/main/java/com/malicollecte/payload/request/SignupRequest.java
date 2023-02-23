package com.malicollecte.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.validation.constraints.*;


@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    //@Size(max = 50)
    //@Email
    private String email;


    @NotBlank
    @Size(min = 2, max = 15)
    private String prenom;

    @NotBlank
    @Size(min = 2, max = 20)
    private String nom;

    @NotBlank
    @Size(max = 8)
    private String numero;

    @NotBlank
    @Size(max = 100)
    private String localite;

    @NotBlank
    private String genre;

    @NotBlank
    private String organisation;

    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
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
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
