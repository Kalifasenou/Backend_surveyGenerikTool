package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Modeles.Question;
import com.APISurvey.Application.generique.denquete.Modeles.Typedonnee;

import java.util.List;

public interface FormulaireService {

    Formulaire CreerForm(Formulaire formulaire);


    Formulaire ModifierForm(Integer id, Formulaire formulaire);


    Formulaire SupprimerForm(Integer id);


    Formulaire AfficherForm(Integer id);

    List<Formulaire> AfficherAllForm();

    Formulaire ajouterQuestion(Integer idFormulaire, Question question);



    Question ModifierQuestion(Integer questionId, Question question, Typedonnee type);

    void SupprimerQuestion(Integer questionId);

    Question AfficherQuestion(Integer questionId);
}
