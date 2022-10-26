package com.springboot.springboottp1.services;

import com.springboot.springboottp1.entities.Stade;
import com.springboot.springboottp1.repositories.StadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadeService {

    private final StadeRepository stadeRepository;

    @Autowired
    public StadeService(StadeRepository stadeRepository) {
        this.stadeRepository = stadeRepository;
    }

    public List<Stade> findAll() {
        return stadeRepository.findAll();
    }

    public Optional<Stade> findById(Long id) {
        return stadeRepository.findById(id);
    }

    public Stade save(Stade stade) {
        return stadeRepository.save(stade);
    }

    public void deleteById(Long id) {
        stadeRepository.deleteById(id);
    }

    public Stade update(Long id, Stade stade) {
        stade.setId(id);
        return stadeRepository.save(stade);
    }
}
