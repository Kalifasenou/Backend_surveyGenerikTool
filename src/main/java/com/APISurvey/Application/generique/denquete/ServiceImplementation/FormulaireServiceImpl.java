package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Repositories.FormulaireRepos;
import com.APISurvey.Application.generique.denquete.Services.FormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulaireServiceImpl implements FormulaireService {

@Autowired
    final private FormulaireRepos formulaireRepos;

    public FormulaireServiceImpl(FormulaireRepos formulaireRepos) {
        this.formulaireRepos = formulaireRepos;
    }


    /**
     * @param formulaire
     * @return
     */
    @Override
    public Formulaire CreerForm(Formulaire formulaire) {
        return formulaireRepos.save(formulaire);
    }

    /**
     * @param Id
     * @param formulaire
     * @return
     */
    @Override
    public Formulaire ModifierForm(Integer Id, Formulaire formulaire) {
        return formulaireRepos.findById(Id).map(formulaire1 -> {
            formulaire1.setLibelle(formulaire1.getLibelle());
            formulaire1.setQuestions(formulaire1.getQuestions());
            return formulaireRepos.save(formulaire1);
        }).orElseThrow(() -> new RuntimeException("Formulaire non existant"));
    }



    /**
     * @param id
     * @return
     */
    @Override
    public Formulaire SupprimerForm(Integer id) {
        return formulaireRepos.findById(id).map(formulaire -> {
            formulaire.setEtatformulaire(true);
            return formulaireRepos.save(formulaire);
        }).orElseThrow(() -> new RuntimeException("Impossible de supprimer ce formulaire"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Formulaire AfficherForm(Integer id) {
        return formulaireRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Formulaire> AfficherAllForm() {
        return formulaireRepos.findAll();
    }
}
