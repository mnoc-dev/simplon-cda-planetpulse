package co.simplon.planet_pulse.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_targets")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_year")
    private Integer year;

    @Column(name = "co2_emissions")
    private Double co2Emissions;

    @Column(name = "forest_area")
    private Double forestArea;

    @Column(name = "pm25_exposure")
    private Double pm25Exposure;

    @Column(name = "renewable_energy_share")
    private Double renewableEnergyShare;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
