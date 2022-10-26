package com.springboot.springboottp1.controllers;

import com.springboot.springboottp1.entities.Equipe;
import com.springboot.springboottp1.entities.Joueur;
import com.springboot.springboottp1.services.EquipeService;
import com.springboot.springboottp1.services.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/joueur")
public class JoueurController {

    private final JoueurService joueurService;
    private final EquipeService equipeService;
    
    @Autowired
    public JoueurController(JoueurService joueurService, EquipeService equipeService) {
        this.joueurService = joueurService;
        this.equipeService = equipeService;
    }

    @GetMapping
    public List<Joueur> getJoueurs() {
        return new ArrayList<>(joueurService.findAll());
    }

    @GetMapping(path = "/{id}")
    public Joueur getJoueurById(@PathVariable Long id) {
        return joueurService.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Joueur joueurCreate(@RequestBody Joueur joueur) {
        return joueurService.save(joueur);
    }

    @DeleteMapping(path = "/{id}")
    public void joueurDelete(@PathVariable Long id) {
        joueurService.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Joueur joueurUpdate(@PathVariable Long id, @RequestBody Joueur joueur) {
        return joueurService.update(id, joueur);
    }
}
