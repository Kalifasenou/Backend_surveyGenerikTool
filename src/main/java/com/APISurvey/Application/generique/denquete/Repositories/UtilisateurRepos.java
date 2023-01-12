package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepos extends JpaRepository<Utilisateur, Integer> {
}
