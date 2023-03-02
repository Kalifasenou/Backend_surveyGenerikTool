package com.malicollecte.repository;

import com.malicollecte.models.EStatusEnquete;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.models.User;
import com.malicollecte.models.User_questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_questionnaireRepository extends JpaRepository<User_questionnaire, Long> {
    List<User_questionnaire> findByUseridAndStatus(User user_id, EStatusEnquete status);
}
