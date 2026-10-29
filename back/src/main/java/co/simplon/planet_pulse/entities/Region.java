package co.simplon.planet_pulse.entities;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_regions")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "region")
	private String region;
	
	@OneToMany(mappedBy = "region")
	private Set<Subregion> subregions;
	
	
	public Set<Subregion> getSubregions() {
		return subregions;
	}

	public void setSubregions(Set<Subregion> subregions) {
		this.subregions = subregions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
}
