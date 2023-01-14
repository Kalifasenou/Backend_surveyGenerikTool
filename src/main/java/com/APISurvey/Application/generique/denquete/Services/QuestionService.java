package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Question;

import java.util.List;

public interface QuestionService {


    Question CreerQuestion(Question question);


    Question ModifierQuestion(Integer id, Question question);


    String SupprimerQuestion(Integer id);


    Question AfficherQuestion(Integer id);


    List<Question> AfficherAllQuestion();


}
