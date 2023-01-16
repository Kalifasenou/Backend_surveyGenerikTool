package com.APISurvey.Application.generique.denquete.Controleurs;


import com.APISurvey.Application.generique.denquete.Modeles.Role;
import com.APISurvey.Application.generique.denquete.Services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleControleur {




        private RoleService roleService;


        @PostMapping("/ajouter")
        public Role CreerRole(@RequestBody Role role) {
            return roleService.CreerRole(role);
        }

        @PutMapping("/modifier/{id}")
        public Role ModifierRole(@PathVariable Long id, @RequestBody Role role) {
            return roleService.ModifierRole(id, role);
        }

        @DeleteMapping("supprimer/{id}")
        public boolean SupprimerRole(@PathVariable Long id) {
             roleService.SupprimerRole(id);
             return true;
        }

        @GetMapping("/{id}")
        public Role AfficherRole(@PathVariable Long id) {
            return roleService.AfficherRole(id);
        }

        @GetMapping
        public List<Role> AfficherAllRole() {
            return roleService.AfficherAllRole();
        }
    }

