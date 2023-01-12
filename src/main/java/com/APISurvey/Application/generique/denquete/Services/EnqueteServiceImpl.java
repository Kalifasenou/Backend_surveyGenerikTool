package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Modeles.Question;
import com.APISurvey.Application.generique.denquete.Modeles.Utilisateur;
import com.APISurvey.Application.generique.denquete.Repositories.EnqueteRepos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EnqueteServiceImpl implements EnqueteService{

    @Autowired
    public EnqueteRepos enqueteRepos;



    /**
     * @param enquete
     * @return
     */
    @Override
    public Enquete CreerEnquete(Enquete enquete) {
        return enqueteRepos.save(enquete);
    }

    /**
     * @param id
     * @param enquete
     * @return
     */
    @Override
    public Enquete ModifierEnquete(Long id, Enquete enquete) {
        return enqueteRepos.findById(id).map(enquete1 -> {
            //enquete1.setLibelle;
            enquete1.setFormulaire((Formulaire) enquete1.getFormulaire());
            enquete1.setQuestion((Question) enquete1.getQuestion());
            enquete1.setUtilisateur((Utilisateur) enquete1.getUtilisateur());
            enquete1.setResultat(enquete1.getResultat());

            return enqueteRepos.save(enquete1);

        }).orElseThrow(() -> new RuntimeException("Enquête non trouvé"));
    }

    /**
     * @param id
     * @param enquete
     * @return
     */
    @Override
    public String SupprimerEnquete(Long id, Enquete enquete) {
        enqueteRepos.deleteById(id);
        return "Enquête supprimée avec succés";
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Enquete AfficherUneEnquete(Long id) {
        return enqueteRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Enquete> AfficherTousEnquete() {
        return enqueteRepos.findAll();
    }

    /**
     * @return
     */
    @Override
    public Enquete EnregisterEnquete() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Enquete MarquerCommeTermine() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Enquete ImporterEnquete() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Enquete ExporterEnquete() {
        return null;
    }
}
