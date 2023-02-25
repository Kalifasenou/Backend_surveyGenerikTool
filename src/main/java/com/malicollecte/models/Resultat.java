package com.malicollecte.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // L'identifiant du résultat

    private String libelle; // Le libellé du résultat

    @OneToOne(mappedBy = "resultat")
    private Enquete enquete; // L'enquête à laquelle le résultat est associé

}
