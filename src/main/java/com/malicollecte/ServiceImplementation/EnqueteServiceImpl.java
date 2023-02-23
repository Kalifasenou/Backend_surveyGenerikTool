package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.EnqueteService;
import com.malicollecte.models.Enquete;
import com.malicollecte.models.User;
import com.malicollecte.repository.EnqueteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EnqueteServiceImpl implements EnqueteService {


    @Autowired
    private EnqueteRepositorie enqueteRepositorie;


    /**
     * @param enquete
     * @return
     */
    @Override
    public Enquete Creer(Enquete enquete) {
        Enquete enquete1 = new  Enquete();
        enquete1.setEtat(enquete.getEtat());
        enquete1.setType(enquete.getType());
        enquete1.setImages(enquete.getImages());
        enquete1.setLibelle(enquete.getLibelle());
        enquete1.setDescription(enquete.getDescription());
        enquete1.setDatedebut(enquete.getDatedebut());
        enquete1.setDatefin(enquete.getDatefin());
       // enquete1.setQuestionnaire(enquete.getQuestionnaire());
        enquete1.setUtilisateur(enquete.getUtilisateur());
        return enqueteRepositorie.save(enquete1);

    }

    /**
     * @param id
     * @return
     */
    @Override
    public Enquete AfficherUn(Long id) {
        return enqueteRepositorie.findById(id).get();
    }

    /**
     * @param id
     * @param enquete
     * @return
     */
    @Override
    public Enquete Modifier(Long id, Enquete enquete) {
        return enqueteRepositorie.findById(id).map(enquete1 -> {
            enquete1.setLibelle(enquete.getLibelle());
            enquete1.setDescription(enquete.getDescription());
            enquete1.setDatedebut(enquete.getDatedebut());
            enquete1.setDatefin(enquete.getDatefin());

            return enqueteRepositorie.save(enquete1);
        }).orElseThrow(() -> new RuntimeException("impossible de modifier"));
    }

    /**
     * @return
     */
    @Override
    public List<Enquete> ToutAfficher() {
        return enqueteRepositorie.findAll();
    }

/*
    */
/**
     * @param statut
     * @param organisation
     * @return
     *//*

    @Override
    public List<Enquete> AfficherparStatutEtOrga(String statut, String organisation) {
        return enqueteRepositorie.findByStatutAndOrganisation(statut, organisation);
    }
*/



  /*  *//**
     * @param organisation
     * @return
     *//*
    @Override
    public List<Enquete> AfficherparOrganisation(String organisation) {
        return enqueteRepositorie.findByOrganisation(organisation);
    }*/

    /**
     * @param statut
     * @return
     */
    @Override
    public List<Enquete> AfficherparStatut(String statut) {
        return enqueteRepositorie.findByStatut(statut);
    }

    /* /**
     * @param createur
     * @return

    @Override
    public List<User> AfficherparCreateur(String createur) {
        return enqueteRepositorie.findByUser(createur);
    }*/

    /**
     * @param id
     */
    @Override
    public void Supprimer(Long id) {
        enqueteRepositorie.findById(id).map(enquete1 -> {
            enquete1.setEtat(true);

            return enqueteRepositorie.save(enquete1);
        }).orElseThrow(() -> new RuntimeException("impossible de supprimer"));
    }

    /**
     * @param type
     * @return
     */
    @Override
    public List<Enquete> AfficherparType(String type) {
        return enqueteRepositorie.findByType(type);
    }
}
