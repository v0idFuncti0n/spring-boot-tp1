package com.springboot.springboottp1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String pays;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
    private List<Joueur> joueurs;

    @JsonIgnore
    @ManyToMany(mappedBy= "equipes", cascade = CascadeType.ALL)
    private List<MatchFoot> matches;

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
