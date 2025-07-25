package com.example.demo.Enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Services {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String nomSerice;
}
