package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Enteties.Demande;
import com.example.demo.Enteties.User;
import com.example.demo.Enteties.Produit;
import com.example.demo.Services.DemandeService;
import com.example.demo.Services.ProduitService;
import com.example.demo.Services.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@CrossOrigin("*")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Demande> getAll() {
        return demandeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getById(@PathVariable Long id) {
        return demandeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user/{userId}/produit/{produitId}")
    public ResponseEntity<Demande> createDemande(
            @PathVariable Long userId,
            @PathVariable Long produitId,
            @RequestBody Demande demandeRequest) {

        User user = userService.getById(userId).orElse(null);
        Produit produit = produitService.getById(produitId).orElse(null);

        if (user == null || produit == null) {
            return ResponseEntity.badRequest().build();
        }

        demandeRequest.setUser(user);
        demandeRequest.setProduit(produit);
        demandeRequest.setEtat("en attente");
        demandeRequest.setDateDemande(LocalDate.now());

        Demande created = demandeService.save(demandeRequest);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        demandeService.delete(id);
    }
}
