package co.simplon.planet_pulse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Map countries to the t_countries table.
@Entity
@Table(name = "t_countries")
public class Country {

    // Unique country ID.
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "iso_code")
    private String isoCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "url_flag")
    private String urlFlag;

    // Required by JPA to create country objects.
    protected Country() {
    }

    public Integer getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getUrlFlag() {
        return urlFlag;
    }
}
