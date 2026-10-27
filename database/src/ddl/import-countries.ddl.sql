CREATE TABLE t_regions(
	id integer GENERATED ALWAYS AS IDENTITY,
	region VARCHAR(20) NOT NULL,
	CONSTRAINT t_regions_pk PRIMARY KEY(id),
	CONSTRAINT t_regions_uk UNIQUE (region)
);

CREATE TABLE t_subregions(
	id integer GENERATED ALWAYS AS IDENTITY,
	subregion VARCHAR(30) NOT NULL,
	id_region integer NOT NULL,
	CONSTRAINT t_subregions_pk PRIMARY KEY(id),
	CONSTRAINT t_subregions_uk UNIQUE (subregion),
	CONSTRAINT t_subregions_id_region_fk FOREIGN KEY(id_region) REFERENCES t_regions(id)
);

CREATE TABLE t_countries(
	id integer GENERATED ALWAYS AS IDENTITY,
	iso_code CHAR(2) NOT NULL,
	country_name VARCHAR(50) NOT NULL,
	population INT NOT NULL,
	url_flag VARCHAR(50) NOT NULL,
	area_km DECIMAL(10,2) NOT NULL,
	id_subregion integer NOT NULL,
	CONSTRAINT t_countries_pk PRIMARY KEY(id),
	CONSTRAINT t_countries_uk UNIQUE (iso_code),
	CONSTRAINT t_countries_id_subregion_fk FOREIGN KEY(id_subregion) REFERENCES t_subregions(id)
);