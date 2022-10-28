package com.springboot.springboottp1;

import com.springboot.springboottp1.entities.*;
import com.springboot.springboottp1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootTp1Application implements CommandLineRunner {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private JoueurService joueurService;

    @Autowired
    private ArbitreService arbitreService;

    @Autowired
    private MatchFootService matchFootService;

    @Autowired
    private StadeService stadeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // data bootstrap
        Equipe equipePSG = new Equipe();
        equipePSG.setNom("PSG");
        equipePSG.setPays("France");

        equipeService.save(equipePSG);

        Equipe equipeATL = new Equipe();
        equipeATL.setNom("ATL Madrid");
        equipeATL.setPays("Spain");

        equipeService.save(equipeATL);

        Equipe equipeWAC = new Equipe();
        equipeWAC.setNom("Wydad AC");
        equipeWAC.setPays("Maroc");

        equipeService.save(equipeWAC);

        Equipe equipeMT = new Equipe();
        equipeMT.setNom("Moghrib Tetouani");
        equipeMT.setPays("Maroc");

        equipeService.save(equipeMT);

        Equipe equipeROZ = new Equipe();
        equipeROZ.setNom("Rapid club oued zem");
        equipeROZ.setPays("Maroc");

        equipeService.save(equipeROZ);

        Arbitre arbitre = new Arbitre();
        arbitre.setNom("Ahmed laarbi");
        arbitre.setNationalite("Maroc");

        arbitreService.save(arbitre);

        Stade stade = new Stade();
        stade.setNomStade("Lampica");
        stade.setVille("Tetouan");

        stadeService.save(stade);

        MatchFoot matchFoot = new MatchFoot();
        matchFoot.setDateMatch(LocalDate.parse("2021-02-28"));
        matchFoot.setHeureMatch(LocalTime.parse("16:00"));
        matchFoot.setArbitre(arbitre);
        matchFoot.setStade(stade);
        List<Equipe> match = new ArrayList<>();
        match.add(equipePSG);
        match.add(equipeROZ);
        matchFoot.setEquipes(match);

        matchFootService.save(matchFoot);

        matchFoot = new MatchFoot();
        matchFoot.setDateMatch(LocalDate.parse("2021-02-28"));
        matchFoot.setHeureMatch(LocalTime.parse("18:00"));
        matchFoot.setArbitre(arbitre);
        matchFoot.setStade(stade);
        match = new ArrayList<>();
        match.add(equipeATL);
        match.add(equipeROZ);
        matchFoot.setEquipes(match);

        matchFootService.save(matchFoot);

        matchFoot = new MatchFoot();
        matchFoot.setDateMatch(LocalDate.parse("2021-03-01"));
        matchFoot.setHeureMatch(LocalTime.parse("20:00"));
        matchFoot.setArbitre(arbitre);
        matchFoot.setStade(stade);
        match = new ArrayList<>();
        match.add(equipeMT);
        match.add(equipeWAC);
        matchFoot.setEquipes(match);

        matchFootService.save(matchFoot);

        Joueur joueurMessi = new Joueur();
        joueurMessi.setNom("Messi");
        joueurMessi.setPoste("attaquant");
        joueurMessi.setEquipe(equipePSG);

        joueurService.save(joueurMessi);

        Joueur joueurNaymar = new Joueur();
        joueurNaymar.setNom("Naymar");
        joueurNaymar.setPoste("attaquant");
        joueurNaymar.setEquipe(equipePSG);

        joueurService.save(joueurNaymar);

        Joueur joueurHakimi = new Joueur();
        joueurHakimi.setNom("Hakimi");
        joueurHakimi.setPoste("defenseur");
        joueurHakimi.setEquipe(equipePSG);

        joueurService.save(joueurHakimi);

        Joueur joueurGrizman = new Joueur();
        joueurGrizman.setNom("Grizman");
        joueurGrizman.setPoste("attaquant");
        joueurGrizman.setEquipe(equipeATL);

        joueurService.save(joueurGrizman);

        // requests
        // -4

        List<Equipe> equipesMaroc = equipeService.findByPays("Maroc");
        System.out.println(equipesMaroc);

        // -5
        List<MatchFoot> matches = matchFootService.findByDateMatch(LocalDate.parse("2021-02-28"));
        System.out.println(matches);

        // -6
        Stade stade1 = matchFootService.findById(3L).getStade();
        System.out.println(stade1.getNomStade());

        // -7
        Equipe equipe = equipeService.findByNom("PSG");
        List<Joueur> joueurs = equipe.getJoueurs();
        System.out.println(joueurs);

        //-8
        MatchFoot matchFoot1 = matchFootService.findById(3L);
        List<Equipe> equipes = matchFoot1.getEquipes();
        System.out.println(equipes);

        //-9
        Equipe equipe1 = equipeService.findByNom("PSG");
        List<Joueur> joueurs1 = joueurService.findByPosteAndEquipe("attaquant", equipe1);
        System.out.println(joueurs1);

        //-10
//        List<MatchFoot> matchFoots = matchFootService.findByDateMatchBefore(LocalDate.now());
//        matchFoots.forEach((matchFound) -> {
//            matchFootService.deleteById(matchFound.getId());
//        });
        System.out.println(matchFootService.findAll());



    }

}
