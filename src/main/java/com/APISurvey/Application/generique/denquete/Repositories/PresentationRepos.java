package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepos extends JpaRepository<Presentation, Integer> {

}
