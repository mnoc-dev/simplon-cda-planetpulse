package co.simplon.planet_pulse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_countries")
public class Countries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "iso_code")
	private String isoCode;
	
	@Column(name = "country_name")
	private String country;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getAreaKm() {
		return areaKm;
	}

	public void setAreaKm(Double areaKm) {
		this.areaKm = areaKm;
	}

	public Long getIdSubregion() {
		return idSubregion;
	}

	public void setIdSubregion(Long idSubregion) {
		this.idSubregion = idSubregion;
	}

	@Column(name = "url_flag")
	private Integer population;
	
	@Column(name = "area_km")
	private Double areaKm;
	
	@Column(name = "id_subregion")
	private Long idSubregion;
}
