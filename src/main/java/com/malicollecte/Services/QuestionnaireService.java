package com.malicollecte.Services;

import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.payload.response.MessageResponse;
import com.malicollecte.payload.response.Reponse;

import java.util.List;


public interface QuestionnaireService {

    List<Questionnaire> ToutAfficher();

    Questionnaire AfficherUn(Long id);
    Questionnaire ajouter(Questionnaire questionnaire );

    Questionnaire Creer(Long id, Questionnaire questionnaire);

    Questionnaire Modifier(Long id, Questionnaire questionnaireDetails);

    Reponse AjouterQuestion (Long id, Question question);

    String SupprimerQuestion (Long id);

    List<Question> AfficherTouteQuestion ();

    String AjouterRepondant(Long id, List<Long> idUsers);

    void addQuestionsToQuestionnaire(Long questionnaireId, List<Question> questions);
}
