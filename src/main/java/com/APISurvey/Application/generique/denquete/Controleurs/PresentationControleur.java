package com.APISurvey.Application.generique.denquete.Controleurs;


import com.APISurvey.Application.generique.denquete.Modeles.Presentation;
import com.APISurvey.Application.generique.denquete.Services.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presentations")
public class PresentationControleur {

        @Autowired
        private PresentationService presentationService;

        @PostMapping
        public Presentation CreerPresentation(@RequestBody Presentation presentation) {
            return presentationService.CreerPresentation(presentation);
        }

        @GetMapping("/{id}")
        public Presentation AfficherPresentation(@PathVariable Integer id) {
            return presentationService.AfficherPresentation(id);
        }

        @GetMapping
        public List<Presentation> AfficherAllPresentation() {
            return presentationService.AfficherAllPresentation();
        }

        @DeleteMapping("/{id}")
        public Presentation SupprimerPresentation(@PathVariable Integer id, @RequestBody Presentation presentation) {
            return presentationService.SupprimerPresentation(id, presentation);
        }

        @PostMapping("/share")
        public String PartagerPresentation(@RequestParam Integer id, @RequestParam String email, @RequestParam String socialNetwork) throws InstantiationException, IllegalAccessException {
            return presentationService.PartagerPresentation(id, email, socialNetwork);
        }
    }

