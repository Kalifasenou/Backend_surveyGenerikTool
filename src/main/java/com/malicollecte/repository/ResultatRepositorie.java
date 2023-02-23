package com.malicollecte.repository;

import com.malicollecte.models.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatRepositorie extends JpaRepository<Resultat, Long> {
}
