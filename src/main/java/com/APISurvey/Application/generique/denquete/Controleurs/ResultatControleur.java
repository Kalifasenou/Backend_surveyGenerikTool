package com.APISurvey.Application.generique.denquete.Controleurs;

import com.APISurvey.Application.generique.denquete.Modeles.Resultat;
import com.APISurvey.Application.generique.denquete.Services.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultat")
public class ResultatControleur {

        @Autowired
        private ResultatService resultatService;

        @PostMapping("/create")
        public Resultat CreerResultat(@RequestBody Resultat resultat) {
            return resultatService.CreerResultat(resultat);
        }

        @GetMapping("/{id}")
        public Resultat AfficherResultat(@PathVariable Integer id) {
            return resultatService.AfficherResultat(id);
        }

        @GetMapping("/all")
        public List<Resultat> AfficherAllResultat() {
            return resultatService.AfficherAllResultat();
        }

        @DeleteMapping("/{id}")
        public void SupprimerResultat(@PathVariable Integer id) {
            resultatService.SupprimerResultat(id);
        }

        @GetMapping("/publish")
        public Resultat PublierResultat() {
            return resultatService.PublierResultat();
        }
    }

