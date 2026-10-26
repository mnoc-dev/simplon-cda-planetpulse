CREATE TABLE t_indicators(
   id INTEGER generated always as identity,
   indicator_year integer not null,
   forest_area_indicator numeric(5,2),
   co2_emission numeric(12,2),
   PM2_5_exposure numeric(3,1),
   renewable_energy_share numeric(5,2),
   id_country integer,
   constraint t_indicators_pk primary key(id),
   constraint t_indicators_year_uk UNIQUE(id_country,indicator_year),
   constraint t_indicators_id_country_fk foreign key(id_country) references t_countries(id)
);
