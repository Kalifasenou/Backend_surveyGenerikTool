package com.malicollecte.repository;

import com.malicollecte.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepositorie extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.questionnaire.id = :questionnaireId")
    List<Question> getQuestionsByQuestionnaireId(@Param("questionnaireId") Long questionnaireId);
}
