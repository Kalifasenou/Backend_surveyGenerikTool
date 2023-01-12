package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaireRepos extends JpaRepository<Formulaire, Integer> {

}
