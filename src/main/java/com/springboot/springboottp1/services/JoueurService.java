package com.springboot.springboottp1.services;

import com.springboot.springboottp1.entities.Equipe;
import com.springboot.springboottp1.entities.Joueur;
import com.springboot.springboottp1.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public Joueur findById(Long id) {
        return joueurRepository.findById(id).orElseThrow(() -> new RuntimeException("joueur not found"));
    }

    public List<Joueur> findAll() {
        return joueurRepository.findAll();
    }

    public Joueur save(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public Joueur update(Long id, Joueur joueur) {
        joueur.setId(id);
        return joueurRepository.save(joueur);
    }

    public void deleteById(Long id) {
        joueurRepository.deleteById(id);
    }

    public List<Joueur> findByPosteAndEquipe(String poste, Equipe equipe) {
        return joueurRepository.findByPosteAndEquipe(poste, equipe);
    }
}
