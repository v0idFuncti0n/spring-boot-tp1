package com.springboot.springboottp1.repositories;

import com.springboot.springboottp1.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    public List<Equipe> findByPays(String pays);

    public Equipe findByNom(String nom);

}
