package com.springboot.springboottp1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stade")
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomStade;

    private String ville;

    @OneToMany(mappedBy = "stade")
    @JsonIgnore
    private List<MatchFoot> matches;

}
