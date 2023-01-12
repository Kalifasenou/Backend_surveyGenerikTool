package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepos extends JpaRepository<Reponse, Integer> {

}
