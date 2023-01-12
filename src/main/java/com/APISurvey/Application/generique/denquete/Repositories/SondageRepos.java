package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondageRepos extends JpaRepository<Sondage, Integer> {
}
