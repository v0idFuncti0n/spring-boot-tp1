package com.springboot.springboottp1.controllers;

import com.springboot.springboottp1.entities.Equipe;
import com.springboot.springboottp1.entities.MatchFoot;
import com.springboot.springboottp1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchFootController {
    private final MatchFootService matchFootService;

    private EquipeService equipeService;

    private JoueurService joueurService;

    private ArbitreService arbitreService;

    private StadeService stadeService;

    @Autowired
    public MatchFootController(MatchFootService matchFootService, EquipeService equipeService, JoueurService joueurService, ArbitreService arbitreService, StadeService stadeService) {
        this.matchFootService = matchFootService;
        this.equipeService = equipeService;
        this.joueurService = joueurService;
        this.arbitreService = arbitreService;
        this.stadeService = stadeService;
    }

    @GetMapping
    public List<MatchFoot> getMatches() {
        return matchFootService.findAll();
    }

    @GetMapping(path = "/{id}")
    public MatchFoot getMatchById(@PathVariable Long id) {
        return matchFootService.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MatchFoot matchFootCreate(@RequestBody MatchFoot matchFoot) {
        return matchFootService.save(matchFoot);
    }

    @PostMapping(path = "/{arbitre_id}/arbitre/{stade_id}/stade/{equipe1_id}/equipe/{equipe2_id}/equipe")
    public MatchFoot matchFootCreate(@PathVariable Long arbitre_id,
                                     @PathVariable Long stade_id,
                                     @PathVariable Long equipe1_id,
                                     @PathVariable Long equipe2_id,
                                     @RequestBody MatchFoot matchFoot) {
        matchFoot.setArbitre(arbitreService.findById(arbitre_id).orElse(null));
        matchFoot.setStade(stadeService.findById(stade_id).orElse(null));
        List<Equipe> match = new ArrayList<>();
        Equipe equipe1 = equipeService.findById(equipe1_id);
        Equipe equipe2 = equipeService.findById(equipe2_id);
        match.add(equipe1);
        match.add(equipe2);
        matchFoot.setEquipes(match);

        return matchFootService.save(matchFoot);
    }

    @PutMapping(path = "/{match_id}/match/{arbitre_id}/arbitre/{stade_id}/stade/{equipe1_id}/equipe/{equipe2_id}/equipe")
    public MatchFoot matchFootUpdate(@PathVariable Long match_id,
                                     @PathVariable Long arbitre_id,
                                     @PathVariable Long stade_id,
                                     @PathVariable Long equipe1_id,
                                     @PathVariable Long equipe2_id,
                                     @RequestBody MatchFoot matchFootBody
    ) {
        MatchFoot matchFoot = matchFootService.findById(match_id);
        matchFoot.setDateMatch(matchFootBody.getDateMatch());
        matchFoot.setHeureMatch(matchFootBody.getHeureMatch());
        matchFoot.setArbitre(arbitreService.findById(arbitre_id).orElse(null));
        matchFoot.setStade(stadeService.findById(stade_id).orElse(null));
        List<Equipe> match = new ArrayList<>();
        Equipe equipe1 = equipeService.findById(equipe1_id);
        Equipe equipe2 = equipeService.findById(equipe2_id);
        match.add(equipe1);
        match.add(equipe2);
        matchFoot.setEquipes(match);

        return matchFootService.save(matchFoot);
    }

    @DeleteMapping(path = "/{id}")
    public void matchFootDelete(@PathVariable Long id) {
        matchFootService.deleteById(id);
    }

}
