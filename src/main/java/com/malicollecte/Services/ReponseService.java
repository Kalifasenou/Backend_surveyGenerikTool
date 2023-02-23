package com.malicollecte.Services;

import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.models.Reponse;
import com.malicollecte.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReponseService {
  //  List<Reponse> AfficherTouteslesReponsesparQuestionnaires(Questionnaire questionnaire);

    //List<Reponse> AfficherTouteslesReponsesParUtilisateurs(Long user);

  //  Reponse getReponseByQuestionAndUser(Question question, User user);

   // List<Reponse> getUnansweredQuestionsByUserAndQuestionnaire(User user, Questionnaire questionnaire);

    Reponse AjouterReponse(Reponse Reponse);

    Reponse AfficherReponses(Long id);



 Reponse ModifierReponse(Long id, Reponse reponse);

    void SupprimerReponse(Long id);

    //List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question, Questionnaire questionnaire1001, Question question1);
}
