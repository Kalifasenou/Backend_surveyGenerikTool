package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Presentation;

import java.util.List;

public interface PresentationService {


    Presentation CreerPresentation(Presentation presentation);


    Presentation AfficherPresentation(Integer id);


    List<Presentation> AfficherAllPresentation();

    Presentation SupprimerPresentation(Integer id, Presentation presentation);


    Presentation PartagerPresentation();


}
