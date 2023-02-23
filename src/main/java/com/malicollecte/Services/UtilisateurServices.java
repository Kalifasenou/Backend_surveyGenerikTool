package com.malicollecte.Services;

import com.malicollecte.models.User;

import java.util.List;
import java.util.Set;

public interface UtilisateurServices {


    // Méthode pour afficher un utilisateur en fonction de son email
    public User AfficherUnUtilisateut(String email);

    // Méthode pour afficher tous les utilisateurs
    public List<User> AfficherToutUtilisateur();

    // Méthode pour modifier les informations d'un utilisateur
    public String ModifierUtilisateur(Long id, User user);

    // Méthode pour supprimer un utilisateur
    public String SupprimerUtilisateur(Long id);

    // Méthode pour modifier le mot de passe d'un utilisateur
    public String ModifierMotDePasse(Long id, String password);

    //Methodde de modification du role de l'utilisateur
    public String ModifierRole(Long id, Set role);

    // Méthode pour modifier l'email d'un utilisateur
    public String ModifierEmail(Long id, String email);

    // Méthode pour modifier le numéro de téléphone d'un utilisateur
    public String ModifierPhone(Long id, String phone);

    // Méthode pour modifier l'adresse d'un utilisateur
    public String ModifierAddress(Long id, String address);

    // Méthode pour modifier lOrgannisation de l'utilisateur
    public String ModifierOrganisation(Long id, String organisation);
}
