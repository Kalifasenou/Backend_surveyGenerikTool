package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Sondage;

import java.util.List;

public interface SondageService {


    Sondage CreerSondage(Sondage sondage);


    Sondage AfficherSondage(Integer id);
    List<Sondage> AfficherAllSondage();
    Sondage ModifierSondage(Integer id, Sondage sondage);


    Sondage SupprimerSondage(Integer id);


    Sondage LancerSondage() ;

}
