package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Resultat;

import java.util.List;

public interface ResultatService {


    Resultat CreerResultat(Resultat resultat);


    Resultat AfficherResultat(Integer id);


    List<Resultat> AfficherResultat();

    Resultat ModifierResultat(Integer integer, Resultat resultat);


    Resultat SupprimerResultat(Integer id);


    Resultat PublierResultat();


}
