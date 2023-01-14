package com.APISurvey.Application.generique.denquete.Services;


import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EnqueteService {

    Enquete CreerEnquete(Enquete enquete);

    Enquete ModifierEnquete(Long id, Enquete enquete);


    String SupprimerEnquete(Long id, Enquete enquete);


    Enquete AfficherUneEnquete(Long id);

    List<Enquete> AfficherTousEnquete();


    Enquete EnregisterEnquete();


    String MarquerCommeTermine();


    Enquete ImporterEnquete();


    Enquete ExporterEnquete();

}
