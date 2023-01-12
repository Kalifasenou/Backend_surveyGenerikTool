package com.APISurvey.Application.generique.denquete.Services;

import com.APISurvey.Application.generique.denquete.Modeles.Role;

import java.util.List;

public interface RoleService {



    Role CreerRole(Role role) ;


    Role ModifierRole(Integer id, Role role);


    Role SupprimerRole(Integer id) ;

    Role AfficherRole(Integer id);


    List<Role> AfficherRole();

}
