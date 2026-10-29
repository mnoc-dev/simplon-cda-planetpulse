package co.simplon.planet_pulse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "iso_code", unique = true, nullable = false)
	private String isoCode;
	
	@Column(name = "country_name", unique = true, nullable = false)
	private String country;
	
	@Column(name = "url_flag", unique = true, nullable = false)
	private String urlFlag;
	
	@Column(name = "area_km", nullable = false)
	private Double areaKm;
	
	@Column(name = "population", nullable = false)
	private Integer population;
	
	@Column(name = "id_subregion", unique = true, nullable = false)
	private Long idSubregion;
	
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

	
}
