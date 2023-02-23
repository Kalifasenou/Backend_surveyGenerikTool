package com.malicollecte.ServiceImplementation;

import com.malicollecte.Services.UtilisateurServices;
import com.malicollecte.models.User;
import com.malicollecte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UtilisateurServiceImpl implements UtilisateurServices {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User AfficherUnUtilisateut(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        } else {
            System.out.println("Aucun Utilisateur trouvé avec cette adresse mail " + email);
            return null;
        }
    }

    @Override
    public List<User> AfficherToutUtilisateur() {
        return userRepository.findAll();
    }

    @Override
    public String ModifierUtilisateur(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setNumero(user.getNumero());
            userToUpdate.setLocalite(user.getLocalite());
            userToUpdate.setOrganisation(user.getOrganisation());
             userRepository.save(userToUpdate);
             return "votre profil " + user + "a été modifier avec succés !";
        } else {
            return  "Impossible de modifie cet utilisateur" + user ;
        }
    }

    @Override
    public String SupprimerUtilisateur(Long id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete!= null) {
            userRepository.delete(userToDelete);
            return "Utilisateur supprimé avec succès";
        } else {
            return "Utilisateur introuvable";
    }
    }

/*    @Override
    public String AjouterUtilisateur(User user) {
        if (userRepository.findByEmail(user.getEmail())!= null) {
            return "Adresse mail deja utilisé!";
        } else {
            userRepository.save(user);
            return "Utilisateur ajouté avec succès";
        }

    }*/



//Methode de modification de mot de passe
    @Override
    public String ModifierMotDePasse(Long id, String password) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setPassword(password);
            userRepository.save(userToUpdate);
            return "Mot de passe modifié avec succès";
        } else {
            return "Utilisateur introuvable";
        }
    }

    @Override
    public String ModifierRole(Long id, Set role) {
        User role1 = userRepository.findById(id).orElseThrow(null);
        if (role1 != null) {
            role1.setRoles(role);
            userRepository.save(role1);
            return "Role changé avec succés !";
        }
        return "Utilisateur introuvable !";
    }

    //Methode de modication d'adresse mail
    @Override
    public String ModifierEmail(Long id, String email) {
            User user = userRepository.findById(id).orElse(null);
            if (user == null) {
                return "Utilisateur introuvable";
            }

            // verification de l'existence du mail
            if (userRepository.findByEmail(email) != null) {
                return "Adresse mail deja utilisé !";
            }

            user.setEmail(email);
            userRepository.save(user);
            return "Votre adresse mail a été modifié avec succés";
        }

    public String ModifierOrganisation(Long id, String organisation) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "Utilisateur introuvable";
        } else {
            user.setOrganisation(organisation);
            userRepository.save(user);
            return "Organisation modifiée avec succès";
        }
    }


    public String ModifierAddress(Long id, String address) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "Utilisateur introuvable";
        } else {
            user.setLocalite(address);
            userRepository.save(user);
            return "Adresse modifiée avec succès";
        }
    }


    public String ModifierPhone(Long id, String phone) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "Utilisateur introuvable";
        } else {
            user.setNumero(phone);
            userRepository.save(user);
            return "Numéro de téléphone modifié avec succès";
        }
    }



/*
    public String ModifierInformationUtilisateur(Long id, String champ, String nouvelleValeur) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "Utilisateur introuvable";
        }
        switch (champ) {
            case "email":
                user.setEmail(nouvelleValeur);
                break;
            case "phone":
                user.setNumero(nouvelleValeur);
                break;
            case "address":
                user.setLocalite(nouvelleValeur);
                break;
            case "organization":
                user.setOrganisation(nouvelleValeur);
                break;
            default:
                return "Champ non valide";
        }
        userRepository.save(user);
        return "Modification réussie";
    }
*/


}
