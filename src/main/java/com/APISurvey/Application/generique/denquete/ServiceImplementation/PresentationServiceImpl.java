package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Presentation;
import com.APISurvey.Application.generique.denquete.Repositories.PresentationRepos;
import com.APISurvey.Application.generique.denquete.Services.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationServiceImpl implements PresentationService {


    @Autowired
    PresentationRepos presentationRepos;




    /**
     * @param presentation
     * @return
     */
    @Override
    public Presentation CreerPresentation(Presentation presentation) {
        return presentationRepos.save(presentation);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Presentation AfficherPresentation(Integer id) {
        return presentationRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Presentation> AfficherAllPresentation() {
        return presentationRepos.findAll();
    }

    /**
     * @param id
     * @param presentation
     * @return
     */
    @Override
    public Presentation SupprimerPresentation(Integer id, Presentation presentation) {
        return presentationRepos.findById(id).map(presentation1 -> {
            presentation1.setEtatpresentation(true);
            return presentationRepos.save(presentation1);
        }).orElseThrow(()-> new RuntimeException("Impossible de supprimer cette presentation"));
    }

    /**
     * @return
     */
    @Override
    public Presentation PartagerPresentation() {
        return null;
    }
}
