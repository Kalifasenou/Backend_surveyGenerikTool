package com.APISurvey.Application.generique.denquete.Services;


import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnqueteService {



    Enquete CreerEnquete(Enquete enquete);

    Enquete ModifierEnquete(Long id, Enquete enquete);


    Enquete SupprimerEnquete(Integer id, Enquete enquete);


    String AfficherUneEnquete(Long id);

    List<Enquete> AfficherTousEnquete();


    Enquete EnregisterEnquete();


    Enquete MarquerCommeTermine();


    Enquete ImporterEnquete();


    Enquete ExporterEnquete();

}
