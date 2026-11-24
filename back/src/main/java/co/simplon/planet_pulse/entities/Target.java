package co.simplon.planet_pulse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    @JsonBackReference
    private Country country;

    public Target() {
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Double getCo2Emissions() {
        return co2Emissions;
    }

    public Double getForestArea() {
        return forestArea;
    }

    public Double getPm25Exposure() {
        return pm25Exposure;
    }

    public Double getRenewableEnergyShare() {
        return renewableEnergyShare;
    }

    public Country getCountry() {
        return country;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setCo2Emissions(Double co2Emissions) {
        this.co2Emissions = co2Emissions;
    }

    public void setForestArea(Double forestArea) {
        this.forestArea = forestArea;
    }

    public void setPm25Exposure(Double pm25Exposure) {
        this.pm25Exposure = pm25Exposure;
    }

    public void setRenewableEnergyShare(Double renewableEnergyShare) {
        this.renewableEnergyShare = renewableEnergyShare;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
