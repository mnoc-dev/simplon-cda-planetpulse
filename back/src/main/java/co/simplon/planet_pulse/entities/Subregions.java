package co.simplon.planet_pulse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_subregions")
public class Subregions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "subregion")
	private String subregion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_region", nullable = false)
	private Regions regions;
	
	public Regions getRegion() {
		return regions;
	}

	public void setRegion(Regions regions) {
		this.regions = regions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String sub) {
		this.subregion = sub;
	}





}
