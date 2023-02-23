package com.malicollecte.controllers;


import com.malicollecte.Services.QuestionService;
import com.malicollecte.Services.QuestionnaireService;
import com.malicollecte.models.Enquete;
import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.repository.EnqueteRepositorie;
import com.malicollecte.repository.QuestionnaireRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/questionnaire")
public class QuestionnaireControleur {

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionnaireRepositorie questionnaireRepositorie;



    @Autowired
    QuestionService questionService;
    @Autowired
    private EnqueteRepositorie enqueteRepositorie;

    @GetMapping("/afficher/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public Questionnaire afficherQuestionnaire(@PathVariable Long id){
        return questionnaireService.AfficherUn(id);
    }

    @PostMapping("/ajouter/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public Questionnaire ajouterQuestionnaire(@PathVariable Long id, @RequestBody Questionnaire questionnaire){
        return questionnaireService.Creer(id, questionnaire);
    }

    @GetMapping("/toutafficher")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public List<Questionnaire> toutafficher(){
        return questionnaireService.ToutAfficher();
    }

    @PutMapping("modifier/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public Questionnaire modifierQuestionnaire(@PathVariable Long id, @RequestBody Questionnaire questionnaire){
        return questionnaireService.Modifier(id, questionnaire);
    }


    @DeleteMapping("/supprimerquestion/{id}")
    public void supprimerQuestionnaire(@PathVariable Long id){
        questionnaireService.SupprimerQuestion(id);
    }

    @PostMapping("/ajoutquestion/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public String AjouterQuestion(@PathVariable Long id, @RequestBody Question question){
        return questionnaireService.AjouterQuestion(id, question);
    }

    @GetMapping("/affichertoutquestions")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public List<Question> questions(){
        return questionnaireService.AfficherTouteQuestion();
    }


    @PostMapping("/ajoutrepondant/{id}/{idUsers}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public String ajouterRepondant(@PathVariable Long id, @RequestBody List<Long> idUsers){
        return questionnaireService.AjouterRepondant(id, idUsers);
    }

    @PostMapping("/ajouterquestionnaire/{id}")
    public Questionnaire ajouterQ( @RequestBody Questionnaire questionnaire,@PathVariable Long id){
        Optional<Enquete> enquete = enqueteRepositorie.findById(id);
        Questionnaire questionnaire1 = new  Questionnaire();
       // questionnaire1.setEnquete(questionnaire.getEnquete());
        questionnaire1.setEnquete(enquete.get());
        questionnaire1.setLibellequestionnaire(questionnaire.getLibellequestionnaire());

        return  questionnaireService.ajouter(questionnaire1);
    }

//    @GetMapping("afficherquestionnaire/{idenquete}")
//    public Questionnaire TrouverEnquete(@PathVariable Long idEnquete) {
//        return questionnaireRepositorie.findQuestionnaireByEnqudete(idEnquete);
//    }


    @GetMapping("/afficherquestionnaire/{enqueteId}")
    public ResponseEntity<Questionnaire> getQuestionnaireByEnqueteId(@PathVariable Long enqueteId) {
        Optional<Questionnaire> questionnaire = questionnaireRepositorie.findFirstByEnqueteId(enqueteId);
        return questionnaire.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


/*    @PostMapping("ajouterquestions/{questionnaireId}")
    public ResponseEntity<String> addQuestionsToQuestionnaire(@PathVariable Long questionnaireId, @RequestBody List<Question> questions) {
        questionnaireService.addQuestionsToQuestionnaire(questionnaireId, questions);
        return ResponseEntity.ok().body("Questions added to questionnaire with ID: " + questionnaireId);
    }*/
}
