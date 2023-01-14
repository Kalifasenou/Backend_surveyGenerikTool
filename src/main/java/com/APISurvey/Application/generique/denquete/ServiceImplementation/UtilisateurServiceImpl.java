package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Utilisateur;
import com.APISurvey.Application.generique.denquete.Repositories.UtilisateurRepos;
import com.APISurvey.Application.generique.denquete.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepos utilisateurRepos;

    /**
     * @param utilisateur
     * @return
     */
    @Override
    public Utilisateur CreerUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepos.save(utilisateur);
    }

    /**
     * @param id
     * @param utilisateur
     * @return
     */
    @Override
    public Utilisateur ModifierUtilisateur(Integer id, Utilisateur utilisateur) {
        return utilisateurRepos.findById(id).map(utilisateur1 -> {
            utilisateur1.setNom(utilisateur1.getNom());
            utilisateur1.setPrenom(utilisateur1.getPrenom());
            utilisateur1.setMail(utilisateur1.getMail());
            utilisateur1.setPseudo(utilisateur1.getPseudo());
            return utilisateurRepos.save(utilisateur1);
        }).orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Utilisateur SupprimerUtilisateur(Integer id) {
        return utilisateurRepos.findById(id).map(utilisateur -> {
            utilisateur.setEtatuser(true);
            return utilisateurRepos.save(utilisateur);
        }).orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Utilisateur AfficherUtilisateur(Integer id) {
        return utilisateurRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Utilisateur> AfficherAllUtilisateur() {
        return utilisateurRepos.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String ModifierMotdepasse(Integer id) {
        return utilisateurRepos.findById(id).map(utilisateur -> {
            utilisateur.setMotdepasse(utilisateur.getMotdepasse());
            utilisateurRepos.save(utilisateur);
            return "Mot de passe modifier avec succés !";
        }).orElseThrow(() -> new RuntimeException("Impossible de modifier ce mot de passe !"));
    }
}
