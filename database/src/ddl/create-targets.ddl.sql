DROP TABLE IF EXISTS t_targets;

CREATE TABLE t_targets(
                          id INTEGER GENERATED ALWAYS AS IDENTITY,
                          target_year INT NOT NULL,
                          co2_emissions DECIMAL(12, 2) CHECK(co2_emissions >= 0.1),
                          forest_area DECIMAL(5, 2) CHECK(forest_area >= 0.1 AND forest_area <=100),
                          pm25_exposure DECIMAL(5, 2) CHECK(pm25_exposure >= 0.1),
                          renewable_energy_share DECIMAL(5, 2) CHECK(renewable_energy_share >= 0.1 AND renewable_energy_share <=100),
                          id_country INT NOT NULL,
                          CONSTRAINT t_targets_pk PRIMARY KEY(id_country),
                          CONSTRAINT t_targets_id_country_fk FOREIGN KEY(id_country) REFERENCES t_countries(id),
                          CONSTRAINT t_targets_target_year_id_country UNIQUE(target_year, id_country)
);
