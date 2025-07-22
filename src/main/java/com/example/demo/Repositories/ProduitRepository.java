package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Enteties.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
}
