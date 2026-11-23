package co.simplon.planet_pulse.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iso_code")
    private String isoCode;

    @OneToMany(mappedBy = "country")
    private List<Target> targets;
}
