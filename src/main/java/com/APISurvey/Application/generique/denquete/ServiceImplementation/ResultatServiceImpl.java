package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Resultat;
import com.APISurvey.Application.generique.denquete.Repositories.ResultatRepos;
import com.APISurvey.Application.generique.denquete.Services.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatServiceImpl implements ResultatService {

    @Autowired
    ResultatRepos resultatRepos;


    /**
     * @param resultat
     * @return
     */
    @Override
    public Resultat CreerResultat(Resultat resultat) {
        return resultatRepos.save(resultat);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Resultat AfficherResultat(Integer id) {
        return resultatRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Resultat> AfficherAllResultat() {
        return resultatRepos.findAll();
    }

    /**
     * @param id
     * @param resultat
     * @return
     */
//    @Override
//    public Resultat ModifierResultat(Integer id, Resultat resultat) {
//        return resultatRepos.findById(id).map(resultat1 -> {
//            resultat1.set
//        });
//    }

    /**
     * @param id
     * @return
     */
    @Override
    public void SupprimerResultat(Integer id) {
        //resultatRepos.deleteById(id);
        resultatRepos.findById(id).map(resultat -> {
            resultat.setEtatresultat(true);
            return resultatRepos.save(resultat);
        }).orElseThrow(() -> new RuntimeException("Impossible de supprimer ce rôle !"));
    }

    /**
     * @return
     */
    @Override
    public Resultat PublierResultat() {
        return null;
    }
}
