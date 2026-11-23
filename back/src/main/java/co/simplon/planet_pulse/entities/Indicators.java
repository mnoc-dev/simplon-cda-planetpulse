package co.simplon.planet_pulse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_indicators")

public class Indicators {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column()
	private int indicatorYear;
	private double forestAreaIndicator;
	private double co2Emission;
	private double pM25Exposure;
	private double renewableEnergyShare;
	private int idCountry;
	
	public Long getId() {
		return id;
	}
	
	

}
