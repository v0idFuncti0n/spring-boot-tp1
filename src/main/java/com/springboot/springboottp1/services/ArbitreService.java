package com.springboot.springboottp1.services;

import com.springboot.springboottp1.entities.Arbitre;
import com.springboot.springboottp1.repositories.ArbitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitreService {

    private final ArbitreRepository arbitreRepository;

    @Autowired
    public ArbitreService(ArbitreRepository arbitreRepository) {
        this.arbitreRepository = arbitreRepository;
    }

    public Optional<Arbitre> findById(Long id) {
        return arbitreRepository.findById(id);
    }

    public List<Arbitre> findAll() {
        return arbitreRepository.findAll();
    }

    public Arbitre save(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    public Arbitre update(Long id, Arbitre arbitre) {
        arbitre.setId(id);
        return arbitreRepository.save(arbitre);
    }

    public void deleteById(Long id) {
        arbitreRepository.deleteById(id);
    }

}
