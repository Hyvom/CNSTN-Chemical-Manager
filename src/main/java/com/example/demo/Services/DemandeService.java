package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Enteties.Demande;
import com.example.demo.Repositories.DemandeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public List<Demande> getAll() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getById(Long id) {
        return demandeRepository.findById(id);
    }

    public Demande save(Demande demande) {
        return demandeRepository.save(demande);
    }

    public void delete(Long id) {
        demandeRepository.deleteById(id);
    }
}
