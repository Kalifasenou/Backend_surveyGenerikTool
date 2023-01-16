package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Modeles.Formulaire;
import com.APISurvey.Application.generique.denquete.Repositories.EnqueteRepos;
import com.APISurvey.Application.generique.denquete.Repositories.FormulaireRepos;
import com.APISurvey.Application.generique.denquete.Services.EnqueteService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;


import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class EnqueteServiceImpl implements EnqueteService {

    @Autowired
    final private EnqueteRepos enqueteRepos;

    @Autowired
    private FormulaireRepos formulairesRepos;

@Autowired
    public EnqueteServiceImpl(EnqueteRepos enqueteRepos, FormulaireRepos formulairesRepos) {
        this.enqueteRepos = enqueteRepos;
        this.formulairesRepos= formulairesRepos;
    }


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
            enquete1.setLibelle(enquete1.getLibelle());
            enquete1.setDatedebut(enquete1.getDatedebut());
            enquete1.setDatefin(enquete1.getDatefin());
            enquete1.setStatut(enquete1.getStatut());
            enquete1.setFormulaires(enquete1.getFormulaires());
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

    @Scheduled(fixedRate = 86400000)
    @Override
    public String MarquerCommeTermine() {
        LocalDate datedujour = LocalDate.now();
        List<Enquete> ConsidererTerminer = new ArrayList<>();
        ConsidererTerminer = AfficherTousEnquete();
        for (Enquete eq: ConsidererTerminer){
            long ecart = ChronoUnit.DAYS.between(eq.getDatefin(),datedujour);
            if (ecart == 0) {
                eq.setStatut("Terminer");
                ModifierEnquete(eq.getId(), eq);
            }
        }
        return "Enquête terminer avec succés";
    }

    /**
     * @return
     */
    @Override
    public Enquete ImporterEnquete(MultipartFile file) throws CsvValidationException, IOException {
        // Initialize a new Enquete object
        Enquete importedEnquete = new Enquete();

        // Create a new CSVReader with the desired file path
        CSVReader reader = new CSVReader(new FileReader("path/to/file.csv"));

        // Read the CSV file's header
        String[] header = reader.readNext();

        // Read the data for the first survey in the CSV file
        String[] surveyData = reader.readNext();

        // Set importedEnquete's properties using data from the imported source
        importedEnquete.setLibelle(surveyData[0]);
        importedEnquete.setDatedebut(String.valueOf(LocalDate.parse(surveyData[1])));
        importedEnquete.setDatefin(LocalDate.parse(surveyData[2]));
        importedEnquete.setStatut(surveyData[3]);

        // Close the reader
        reader.close();

        // Save the importedEnquete to the database and return it
        return CreerEnquete(importedEnquete);
    }

    private Scanner sc;

    public EnqueteServiceImpl(EnqueteRepos enqueteRepos) {
        this.enqueteRepos = enqueteRepos;
        this.sc = new Scanner(System.in);
    }


    /**
     * @return
     */
    @Override
    public Enquete ExporterEnquete() {
        // Initialize a new Enquete object
        Enquete newEnquete = new Enquete();

        // Get the survey's title
        System.out.println("Enter survey's title:");
        String libelle = sc.nextLine();

        // Get the survey's start date
        System.out.println("Enter survey's start date (yyyy-MM-dd):");
        LocalDate datedebut = LocalDate.parse(sc.nextLine());

        // Get the survey's end date
        System.out.println("Enter survey's end date (yyyy-MM-dd):");
        LocalDate datefin = LocalDate.parse(sc.nextLine());

        // Set newEnquete's properties
        newEnquete.setLibelle(libelle);
        newEnquete.setDatedebut(String.valueOf(datedebut));
        newEnquete.setDatefin(datefin);
        newEnquete.setStatut("En cours");

        // Save the newEnquete to the database and return it
        return CreerEnquete(newEnquete);
    }



    @Override
    public Formulaire CreerFormulaire(Long enqueteId, Formulaire formulaire) {
        Enquete enquete = enqueteRepos.findById(enqueteId).get();
        formulaire.setEnquete(enquete);
        return formulairesRepos.save(formulaire);
    }

    @Override
    public Formulaire ModifierFormulaire(Integer id, Formulaire formulaire) {
        return formulairesRepos.findById(id).map(form -> {
            form.setLibelle(formulaire.getLibelle());
            form.setQuestions(formulaire.getQuestions());
            return formulairesRepos.save(form);
        }).orElseThrow(() -> new RuntimeException("Formulaire non trouvé"));
    }

    @Override
    public String SupprimerFormulaire(Integer id) {
        formulairesRepos.deleteById(id);
        return "Formulaire supprimé avec succés";
    }

    @Override
    public Formulaire AfficherUnFormulaire(Integer formulaireId) {
        return formulairesRepos.findById(formulaireId).get();
    }

    @Override
    public List<Formulaire> AfficherTousFormulaires(Long enqueteId) {
        Enquete enquete = enqueteRepos.findById(enqueteId).get();
        return formulairesRepos.findByEnquete(enquete);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Formulaire> AfficherTousFormulairesByEnquete(Long id) {
        return formulairesRepos.findByEnquete(enqueteRepos.findById(id).get());
    }

}
