package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaireRepos extends JpaRepository<Formulaire, Integer> {

    List<Formulaire> findByEnquete(Enquete enquete);

}
