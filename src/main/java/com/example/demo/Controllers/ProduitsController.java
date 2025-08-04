package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Enteties.Produit;
import com.example.demo.Services.ProduitService;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;


@RestController
@RequestMapping("/api/produits")
@CrossOrigin("*")
public class ProduitsController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produit> getById(@PathVariable Long id) {
        return produitService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Produit add(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        produitService.delete(id);
    }
}

