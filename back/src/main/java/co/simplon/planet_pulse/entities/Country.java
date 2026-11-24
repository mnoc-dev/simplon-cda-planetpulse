package co.simplon.planet_pulse.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Target> targets;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }
}
