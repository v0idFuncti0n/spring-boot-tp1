package com.springboot.springboottp1.services;

import com.springboot.springboottp1.entities.MatchFoot;
import com.springboot.springboottp1.repositories.MatchFootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchFootService {

    private final MatchFootRepository matchFootRepository;

    @Autowired
    public MatchFootService(MatchFootRepository matchFootRepository) {
        this.matchFootRepository = matchFootRepository;
    }

    public List<MatchFoot> findAll() {
        return matchFootRepository.findAll();
    }

    public MatchFoot findById(Long id) {
        return matchFootRepository.findById(id).orElseThrow(() -> new RuntimeException("match not found"));
    }

    public MatchFoot save(MatchFoot matchFoot) {
        return matchFootRepository.save(matchFoot);
    }

    public void deleteById(Long id) {
        matchFootRepository.deleteById(id);
    }

    public List<MatchFoot> findByDateMatch(LocalDate localDate) {
        return matchFootRepository.findByDateMatch(localDate);
    }

    public List<MatchFoot> findByDateMatchBefore(LocalDate localDate) {
        return matchFootRepository.findByDateMatchBefore(localDate);
    }

}
