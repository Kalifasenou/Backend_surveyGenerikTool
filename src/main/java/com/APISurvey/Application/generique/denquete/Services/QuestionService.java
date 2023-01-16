package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Question;

import java.util.List;

public interface QuestionService {


    Question CreerQuestionNombre(String libelle);

    Question CreerQuestionText(String libelle);

    Question CreerQuestionMultipleChoice(String libelle, List<String> options);

    Question CreerQuestionOneChoice(String libelle, List<String> options);
    Question CreerQuestion(Question question);


    Question ModifierQuestion(Integer id, Question question);


    String SupprimerQuestion(Integer id);


    Question AfficherQuestion(Integer id);


    List<Question> AfficherAllQuestion();


}
