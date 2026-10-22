DROP TABLE IF EXISTS  t_notes;
CREATE TABLE t_notes(
   id_note INT GENERATED ALWAYS AS IDENTITY,
   creation_date TIMESTAMPTZ NOT NULL DEFAULT now() UNIQUE,
   title VARCHAR(255)  NOT NULL  CHECK (length(trim(title)) >=1),
   date_report DATE NOT NULL,
   content VARCHAR(10000) NOT NULL CHECK (length(trim(content)) >=1),
   id_country INT NOT NULL,
   PRIMARY KEY(id_note),
   CONSTRAINT fk_country FOREIGN KEY (id_country) REFERENCES t_countries(id_country)
);