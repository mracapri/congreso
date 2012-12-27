DROP DATABASE congreso;
CREATE DATABASE IF NOT EXISTS congreso;
USE congreso;

set GLOBAL max_allowed_packet = 1024*1024*1024*10;

CREATE TABLE IF NOT EXISTS university (
  id integer(3) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

insert into university(id, name) values 
(1, 'Universidad Tecnologica del Valle del Mezquital'), 
(2, 'Universidad Tecnologica de Tula Tepeji');

CREATE TABLE IF NOT EXISTS ocupation (
  id integer(3) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

insert into ocupation(id, name) values 
(1, 'Alumno'), 
(2, 'Docente'),
(3, 'Investigador'),
(4, 'Otro');

CREATE TABLE IF NOT EXISTS information_account (
  email varchar(50) NOT NULL,
  password varchar(20) NOT NULL,
  token varchar(50) NOT NULL,
  reference_key varchar(50) NOT NULL,
  PRIMARY KEY (email)
);


CREATE TABLE IF NOT EXISTS preregister_information (
  email varchar(50) NOT NULL,
  name varchar(100) NOT NULL,
  second_name varchar(100) NOT NULL,
  third_name varchar(100) NOT NULL,
  id_university integer(3) NOT NULL,
  id_ocupation integer(3) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_university) REFERENCES university(id),
  FOREIGN KEY (id_ocupation) REFERENCES ocupation(id)
);

CREATE TABLE IF NOT EXISTS participation (
  id integer(3) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

insert into participation(id, name) values 
(1, 'Ponencia'), 
(2, 'Cartel'),
(3, 'Taller');

CREATE TABLE IF NOT EXISTS participation_register_information (
  email varchar(50) NOT NULL,
  name varchar(100) NOT NULL,
  second_name varchar(100) NOT NULL,
  third_name varchar(100) NOT NULL,
  phone varchar(15) NOT NULL,
  id_university integer(3) NOT NULL,
  id_ocupation integer(3) NOT NULL,
  id_participation integer(3) NOT NULL,
  participation_pdf_file longblob NOT NULL,
  participation_pdf_file_name varchar(100) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_participation) REFERENCES participation(id),
  FOREIGN KEY (id_university) REFERENCES university(id),
  FOREIGN KEY (id_ocupation) REFERENCES ocupation(id)
);

CREATE TABLE IF NOT EXISTS academy_information (
  email varchar(50) NOT NULL,
  name varchar(100) NOT NULL,
  investigation_line varchar(100) NOT NULL,
  contact varchar(100) NOT NULL,
  id_university integer(3) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_university) REFERENCES university(id)
);