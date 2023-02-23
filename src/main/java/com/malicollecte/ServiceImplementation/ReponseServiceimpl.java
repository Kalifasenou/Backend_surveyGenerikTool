package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.ReponseService;
import com.malicollecte.models.Reponse;
import com.malicollecte.repository.ReponseRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseServiceimpl implements ReponseService {

    @Autowired
    private ReponseRepositorie reponseRepositorie;

    // @Override
//    public List<Reponse> AfficherTouteslesReponsesparQuestionnaires(Questionnaire questionnaire) {
//        return reponseRepositorie.findAllByQuestionnaire(questionnaire);
//    }


    // @Override
    //public List<Reponse> AfficherTouteslesReponsesParUtilisateurs(Long id) {return reponseRepositorie.findAllByUser(id);}

//    @Override
//    public Reponse getReponseByQuestionAndUser(Question question, User user) {
//        return reponseRepositorie.findByQuestionAndUser(question, user);
//    }
//
//    @Override
//    public List<Reponse> getUnansweredQuestionsByUserAndQuestionnaire(User user, Questionnaire questionnaire) {
//        return reponseRepositorie.findAllByUserAndQuestionnaireAndReponseIsNull(user, questionnaire);
//    }

    //    /**
//     * @param questionnaire
//     * @return
//     */
//    @Override
//    public List<Reponse> AfficherTouteslesReponsesparQuestionnaires(Questionnaire questionnaire) {
//        return null;
//    }
//
//    /**
//     * @param question
//     * @param user
//     * @return
//     */
//    @Override
//    public Reponse getReponseByQuestionAndUser(Question question, User user) {
//        return null;
//    }
//
//    /**
//     * @param user
//     * @param questionnaire
//     * @return
//     */
//    @Override
//    public List<Reponse> getUnansweredQuestionsByUserAndQuestionnaire(User user, Questionnaire questionnaire) {
//        return null;
//    }
//
    @Override
    public Reponse AjouterReponse(Reponse reponse) {
        reponseRepositorie.save(reponse);
        return reponse;
    }

    //    /**
//     * @param id
//     */
    @Override
    public Reponse AfficherReponses(Long id) {
        return reponseRepositorie.findById(id).get();
    }

    //
    @Override
    public Reponse ModifierReponse(Long id, Reponse reponse) {
        reponseRepositorie.findById(id).map(reponse1 -> {
            reponse1.setType(reponse.getType());
            reponse1.setMessage(reponse.getMessage());

            return reponseRepositorie.save(reponse1);
        }).orElseThrow(() -> new RuntimeException("Ne peut pas modifier cette reponse"));
        return reponse;
    }

    //
    @Override
    public void SupprimerReponse(Long id) {
        reponseRepositorie.deleteById(id);
    }
//
//    /**
//     * @param user
//     * @param questionnaire
//     * @param question
//     * @param questionnaire1001
//     * @param question1
//     * @return
//     */
//    @Override
//    public List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question, Questionnaire questionnaire1001, Question question1) {
//        return null;
//    }

//    @Override
//    public List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question, Questionnaire questionnaire1001, Question question1) {
//        return reponseRepositorie.findByUserAndQuestionnaireAndQuestionAndQuestionnaireAndQuestion( user, questionnaire, question, questionnaire1001, question1);
//    }


    public Reponse saveReponse(Reponse reponse) {
        return reponseRepositorie.save(reponse);
    }

//        public List<Reponse> findByQuestionAndQuestionnaire(Question question, Questionnaire questionnaire) {
//            return reponseRepositorie.findByQuestionAndQuestionnaire(question, questionnaire);
//        }

    //   public List<Reponse> findByUser(User user) {
    //        return reponseRepositorie.findByUser(user);
    //      }
//
//        public List<Reponse> findByQuestionnaire(Questionnaire questionnaire) {
//            return reponseRepositorie.findByQuestionnaire(questionnaire);
//        }
//
//        public List<Reponse> findByUserAndQuestionnaire(User user, Questionnaire questionnaire) {
//            return reponseRepositorie.findByUserAndQuestionnaire(user, questionnaire);
//        }
//
//        public List<Reponse> findByUserAndQuestion(User user, Question question) {
//            return reponseRepositorie.findByUserAndQuestion(user, question);
//        }
//
//        public List<Reponse> findByUserAndQuestionAndQuestionnaire(User user, Question question, Questionnaire questionnaire) {
//            return reponseRepositorie.findByUserAndQuestionAndQuestionnaire(user, question, questionnaire);
//        }
//
//        public List<Reponse> findByUserAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question) {
//            return reponseRepositorie.findByUserAndQuestionnaireAndQuestion(user, questionnaire, question);
//        }
//
//        public List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaire(User user, Questionnaire questionnaires, Question question, Questionnaire questionnaire) {
//            return reponseRepositorie.findByUserAndQuestionnaireAndQuestionAndQuestionnaire(user, questionnaires, question, questionnaire);
//        }
//
//        public List<Reponse> findByUserAndQuestionAndQuestionnaireAndQuestionnaire(User user, Question question, Questionnaire questionnaire, Questionnaire questionnaire1001) {
//            return reponseRepositorie.findByUserAndQuestionAndQuestionnaireAndQuestionnaire(user, question, questionnaire, questionnaire1001);
//        }
//
//
//        public List<Reponse> findAllByQuestionnaire(Questionnaire questionnaire) {
//            return reponseRepositorie.findAllByQuestionnaire(questionnaire);
//        }


}
