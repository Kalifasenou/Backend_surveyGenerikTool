package com.malicollecte.repository;

import com.malicollecte.models.Enquete;
import com.malicollecte.models.Questionnaire;
import com.malicollecte.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnqueteRepositorie extends JpaRepository<Enquete, Long> {

Enquete findByLibelle(String libelle);
    List<Enquete> findByType(String type);
   // List<Enquete> findByOrganisation(String organisation);
    List<Enquete> findByStatut(String statut);

    //List<Enquete> findByStatutAndOrganisation(String statut, String organisation);

//    List<Enquete> findByEtatAndStatut(Boolean etat, String stat);

    //List<User> findByUser(String user);

}
