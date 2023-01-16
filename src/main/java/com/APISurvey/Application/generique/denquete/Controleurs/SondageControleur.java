package com.APISurvey.Application.generique.denquete.Controleurs;

import com.APISurvey.Application.generique.denquete.Modeles.Sondage;
import com.APISurvey.Application.generique.denquete.Services.SondageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sondages")
public class SondageControleur {


        @Autowired
        SondageService sondageService;

        @PostMapping
        public Sondage CreerSondage(@RequestBody Sondage sondage) {
            return sondageService.CreerSondage(sondage);
        }

        @GetMapping("/{id}")
        public Sondage AfficherSondage(@PathVariable Integer id) {
            return sondageService.AfficherSondage(id);
        }

        @GetMapping
        public List<Sondage> AfficherAllSondage() {
            return sondageService.AfficherAllSondage();
        }

        @PutMapping("/{id}")
        public Sondage ModifierSondage(@PathVariable Integer id, @RequestBody Sondage sondage) {
            return sondageService.ModifierSondage(id, sondage);
        }

        @DeleteMapping("/{id}")
        public Sondage SupprimerSondage(@PathVariable Integer id) {
            return sondageService.SupprimerSondage(id);
        }

/*        @PostMapping("/{id}/options")
        public void addOption(@PathVariable Integer id, @RequestBody MultiValueOption option) {
            sondageService.addOption(id, option);
        }*/
    }

