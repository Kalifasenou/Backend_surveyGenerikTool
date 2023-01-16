package com.APISurvey.Application.generique.denquete.Controleurs;


import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Modeles.Question;
import com.APISurvey.Application.generique.denquete.Modeles.Typedonnee;
import com.APISurvey.Application.generique.denquete.Services.FormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulaires")
public class FormulaireControleur {


        @Autowired
        private FormulaireService formulaireService;

        @PostMapping
        public Formulaire CreerForm(@RequestBody Formulaire formulaire) {
            return formulaireService.CreerForm(formulaire);
        }

        @PutMapping("/{id}")
        public Formulaire ModifierForm(@PathVariable Integer id, @RequestBody Formulaire formulaire) {
            return formulaireService.ModifierForm(id, formulaire);
        }

        @DeleteMapping("/{id}")
        public Formulaire SupprimerForm(@PathVariable Integer id) {
            return formulaireService.SupprimerForm(id);
        }

        @GetMapping("/{id}")
        public Formulaire AfficherForm(@PathVariable Integer id) {
            return formulaireService.AfficherForm(id);
        }

        @GetMapping
        public List<Formulaire> AfficherAllForm() {
            return formulaireService.AfficherAllForm();
        }

        @PostMapping("/{idFormulaire}/questions")
        public Formulaire ajouterQuestion(@PathVariable Integer idFormulaire, @RequestBody Question question) {
            return formulaireService.ajouterQuestion(idFormulaire, question);
        }

        @PutMapping("/questions/{questionId}")
        public Question ModifierQuestion(@PathVariable Integer questionId, @RequestBody Question question, @RequestParam Typedonnee type) {
            return formulaireService.ModifierQuestion(questionId, question, type);
        }

        @DeleteMapping("/questions/{questionId}")
        public void SupprimerQuestion(@PathVariable Integer questionId) {
            formulaireService.SupprimerQuestion(questionId);
        }
    }

