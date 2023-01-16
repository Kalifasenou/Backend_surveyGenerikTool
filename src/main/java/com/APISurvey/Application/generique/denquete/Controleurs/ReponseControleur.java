package com.APISurvey.Application.generique.denquete.Controleurs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.APISurvey.Application.generique.denquete.Services.ReponseService;
import com.APISurvey.Application.generique.denquete.Modeles.Reponse;
import java.util.List;


@RestController
@RequestMapping("/reponses")
public class ReponseControleur {


        @Autowired
        private ReponseService reponseService;

        @PostMapping("/creer")
        public Reponse CreerReponse(@RequestBody Reponse reponse) {
            return reponseService.CreerReponse(reponse);
        }

        @GetMapping("/afficherUn/{id}")
        public Reponse AfficherReponse(@PathVariable Integer id) {
            return reponseService.AfficherReponse(id);
        }

        @DeleteMapping("/supprimer/{id}")
        public Reponse SupprimerReponse(@PathVariable Integer id) {
            return reponseService.SupprimerReponse(id);
        }

        @PutMapping("/modifier/{id}")
        public Reponse ModifierReponse(@PathVariable Integer id, @RequestBody Reponse reponse) {
            return reponseService.ModifierReponse(id, reponse);
        }

        @GetMapping("/affichertout")
        public List<Reponse> AfficherAllReponse() {
            return reponseService.AfficherAllReponse();
        }
    }

