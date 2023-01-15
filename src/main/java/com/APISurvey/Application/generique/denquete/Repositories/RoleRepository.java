package com.APISurvey.Application.generique.denquete.Repositories;

import com.APISurvey.Application.generique.denquete.Modeles.ERole;
import com.APISurvey.Application.generique.denquete.Modeles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO role (name) VALUES('ROLE_USER'), ('ROLE_MODERATOR'), ('ROLE_ADMIN');", nativeQuery = true)
    void creerrole();


}
