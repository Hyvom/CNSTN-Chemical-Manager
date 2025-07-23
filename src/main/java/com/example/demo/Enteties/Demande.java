package com.example.demo.Enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomDemandeur;
    private String serviceDemandeur;   
    private String etat;               
    private int quantite;
    private LocalDate dateDemande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
