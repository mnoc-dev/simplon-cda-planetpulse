DROP TABLE IF EXISTS t_regions CASCADE;
DROP TABLE IF EXISTS t_subregions CASCADE;
DROP TABLE IF EXISTS t_countries CASCADE;

CREATE TABLE t_regions(
   region VARCHAR(20),
   PRIMARY KEY(region)
);

CREATE TABLE t_subregions(
   subregion VARCHAR(30),
   region VARCHAR(20) NOT NULL,
   PRIMARY KEY(subregion),
   FOREIGN KEY(region) REFERENCES t_regions(region)
);

CREATE TABLE t_countries(
   iso_code CHAR(2),
   country_name VARCHAR(50) NOT NULL,
   population INT NOT NULL,
   url_flag VARCHAR(50) NOT NULL,
   area_km INT NOT NULL,
   subregion VARCHAR(30) NOT NULL,
   PRIMARY KEY(iso_code),
   FOREIGN KEY(subregion) REFERENCES t_subregions(subregion)
);
