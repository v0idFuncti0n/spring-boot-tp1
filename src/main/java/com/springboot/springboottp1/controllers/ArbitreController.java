package com.springboot.springboottp1.controllers;

import com.springboot.springboottp1.entities.Arbitre;
import com.springboot.springboottp1.services.ArbitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/arbitre")
public class ArbitreController {

    private final ArbitreService arbitreService;

    @Autowired
    public ArbitreController(ArbitreService arbitreService) {
        this.arbitreService = arbitreService;
    }

    @GetMapping
    public List<Arbitre> getArbitres() {
        return new ArrayList<>(arbitreService.findAll());
    }

    @GetMapping(path = "/{id}")
    public Arbitre getArbitreById(@PathVariable Long id) {
        return arbitreService.findById(id).orElseThrow((() -> new RuntimeException("arbitre not found")));
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Arbitre arbitreCreate(@RequestBody Arbitre arbitre) {
        return arbitreService.save(arbitre);
    }

    @DeleteMapping(path = "/{id}")
    public void arbitreDelete(@PathVariable Long id) {
        arbitreService.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Arbitre arbitreUpdate(@PathVariable Long id, @RequestBody Arbitre arbitre) {
        return arbitreService.update(id, arbitre);
    }
}
