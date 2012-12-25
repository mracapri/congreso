DROP DATABASE congreso;
CREATE DATABASE IF NOT EXISTS congreso;
USE congreso;

CREATE TABLE IF NOT EXISTS university (
  id integer(3) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id),
  KEY index_university (id)
);

insert into university(id, name) values 
(1, 'Universidad Tecnologica del Valle del Mezquital'), 
(2, 'Universidad Tecnologica de Tula Tepeji');