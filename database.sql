DROP DATABASE congreso;
CREATE DATABASE IF NOT EXISTS congreso;
USE congreso;

set GLOBAL max_allowed_packet = 1024*1024*1024*10;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS university (
  id integer(3) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into university(id, name) values 
(1, 'Universidad Tecnologica del Valle del Mezquital'), 
(2, 'Universidad Tecnologica del Suroeste  de Guanajuato'), 
(3, 'Universidad Tecnologica de Tehuacán'),
(4, 'Universidad Tecnologica de Izucar de Matamoros'),
(5, 'Universidad Tecnologica de Usumacinta'),
(6, 'Universidad Tecnologica de la Corregidora Qro.'),
(7, 'Universidad Tecnologica de Puebla'),
(8, 'Universidad Tecnologica de Huejotzingo '),
(9, 'Universidad Tecnologica de Tabasco'),
(10, 'Universidad Tecnologica de de San Luis Rio Colorado'),
(11, 'Universidad Tecnologica Valles Centrales de Oaxaca'),
(12, 'Universidad Tecnologica de Morelia'),
(13, 'Universidad Tecnologica de la Costa'),
(14, 'Universidad Tecnologica del poniente (Maxcano, Yucatan)'),
(15, 'Universidad Tecnologica de Tecamachalco'),
(16, 'Universidad Tecnologica del Sur del Estado de México'),
(17, 'Universidad Tecnologica  de Nayarit'),
(18, 'Universidad Tecnologica de Tecamac'),
(19, 'Universidad Tecnologica del centro de Veracruz'),
(20, 'Universidad Tecnologica de la Huasteca Hidalguense '),
(21, 'Universidad Tecnologica de la Costa Grande de Guerrero'),
(22, 'Universidad Tecnologica de de Xicotepec de Juárez'),
(23, 'Universidad Tecnologica de la Selva '),
(24, 'Universidad Tecnologica de Tijuana (Unidad académica de ensenada)'),
(25, 'Universidad Tecnologica de Tula Tepeji');

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
  reference_key varchar(80) NOT NULL,
  enabled tinyint(1)  NOT NULL,
  PRIMARY KEY (email)
);
insert into information_account(email, password, token, reference_key, enabled) 
values ('mra_capri@msn.com', 'riam821204', '', '', 1);

insert into information_account(email, password, token, reference_key, enabled) 
values ('yrivera@msn.com', 'riam821204', '', '', 1);

CREATE TABLE user_roles (
  user_role_id INT(10) NOT NULL AUTO_INCREMENT,
  user_id varchar(50) NOT NULL,
  authority VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  KEY FK_user_roles (user_id),
  CONSTRAINT FK_user_roles FOREIGN KEY (user_id) REFERENCES information_account (email)
);
insert into user_roles (user_id, authority) values ('mra_capri@msn.com', 'ROLE_ADMIN');
insert into user_roles (user_id, authority) values ('yrivera@msn.com', 'ROLE_ADMIN_PARTICIPATION');

CREATE TABLE IF NOT EXISTS preregister_information (
  email varchar(50) NOT NULL,
  name varchar(100) NOT NULL,
  second_name varchar(100) NOT NULL,
  third_name varchar(100) NOT NULL,
  id_university integer(3) NOT NULL,
  id_ocupation integer(3) NOT NULL,
  payment_status varchar(50) NULL DEFAULT 'NO_PAGADO',
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
  participation_name varchar(100) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_participation) REFERENCES participation(id),
  FOREIGN KEY (id_university) REFERENCES university(id),
  FOREIGN KEY (id_ocupation) REFERENCES ocupation(id)
);

CREATE TABLE IF NOT EXISTS academy_information (
  email varchar(50) NOT NULL,
  name varchar(100) NOT NULL,
  investigation_line text NOT NULL,
  contact text NOT NULL,
  id_university integer(3) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_university) REFERENCES university(id)
);

CREATE TABLE IF NOT EXISTS fiscal_information (
  email varchar(50) NOT NULL,
  fiscal_name varchar(100) NOT NULL,
  rfc varchar(13) NOT NULL,
  address varchar(250) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email)
);