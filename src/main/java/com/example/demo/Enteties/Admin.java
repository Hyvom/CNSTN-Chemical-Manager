package com.example.demo.Enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Admin {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String adresse;
}
