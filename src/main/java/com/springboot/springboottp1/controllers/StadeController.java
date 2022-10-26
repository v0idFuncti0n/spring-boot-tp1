package com.springboot.springboottp1.controllers;

import com.springboot.springboottp1.entities.MatchFoot;
import com.springboot.springboottp1.entities.Stade;
import com.springboot.springboottp1.services.MatchFootService;
import com.springboot.springboottp1.services.StadeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stade")
public class StadeController {

    private final StadeService stadeService;

    public StadeController(StadeService stadeService) {
        this.stadeService = stadeService;
    }

    @GetMapping
    public List<Stade> getMatches() {
        return stadeService.findAll();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Stade stadeCreate(@RequestBody Stade stade) {
        return stadeService.save(stade);
    }

    @PutMapping(path = "/{id}")
    public Stade stadeUpdate(@PathVariable Long id, @RequestBody Stade stade) {
        return stadeService.update(id, stade);
    }

    @DeleteMapping(path = "/{id}")
    public void stadeDelete(@PathVariable Long id) {
        stadeService.deleteById(id);
    }
}
