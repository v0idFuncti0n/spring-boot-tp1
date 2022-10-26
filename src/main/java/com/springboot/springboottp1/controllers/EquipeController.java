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
@RequestMapping("/equipe")
public class EquipeController {

    private final EquipeService equipeService;
    private final JoueurService joueurService;

    @Autowired
    public EquipeController(EquipeService equipeService, JoueurService joueurService) {
        this.equipeService = equipeService;
        this.joueurService = joueurService;
    }

    @GetMapping
    public List<Equipe> getEquipes() {
        return new ArrayList<>(equipeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Equipe equipeCreate(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
    }

    @PostMapping(
            path = "/{equipeId}/joueur",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Joueur joueurCreate(@PathVariable Long equipeId, @RequestBody Joueur joueur) {
        Equipe equipe = equipeService.findById(equipeId);
        joueur.setEquipe(equipe);
        return joueurService.save(joueur);
    }

    @DeleteMapping(path = "/{id}")
    public void equipeDelete(@PathVariable Long id) {
        equipeService.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Equipe equipeUpdate(@PathVariable Long id, @RequestBody Equipe equipe) {
        return equipeService.update(id, equipe);
    }

}
