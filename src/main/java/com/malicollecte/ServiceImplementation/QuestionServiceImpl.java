package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.QuestionService;
import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.repository.QuestionRepositorie;
import com.malicollecte.repository.QuestionnaireRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private final QuestionRepositorie questionRepositorie;
    private final QuestionnaireRepositorie questionnaireRepositorie;

    public QuestionServiceImpl(QuestionRepositorie questionRepositorie,
                               QuestionnaireRepositorie questionnaireRepositorie) {
        this.questionRepositorie = questionRepositorie;
        this.questionnaireRepositorie = questionnaireRepositorie;
    }


    /**
     * @param type
     * @param question
     * @return
     */
    @Override
    public Question CreerUneQuestion(String type, Question question) {
        return questionRepositorie.save(question);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Question AfficherQuestion(Long id) {
        return questionRepositorie.findById(id).get();
    }

    /**
     * @param id
     */
    @Override
    public void SupprimerQuestion(Long id) {
        questionRepositorie.deleteById(id);

    }


    public List<Question> getQuestionsByQuestionnaireId(Long questionnaireId) {
        return questionRepositorie.getQuestionsByQuestionnaireId(questionnaireId);
    }
}
