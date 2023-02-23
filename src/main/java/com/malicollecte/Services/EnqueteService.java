package com.malicollecte.Services;

import com.malicollecte.models.Enquete;
import com.malicollecte.models.User;

import java.util.List;


public interface EnqueteService {

        Enquete Creer(Enquete enquete);

        Enquete AfficherUn(Long id) ;

        Enquete Modifier(Long id, Enquete enquete) ;

        List<Enquete> ToutAfficher();


    //    List<Enquete> AfficherparStatutEtOrga(String statut, String organisation);

      //  List<Enquete> AfficherparOrganisation(String Organisation);

        List<Enquete> AfficherparStatut(String statut);

      //  List<User> AfficherparCreateur(String createur);

        void Supprimer(Long id);

        List<Enquete> AfficherparType(String type);
    }


