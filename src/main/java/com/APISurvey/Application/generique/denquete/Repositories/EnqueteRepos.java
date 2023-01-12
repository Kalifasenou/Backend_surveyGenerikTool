package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnqueteRepos extends JpaRepository<Enquete, Long>{

}
