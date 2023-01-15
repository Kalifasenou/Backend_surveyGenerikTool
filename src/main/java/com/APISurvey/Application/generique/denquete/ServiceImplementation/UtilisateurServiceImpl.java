package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.User;
import com.APISurvey.Application.generique.denquete.Repositories.UserRepository;
import com.APISurvey.Application.generique.denquete.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UserRepository userRepository;

    /**
     * @param user
     * @return
     */
    @Override
    public User CreerUtilisateur(User user) {
        return userRepository.save(user);
    }

    /**
     * @param id
     * @param user
     * @return
     */
    @Override
    public User ModifierUtilisateur(Integer id, User user) {
        return userRepository.findById(id).map(utilisateur1 -> {
            utilisateur1.setNom(utilisateur1.getNom());
            utilisateur1.setPrenom(utilisateur1.getPrenom());
            utilisateur1.setEmail(utilisateur1.getEmail());
            //utilisateur1.setPseudo(utilisateur1.getPseudo());
            return userRepository.save(utilisateur1);
        }).orElseThrow(() -> new RuntimeException("User introuvable !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User SupprimerUtilisateur(Integer id) {
        return userRepository.findById(id).map(utilisateur -> {
            utilisateur.setEtatuser(true);
            return userRepository.save(utilisateur);
        }).orElseThrow(() -> new RuntimeException("User introuvable !"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User AfficherUtilisateur(Integer id) {
        return userRepository.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<User> AfficherAllUtilisateur() {
        return userRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String ModifierMotdepasse(Integer id) {
        return userRepository.findById(id).map(utilisateur -> {
            utilisateur.setPassword(utilisateur.getPassword());
            userRepository.save(utilisateur);
            return "Mot de passe modifier avec succés !";
        }).orElseThrow(() -> new RuntimeException("Impossible de modifier ce mot de passe !"));
    }
}
