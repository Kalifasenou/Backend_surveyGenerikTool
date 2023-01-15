package com.APISurvey.Application.generique.denquete.ServiceImplementation;

import com.APISurvey.Application.generique.denquete.Modeles.Role;
import com.APISurvey.Application.generique.denquete.Repositories.RoleRepository;
import com.APISurvey.Application.generique.denquete.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleRepository roleRepository;

    /**
     * @param role
     * @return
     */
    @Override
    public Role CreerRole(Role role) {
        return roleRepository.save(role);
    }


    /**
     * @param id
     * @param role
     * @return
     */
    @Override
    public Role ModifierRole(Long id, Role role) {
        return roleRepository.findById(id).map(role1 -> {
            role1.setName(role1.getName());
            return roleRepository.save(role1);
        }).orElseThrow(() -> new RuntimeException("Rôle non trouver"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public String SupprimerRole(Long id) {
        return roleRepository.findById(id).map(role -> {
            //role.setEtatrole(true);
            return "Rôle supprimer avec succés !";
        }).orElseThrow(() -> new RuntimeException("Rôle introuvable"));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Role AfficherRole(Long id) {
        return roleRepository.findById(id).get();
    }

    /**
     * @return
     */
    @Override
    public List<Role> AfficherAllRole() {
        return roleRepository.findAll();
    }
}
