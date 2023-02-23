package com.malicollecte.Services;

import com.malicollecte.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    Question CreerUneQuestion(String type, Question question );

    Question AfficherQuestion(Long id );

    void SupprimerQuestion(Long id );


    List<Question> getQuestionsByQuestionnaireId(Long questionnaireId);
}
