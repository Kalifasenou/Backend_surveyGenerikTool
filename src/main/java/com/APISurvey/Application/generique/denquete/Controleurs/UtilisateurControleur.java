package com.APISurvey.Application.generique.denquete.Controleurs;
import com.APISurvey.Application.generique.denquete.Modeles.User;
import com.APISurvey.Application.generique.denquete.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurControleur {


        @Autowired
        UtilisateurService utilisateurService;

        @PostMapping("/creer")
        public User CreerUtilisateur(@RequestBody User user) {
            return utilisateurService.CreerUtilisateur(user);
        }

        @PutMapping("/modifier/{id}")
        public User ModifierUtilisateur(@PathVariable Integer id, @RequestBody User user) {
            return utilisateurService.ModifierUtilisateur(id, user);
        }

        @DeleteMapping("/supprimer/{id}")
        public User SupprimerUtilisateur(@PathVariable Integer id) {
            return utilisateurService.SupprimerUtilisateur(id);
        }

        @GetMapping("/afficher/{id}")
        public User AfficherUtilisateur(@PathVariable Integer id) {
            return utilisateurService.AfficherUtilisateur(id);
        }

        @GetMapping("/affichertout")
        public List<User> AfficherAllUtilisateur() {
            return utilisateurService.AfficherAllUtilisateur();
        }

        @PutMapping("/utilisateur/{id}/motdepasse")
        public String ModifierMotdepasse(@PathVariable Integer id) {
            return utilisateurService.ModifierMotdepasse(id);
        }
    }

