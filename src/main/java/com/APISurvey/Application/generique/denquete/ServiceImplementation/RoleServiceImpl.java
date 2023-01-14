package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Role;
import com.APISurvey.Application.generique.denquete.Repositories.RoleRepos;
import com.APISurvey.Application.generique.denquete.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleRepos roleRepos;

    /**
     * @param role
     * @return
     */
    @Override
    public Role CreerRole(Role role) {
        return roleRepos.save(role);
    }

    /**
     * @param id
     * @param role
     * @return
     */
    @Override
    public Role ModifierRole(Integer id, Role role) {
        return roleRepos.findById(id).map(role1 -> {
            role1.setLibelle(role1.getLibelle());
            return roleRepos.save(role1);
        }).orElseThrow(() -> new RuntimeException("Rôle non trouver"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String SupprimerRole(Integer id) {
        return roleRepos.findById(id).map(role -> {
            role.setEtatrole(true);
            return "Rôle supprimer avec succés !";
        }).orElseThrow(() -> new RuntimeException("Rôle introuvable"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Role AfficherRole(Integer id) {
        return roleRepos.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Role> AfficherAllRole() {
        return roleRepos.findAll();
    }
}
