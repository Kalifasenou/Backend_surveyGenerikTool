package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Enquete;
import com.APISurvey.Application.generique.denquete.Repositories.EnqueteRepos;
import com.APISurvey.Application.generique.denquete.Services.EnqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class EnqueteServiceImpl implements EnqueteService {

    @Autowired
    final private EnqueteRepos enqueteRepos;

@Autowired
    public EnqueteServiceImpl(EnqueteRepos enqueteRepos) {
        this.enqueteRepos = enqueteRepos;
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
