package com.APISurvey.Application.generique.denquete.Modeles;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    //private boolean etatrole = false;

    @ManyToMany
    @JoinColumn(name = "utilisateur_id")
    private List<User> user = new ArrayList<>();


}
