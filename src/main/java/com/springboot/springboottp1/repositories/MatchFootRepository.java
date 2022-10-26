package com.springboot.springboottp1.repositories;

import com.springboot.springboottp1.entities.MatchFoot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MatchFootRepository extends JpaRepository<MatchFoot, Long> {

    public List<MatchFoot> findByDateMatch(LocalDate localDate);

    public List<MatchFoot> findByDateMatchBefore(LocalDate localDate);

}

