package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Reponse;
import com.APISurvey.Application.generique.denquete.Repositories.ReponseRepos;
import com.APISurvey.Application.generique.denquete.Services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReponseServiceImpl implements ReponseService {

    @Autowired
     ReponseRepos reponseRepos;


    /**
     * @param reponse
     * @return
     */
    @Override
    public Reponse CreerReponse(Reponse reponse) {
        return reponseRepos.save(reponse);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Reponse AfficherReponse(Integer id) {
        return reponseRepos.findById(id).get();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Reponse SupprimerReponse(Integer id) {
        return reponseRepos.findById(id).map(reponse -> {
            reponse.setEtatreponse(true);
            return reponseRepos.save(reponse);
        }).orElseThrow(() -> new RuntimeException("Impossible de supprimer cette reponse !"));
    }

    /**
     * @param id
     * @param reponse
     * @return
     */
    @Override
    public Reponse ModifierReponse(Integer id, Reponse reponse) {
        return reponseRepos.findById(id).map( reponse1 -> {
            reponse1.setLibelle(reponse1.getLibelle());
            reponse1.setTypesdonnee(reponse1.getTypesdonnee());
            return reponseRepos.save(reponse1);
        }).orElseThrow(()-> new RuntimeException("Reponse introuvable"));
    }

    /**
     * @return
     */
    @Override
    public List<Reponse> AfficherAllReponse() {
        return reponseRepos.findAll();
    }
}
