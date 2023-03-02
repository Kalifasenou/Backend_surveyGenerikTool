package com.malicollecte.controllers;

import com.malicollecte.Services.ReponseService;
import com.malicollecte.models.Question;
import com.malicollecte.models.Reponse;
import com.malicollecte.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponse")
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials="true")
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
        public ResponseEntity<?> createReponse(@RequestBody Reponse reponse) {
            return reponseService.AjouterReponse(reponse);
        }

        @PutMapping("modifier/{ReponseId}")
        public Reponse updateReponse(@PathVariable Long ReponseId, @RequestBody Reponse Reponse) {
            return reponseService.ModifierReponse(ReponseId, Reponse);
        }

        @DeleteMapping("supprimer/{ReponseId}")
        public String deleteReponse(@PathVariable Long id) {
            reponseService.SupprimerReponse(id);

            return "Reponse supprimé";
        }

        @PostMapping("/ajouterunereponseaunequestion/{user}/{question}")
        public ResponseEntity<?> ajouterunereponseaunequestion(@PathVariable User user, @PathVariable Question question, @RequestBody Reponse reponse){
            reponse.setUser(user);
            reponse.setQuestion(question);
            return ResponseEntity.ok(reponseService.AjouterReponse(reponse));
        }
    }