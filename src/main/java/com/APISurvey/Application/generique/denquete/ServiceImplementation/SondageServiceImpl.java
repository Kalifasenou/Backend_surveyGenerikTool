package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Question;
import com.APISurvey.Application.generique.denquete.Modeles.Sondage;
import com.APISurvey.Application.generique.denquete.Repositories.SondageRepos;
import com.APISurvey.Application.generique.denquete.Services.SondageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SondageServiceImpl implements SondageService {


    @Autowired
    SondageRepos sondageRepos;

    /**
     * @param sondage
     * @return
     */
    @Override
    public Sondage CreerSondage(Sondage sondage) {
        return sondageRepos.save(sondage);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Sondage AfficherSondage(Integer id) {
        return sondageRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Sondage> AfficherAllSondage() {
        return sondageRepos.findAll();
    }

    /**
     * @param id
     * @param sondage
     * @return
     */
    @Override
    public Sondage ModifierSondage(Integer id, Sondage sondage) {
        return sondageRepos.findById(id).map(sondage1 -> {
            sondage1.setLibelle(sondage1.getLibelle());
            sondage1.setDatedebut(sondage1.getDatedebut());
            sondage1.setDatefin(sondage1.getDatefin());
            sondage1.setQuestion((Question) sondage1.getQuestion());
            sondage1.setUser(sondage1.getUser());
            return sondageRepos.save(sondage1);
        }).orElseThrow(() -> new RuntimeException("Impossible de modifier ce sondage !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Sondage SupprimerSondage(Integer id) {
        return sondageRepos.findById(id).map(sondage -> {
            sondage.setEtatsondage(true);
            return sondageRepos.save(sondage);
        }).orElseThrow(() -> new RuntimeException("Impossible de supprimer ce sondage !"));
    }

    /**
     * @return
     */
    @Override
    public Sondage LancerSondage() {
        return null;
    }


/*    @Override
    public void addOption(Integer questionId, MultiValueOption option) {
        Sondage sondage = sondageRepos.findById(questionId).get();
        Question question = sondage.getQuestions().get(questionId);
        question.addOption(option);
        sondageRepos.save(sondage);
    }*/

}
