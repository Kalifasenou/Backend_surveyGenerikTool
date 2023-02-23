package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.QuestionService;
import com.malicollecte.Services.QuestionnaireService;
import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.models.User;
import com.malicollecte.repository.EnqueteRepositorie;
import com.malicollecte.repository.QuestionRepositorie;
import com.malicollecte.repository.QuestionnaireRepositorie;
import com.malicollecte.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireServiceImpl  implements QuestionnaireService {

    @Autowired
    private QuestionRepositorie questionRepositorie;

    @Autowired
    private EnqueteRepositorie enqueteRepositorie;

    @Autowired
    private QuestionnaireRepositorie questionnaireRepositorie;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionService questionService;


    public QuestionnaireServiceImpl(QuestionRepositorie questionRepositorie, QuestionnaireRepositorie questionnaireRepositorie) {
        this.questionRepositorie = questionRepositorie;
        this.questionnaireRepositorie = questionnaireRepositorie;
    }

    @Override
    public List<Questionnaire> ToutAfficher() {
        return questionnaireRepositorie.findAll();
    }

    @Override
    public Questionnaire AfficherUn(Long id) {
        return questionnaireRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Questionnaire not found with id " + id));
    }

    /**
     * @param questionnaire
     * @return
     */
    @Override
    public Questionnaire ajouter(Questionnaire questionnaire) {
        if(questionnaireRepositorie.findByLibellequestionnaire(questionnaire.getLibellequestionnaire())==null) {
           // questionnaire.setEnquete(questionnaire.getEnquete());
            questionnaire.setLibellequestionnaire(questionnaire.getLibellequestionnaire());
           return questionnaireRepositorie.save(questionnaire);
        }else{
            return null;

        }
    }



    /**
     * @param questionnaire
     * @return
     */
    @Override
    public Questionnaire Creer(Long id, Questionnaire questionnaire) {
        enqueteRepositorie.findById(id).get().setId(questionnaire.getId());
        return questionnaireRepositorie.save(questionnaire);
    }

    /**
     * @param id
     * @param questionnaire
     * @return
     */
    @Override
    public Questionnaire Modifier(Long id, Questionnaire questionnaire) {
        return questionnaireRepositorie.findById(id).map(questionnaire1 -> {
            questionnaire1.setQuestions(questionnaire.getQuestions());
            return questionnaireRepositorie.save(questionnaire1);
        }).orElseThrow(() -> new RuntimeException("Ne peut pas modifiée ce questionnaire" + id));
    }

    //public List<Questionnaire> getQuestionnairesByStatus(String status) {
      //  return questionnaireRepositorie.findByStatus(status); }


    public String AjouterQuestion(Long id, Question question) {
        Questionnaire questionnaire = questionnaireRepositorie.findById(id).orElse(null);
        if(questionnaire == null) {
            throw new IllegalArgumentException("Aucun questionnaire trouver avec l'id : " + id);
        } else {
        question.setQuestionnaire(questionnaire);
        //questionService.CreerUneQuestion(question.getIntitule(), question);
        questionRepositorie.save(question);
        questionnaire.setQuestions(questionnaire.getQuestions());
        questionnaireRepositorie.save(questionnaire);
        }
        return "Question ajouté";
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String SupprimerQuestion(Long id) {
        Questionnaire questionnaire = questionnaireRepositorie.findById(id).orElse(null);
        if(questionnaire == null) {
            throw new IllegalArgumentException("Aucun questionnaire trouver avec l'id : " + id);
        } else {
            questionRepositorie.deleteById(id);

questionnaireRepositorie.save(questionnaire);
        }

return "Question supprimé";
    }

    /**
     * @param
     * @return
     */
    @Override
    public List<Question> AfficherTouteQuestion() {
        return questionRepositorie.findAll();
    }

    @Override
    public String AjouterRepondant(Long id, List<Long> idUsers) {
        Questionnaire questionnaire = questionnaireRepositorie.findById(id).orElse(null);
        if(questionnaire == null) {
            throw new IllegalArgumentException("Il n'existe pas de questionnaire avec un id: " + id);
        }
        List<User> users = userRepository.findAllById(idUsers);
        if(users.size() != idUsers.size()) {
            throw new IllegalArgumentException("Aucun utilisateur trouvé");
        }
       // questionnaire.setUsers(users);
        questionnaireRepositorie.save(questionnaire);

        return "Repondant ajouté avec succés !";
    }



    public void addQuestionsToQuestionnaire(Long questionnaireId, List<Question> questions) {
        Optional<Questionnaire> optionalQuestionnaire = questionnaireRepositorie.findById(questionnaireId);
        if (optionalQuestionnaire.isPresent()) {
            Questionnaire questionnaire = optionalQuestionnaire.get();
            List<Question> questionList = questionnaire.getQuestions();
            questionList.addAll(questions);
            questionnaire.setQuestions(questionList);
            questionnaireRepositorie.save(questionnaire);
        } else {
            throw new EntityNotFoundException("Questionnaire not found with ID: " + questionnaireId);
        }
    }
}
