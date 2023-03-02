package com.malicollecte.repository;

import com.malicollecte.models.Enquete;
import com.malicollecte.models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionnaireRepositorie extends JpaRepository<Questionnaire, Long> {
    //List<Questionnaire> findByStatus(String status);
    Questionnaire findByLibellequestionnaire(String libellequestionnaire);
    Optional<Questionnaire> findFirstByEnqueteId(Long enqueteId);
    Questionnaire findByEnquete(Enquete enquete);

    @Query(value = "select * from questionnaire where enquete_id = :enquete_id", nativeQuery = true)
    Questionnaire recupererQuestionnaire(@Param(value = "enquete_id") Long enquete_id);
}
