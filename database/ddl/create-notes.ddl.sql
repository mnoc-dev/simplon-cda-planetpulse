DROP TABLE IF EXISTS  t_notes;
CREATE TABLE t_notes(
   country_identifier CHAR(2) references t_countries(iso_code),
   creation_date TIMESTAMPTZ,
   title VARCHAR(255)  NOT NULL  CHECK (length(trim(title)) >=1),
   date_report DATE NOT NULL,
   content VARCHAR(10000) NOT NULL CHECK (length(trim(content)) >=1),
   PRIMARY KEY(creation_date, country_identifier)
);