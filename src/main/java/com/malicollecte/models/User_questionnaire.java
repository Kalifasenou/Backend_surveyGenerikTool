package com.malicollecte.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_questionnaire")
@Data
public class User_questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire_id;

    @Enumerated(EnumType.STRING)
    private EStatusEnquete status;
}
