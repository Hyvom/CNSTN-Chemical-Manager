package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Enteties.*;
import com.example.demo.Services.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired private AdminService adminService;
    @Autowired private UserService userService;
    @Autowired private ProduitService produitService;
    @Autowired private DemandeService demandeService;

    // Admin login 
    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Map<String, String> creds) {
        String email = creds.get("email");
        String motDePasse = creds.get("motDePasse");

        return adminService.getByEmail(email)
                .filter(admin -> admin.getMotDePasse().equals(motDePasse))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    // List all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    // List all produits
    @GetMapping("/produits")
    public List<Produit> getAllProduits() {
        return produitService.getAll();
    }

    // List all demandes
    @GetMapping("/demandes")
    public List<Demande> getAllDemandes() {
        return demandeService.getAll();
    }

    // Update product status
    @PutMapping("/produits/{id}/status")
    public ResponseEntity<Produit> updateProduitStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String newStatus = body.get("status");

        return produitService.getById(id).map(produit -> {
            produit.setUnite(newStatus); 
            return ResponseEntity.ok(produitService.save(produit));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a produit
    @DeleteMapping("/produits/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.delete(id);
    }
}
