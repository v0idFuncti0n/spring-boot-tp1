package com.springboot.springboottp1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "match_foot")
public class MatchFoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateMatch;

    @Column(columnDefinition = "TIME", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime heureMatch;

    @ManyToOne
    @JoinColumn(name = "arbitre_id")
    private Arbitre arbitre;

    @ManyToOne
    @JoinColumn(name = "stade_id")
    private Stade stade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "match_equipe", joinColumns = {@JoinColumn(name = "match_foot_id")}, inverseJoinColumns = {@JoinColumn(name = "equipe_id")})
    private List<Equipe> equipes;

    @Override
    public String toString() {
        return "MatchFoot{" +
                "id=" + id +
                ", dateMatch=" + dateMatch +
                ", heureMatch=" + heureMatch +
                '}';
    }
}
