package com.malicollecte.controllers;

import com.malicollecte.Services.UtilisateurServices;
import com.malicollecte.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserControleur {

    @Autowired
    UtilisateurServices utilisateurServices;


    @GetMapping("/afficher/{email}")
    public User AfficherUnUtilisateur(@PathVariable("email") String email) {
        return utilisateurServices.AfficherUnUtilisateut(email);
    }

    @GetMapping("/afficher")
    public List<User> AfficherToutUtilisateur() {
        return utilisateurServices.AfficherToutUtilisateur();
    }

    @PutMapping("/modifier/{id}")
    public String ModifierUtilisateur(@PathVariable("id") Long id, @RequestBody User user) {
        return utilisateurServices.ModifierUtilisateur(id, user);
    }

    @DeleteMapping("/supprimer/{id}")
    public String SupprimerUtilisateur(@PathVariable("id") Long id) {
        return utilisateurServices.SupprimerUtilisateur(id);
    }

    @PutMapping("/modifierMotDePasse/{id}/{password}")
    public String ModifierMotDePasse(@PathVariable("id") Long id, @PathVariable("password") String password) {
        return utilisateurServices.ModifierMotDePasse(id, password);
    }

    @PutMapping("/modifierEmail/{id}/{email}")
    public String ModifierEmail(@PathVariable("id") Long id, @PathVariable("email") String email) {
        return utilisateurServices.ModifierEmail(id, email);
    }

    @PostMapping("/modifier/{id}/{role}")
    public String ModifierRole(@PathVariable("id") Long id, @PathVariable Set<String> role){
        return utilisateurServices.ModifierRole(id, role);
    }

    @PutMapping("/modifierOrganisation/{id}/{organisation}")
    public String ModifierOrganisation(@PathVariable("id") Long id, @PathVariable("organisation") String organisation) {
        return utilisateurServices.ModifierOrganisation(id, organisation);
    }

    @PutMapping("/modifierAddress/{id}/{address}")
    public String ModifierAddress(@PathVariable("id") Long id, @PathVariable("address") String address) {
        return utilisateurServices.ModifierAddress(id, address);
    }

    @PutMapping("/modifierPhone/{id}/{phone}")
    public String ModifierPhone(@PathVariable("id") Long id, @PathVariable("phone") String phone) {
        return utilisateurServices.ModifierPhone(id, phone);
    }
}
