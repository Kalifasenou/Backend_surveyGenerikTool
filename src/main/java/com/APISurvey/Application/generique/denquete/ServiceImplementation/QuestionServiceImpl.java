package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Question;
import com.APISurvey.Application.generique.denquete.Repositories.QuestionRepos;
import com.APISurvey.Application.generique.denquete.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionRepos questionRepos ;



    /**
     * @param question
     * @return
     */
    @Override
    public Question CreerQuestion(Question question) {
        return questionRepos.save(question);
    }

    /**
     * @param id
     * @param question
     * @return
     */
    @Override
    public Question ModifierQuestion(Integer id, Question question) {
        return questionRepos.findById(id).map(question1 -> {
            question1.setLibelle(question1.getLibelle());

            return questionRepos.save(question1);

        }).orElseThrow(()-> new RuntimeException("Impossible de modifier cette question !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String SupprimerQuestion(Integer id) {
        questionRepos.deleteById(id);
        return "Question supprimé avec succés !";
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Question AfficherQuestion(Integer id) {
        return questionRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Question> AfficherAllQuestion() {
        return questionRepos.findAll();
    }
}
