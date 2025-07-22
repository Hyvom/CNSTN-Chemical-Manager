package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Enteties.Produit;
import com.example.demo.Repositories.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}
