DROP TABLE IF EXISTS t_targets;

CREATE TABLE t_targets(
country_iso_code CHAR(2),
target_year INT,
co2_emissions DECIMAL(20,3) CHECK(co2_emissions > 0.0),
forest_area DECIMAL(20,3) CHECK(forest_area > 0.0),
particulate_matter DECIMAL(20,3) CHECK(particulate_matter > 0.0),
renewable_energy_share DECIMAL(20,3) CHECK(renewable_energy_share > 0.0),
PRIMARY KEY(target_year, country_iso_code),
FOREIGN KEY(country_iso_code) REFERENCES t_countries(iso_code)
);
