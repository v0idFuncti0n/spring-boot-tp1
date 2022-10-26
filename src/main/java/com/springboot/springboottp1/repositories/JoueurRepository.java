package com.springboot.springboottp1.repositories;

import com.springboot.springboottp1.entities.Equipe;
import com.springboot.springboottp1.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByPosteAndEquipe(String poste, Equipe equipe);
}
