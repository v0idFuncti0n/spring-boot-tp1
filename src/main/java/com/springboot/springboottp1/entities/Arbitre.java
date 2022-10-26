package com.springboot.springboottp1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "arbitre")
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String nom;

    @Column(length = 80, nullable = false)
    private String nationalite;

    @OneToMany(mappedBy = "arbitre")
    @JsonIgnore
    private List<MatchFoot> matches;
}
