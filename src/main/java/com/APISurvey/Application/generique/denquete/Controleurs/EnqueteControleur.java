package com.APISurvey.Application.generique.denquete.Controleurs;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Services.EnqueteService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/enquete")
public class EnqueteControleur {

        @Autowired
        private EnqueteService enqueteService;

        @PostMapping("/creer")
        public Enquete CreerEnquete(@RequestBody Enquete enquete) {
            return enqueteService.CreerEnquete(enquete);
        }

        @PutMapping("/modifier/{id}")
        public Enquete ModifierEnquete(@PathVariable Long id, @RequestBody Enquete enquete) {
            return enqueteService.ModifierEnquete(id, enquete);
        }

        @DeleteMapping("/supprimer/{id}")
        public String SupprimerEnquete(@PathVariable Long id, Enquete enquete) {
            return enqueteService.SupprimerEnquete(id, enquete);
        }

        @GetMapping("/afficherun/{id}")
        public Enquete AfficherUneEnquete(@PathVariable Long id) {
            return enqueteService.AfficherUneEnquete(id);
        }

        @GetMapping("/affichertout")
        public List<Enquete> AfficherTousEnquete() {
            return enqueteService.AfficherTousEnquete();
        }


    @PostMapping("/{id}/formulaires")
    public Formulaire createFormulaire(@PathVariable Long id, @RequestBody Formulaire formulaire) {
        return enqueteService.CreerFormulaire(id, formulaire);
    }

    @PutMapping("/formulaires/{id}")
    public Formulaire updateFormulaire(@PathVariable Integer id, @RequestBody Formulaire formulaire) {
        return enqueteService.ModifierFormulaire(id, formulaire);
    }

    @DeleteMapping("/formulaires/{id}")
    public String deleteFormulaire(@PathVariable Integer id) {
        return enqueteService.SupprimerFormulaire(id);
    }

    @GetMapping("/formulaires/{id}")
    public Formulaire getFormulaire(@PathVariable Integer id) {
        return enqueteService.AfficherUnFormulaire(id);
    }


    @GetMapping("/formulaires/enquete/{id}")
    public List<Formulaire> getFormulairesByEnquete(@PathVariable Long id) {
        return enqueteService.AfficherTousFormulairesByEnquete(id);
    }

    @GetMapping("/formulaires")
    public List<Formulaire> getAllFormulaires(Long id) {
        return enqueteService.AfficherTousFormulaires(id);
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException {
        enqueteService.ImporterEnquete(file);
    }
}




