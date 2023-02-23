package com.malicollecte.repository;

import com.malicollecte.models.Question;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.models.Reponse;
import com.malicollecte.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepositorie extends JpaRepository <Reponse, Long> {


    // Méthode pour afficher les réponses d'une question

    //List<Reponse> findByQuestion(Question question);



    // Méthode pour afficher les réponses d'une question en fonction du questionnaire

    //List<Reponse> findByQuestionAndQuestionnaire(Question question, Questionnaire questionnaire);

    // Méthode pour afficher les réponses d'un utilisateur précis
  //  List<Reponse> findByUser(User user);

    // Méthode pour afficher toutes les réponses d'un questionnaire
    //List<Reponse> findByQuestionnaire(Questionnaire questionnaire);

    // Méthode pour afficher toutes les réponses d'un util '
   // List<Reponse> findByUserAndQuestionnaire(User user, Questionnaire questionnaire);

    // Méthode pour afficher toutes les réponses d'un util'
    //List<Reponse> findByUserAndQuestion(User user, Question question);

    // Méthode pour afficher toutes les réponses d'un util'
    //List<Reponse> findByUserAndQuestionAndQuestionnaire(User user, Question question, Questionnaire questionnaire);

    // Méthode pour afficher toutes les réponses d'un util'
   // List<Reponse> findByUserAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question);

    // Méthode pour afficher toutes les réponses d'un util'
   // List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaire(User user, Questionnaire questionnaires, Question question, Questionnaire questionnaire);

    // Méthode pour afficher toutes les réponses d'un util'
   // List<Reponse> findByUserAndQuestionAndQuestionnaireAndQuestionnaire(User user, Question question, Questionnaire questionnaire, Questionnaire questionnaire1001);

    // Méthode pour afficher toutes les réponses d'un util'
   // List<Reponse> findByUserAndQuestionnaireAndQuestionAndQuestionnaireAndQuestion(User user, Questionnaire questionnaire, Question question, Questionnaire questionnaire1001, Question question1);

  //  List<Reponse> findAllByQuestionnaire(Questionnaire questionnaire);

    //List<Reponse> findAllByUser(User user);

   // Reponse findByQuestionAndUser(Question question, User user);

  //  List<Reponse> findAllByUserAndQuestionnaireAndReponseIsNull(User user, Questionnaire questionnaire);
}
