package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Utilisateur;

import java.util.List;

public interface UtilisateurService {


    Utilisateur CreerUtilisateur(Utilisateur utilisateur);


    Utilisateur ModifierUtilisateur(Integer id, Utilisateur utilisateur);


    Utilisateur SupprimerUtilisateur(Integer id);


    Utilisateur AfficherUtilisateur(Integer id);


    List<Utilisateur> AfficherAllUtilisateur();

    String ModifierMotdepasse(Integer id);

}
