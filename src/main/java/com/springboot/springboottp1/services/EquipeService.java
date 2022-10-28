package com.springboot.springboottp1.services;

import com.springboot.springboottp1.entities.Equipe;
import com.springboot.springboottp1.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    @Autowired
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }
    public List<Equipe> findAll() {
        return new ArrayList<>(equipeRepository.findAll());
    }

    public Equipe findById(Long id) {
        return equipeRepository.findById(id).orElseThrow((() -> new RuntimeException("joueur not found")));
    }

    public Equipe save(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deleteById(Long id) {
        equipeRepository.deleteById(id);
    }

    public Equipe update(Long id, Equipe equipe) {
        equipe.setId(id);
        return equipeRepository.save(equipe);
    }

    public List<Equipe> findByPays(String pays) {
        return equipeRepository.findByPays(pays);
    }

    public Equipe findByNom(String nom) {
        return equipeRepository.findByNom(nom);
    }

}
