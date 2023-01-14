package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Resultat;

import java.util.List;

public interface ResultatService {


    Resultat CreerResultat(Resultat resultat);


    Resultat AfficherResultat(Integer id);


    List<Resultat> AfficherAllResultat();

    //Resultat ModifierResultat(Integer integer, Resultat resultat);


    void SupprimerResultat(Integer id);


    Resultat PublierResultat();


}
