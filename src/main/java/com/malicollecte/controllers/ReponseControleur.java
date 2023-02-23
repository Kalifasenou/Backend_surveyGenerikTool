package com.malicollecte.controllers;

import com.malicollecte.Services.ReponseService;
import com.malicollecte.models.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponse")
public class ReponseControleur {


        @Autowired
        private ReponseService reponseService;

        @GetMapping("/afficher/{Id}")
        public Reponse getReponse(@PathVariable Long id) {
            return reponseService.AfficherReponses(id);
        }


        //@GetMapping("/afficher/user/{userId}")
        //public List<Reponse> getReponsesByUser(@PathVariable Long userId) {            return reponseService.AfficherTouteslesReponsesParUtilisateurs(userId);}

        @PostMapping
        public Reponse createReponse(@RequestBody Reponse reponse) {
            return reponseService.AjouterReponse(reponse);
        }

        @PutMapping("/{ReponseId}")
        public Reponse updateReponse(@PathVariable Long ReponseId, @RequestBody Reponse Reponse) {
            return reponseService.ModifierReponse(ReponseId, Reponse);
        }

        @DeleteMapping("/{ReponseId}")
        public String deleteReponse(@PathVariable Long id) {
            reponseService.SupprimerReponse(id);

            return "Reponse supprimé";
        }
    }


