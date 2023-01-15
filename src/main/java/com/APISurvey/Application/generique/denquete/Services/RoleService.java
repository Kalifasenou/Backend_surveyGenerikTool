package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Role;

import java.util.List;

public interface RoleService {



    Role CreerRole(Role role) ;


    Role ModifierRole(Long id, Role role);


    String SupprimerRole(Long id) ;

    Role AfficherRole(Long id);



    List<Role> AfficherAllRole();

}
