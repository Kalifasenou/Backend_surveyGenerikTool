package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;

import java.util.List;

public interface FormulaireService {

    Formulaire CreerForm(Formulaire formulaire);


    Formulaire ModifierForm(Integer id, Formulaire formulaire);


    Formulaire SupprimerForm(Integer id);


    Formulaire AfficherForm(Integer id);

    List<Formulaire> AfficherAllForm();
}
