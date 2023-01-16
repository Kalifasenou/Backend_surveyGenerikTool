package com.APISurvey.Application.generique.denquete.Services;


import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EnqueteService {

    Enquete CreerEnquete(Enquete enquete);

    Enquete ModifierEnquete(Long id, Enquete enquete);


    String SupprimerEnquete(Long id, Enquete enquete);


    Enquete AfficherUneEnquete(Long id);

    List<Enquete> AfficherTousEnquete();


    Enquete EnregisterEnquete();


    String MarquerCommeTermine();


    Enquete ImporterEnquete(MultipartFile file) throws CsvValidationException, IOException;


    Enquete ExporterEnquete();

    Formulaire CreerFormulaire(Long enqueteId, Formulaire formulaire);


    Formulaire ModifierFormulaire(Integer id, Formulaire formulaire);

    String SupprimerFormulaire(Integer id);

    Formulaire AfficherUnFormulaire(Integer formulaireId);

    List<Formulaire> AfficherTousFormulaires(Long enqueteId);

    List<Formulaire> AfficherTousFormulairesByEnquete(Long id);
}
