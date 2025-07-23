package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Enteties.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
	
}
