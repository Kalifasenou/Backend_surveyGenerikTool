package com.malicollecte.Services;

import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionnaireService {

    List<Questionnaire> ToutAfficher();

    Questionnaire AfficherUn(Long id);
    Questionnaire ajouter(Questionnaire questionnaire );

    Questionnaire Creer(Long id, Questionnaire questionnaire);

    Questionnaire Modifier(Long id, Questionnaire questionnaireDetails);

    String AjouterQuestion (Long id, Question question);

    String SupprimerQuestion (Long id);

    List<Question> AfficherTouteQuestion ();

    String AjouterRepondant(Long id, List<Long> idUsers);

    void addQuestionsToQuestionnaire(Long questionnaireId, List<Question> questions);
}
