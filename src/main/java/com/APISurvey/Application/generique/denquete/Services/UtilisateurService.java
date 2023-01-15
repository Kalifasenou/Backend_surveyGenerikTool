package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.User;

import java.util.List;

public interface UtilisateurService {


    User CreerUtilisateur(User user);


    User ModifierUtilisateur(Integer id, User user);


    User SupprimerUtilisateur(Integer id);


    User AfficherUtilisateur(Integer id);


    List<User> AfficherAllUtilisateur();

    String ModifierMotdepasse(Integer id);

}
