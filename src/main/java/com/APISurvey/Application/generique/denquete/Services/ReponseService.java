package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Reponse;

import java.util.List;

public interface ReponseService {

    Reponse CreerReponse(Reponse reponse);


    Reponse AfficherReponse(Integer id);

    Reponse SupprimerReponse(Integer id);


    Reponse ModifierReponse(Integer id, Reponse reponse);


    List<Reponse> AfficherAllReponse();

}
