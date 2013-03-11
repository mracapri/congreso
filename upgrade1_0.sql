/* Agenda de actividades */
SET NAMES 'latin1';

insert into information_account(email, password, token, reference_key, enabled) 
values ('captura1@utvm.edu.mx', 'captura', '', '', 1);
insert into information_account(email, password, token, reference_key, enabled) 
values ('captura2@utvm.edu.mx', 'captura', '', '', 1);

insert into user_roles (user_id, authority) values ('captura1@utvm.edu.mx', 'ROLE_CAPTURA');
insert into user_roles (user_id, authority) values ('captura2@utvm.edu.mx', 'ROLE_CAPTURA');


CREATE TABLE IF NOT EXISTS place (
  id integer(3) NOT NULL,
  place varchar(200) NOT NULL,
  PRIMARY KEY (id)
);

insert into place (id, place) values (1, "TEATRO GOTA DE PLATA (Pachuca, Hgo)");
insert into place (id, place) values (2, "CENTRO DE CONVENCIONES TUZO FORUM (Pachuca, Hgo)");
insert into place (id, place) values (3, "BIBLIOTECA RICARDDO GARIBAY (Pachuca Hgo).");
insert into place (id, place) values (4, "UNIVERSIDAD TECNOLÓGICA DEL VALLE DEL MEZQUITAL (Ixmiquilpan, Hidalgo)");

CREATE TABLE IF NOT EXISTS place_section (
  id integer(3) NOT NULL,
  id_place integer(3) NOT NULL,
  place_section varchar(200) NOT NULL,
  FOREIGN KEY (id_place) REFERENCES place(id),
  PRIMARY KEY (id)
);

insert into place_section (id, id_place, place_section) values (1, 1, "Auditorio");
insert into place_section (id, id_place, place_section) values (2, 1, "Vestíbulo");
insert into place_section (id, id_place, place_section) values (3, 1, "Estacionamiento exterior");
insert into place_section (id, id_place, place_section) values (4, 1, "Estacionamiento interior");

insert into place_section (id, id_place, place_section) values (5, 2, "Sala Monterrey I");
insert into place_section (id, id_place, place_section) values (6, 2, "Sala Monterrey II");
insert into place_section (id, id_place, place_section) values (7, 2, "Sala Monterrey III");
insert into place_section (id, id_place, place_section) values (8, 2, "Salón Alcatraz");
insert into place_section (id, id_place, place_section) values (9, 2, "Salones: Pachuca1, Pachuca2 y Pachuca3.");
insert into place_section (id, id_place, place_section) values (10, 2, "Terraza");
insert into place_section (id, id_place, place_section) values (11, 2, "Lobby");

insert into place_section (id, id_place, place_section) values (12, 3, "Sala de usos multiples");
insert into place_section (id, id_place, place_section) values (13, 3, "Sala de capacitación electrónica");
insert into place_section (id, id_place, place_section) values (14, 3, "Sala Fondo Hidalgo");

insert into place_section (id, id_place, place_section) values (15, 4, "Cafetería (edificio 'i'");
insert into place_section (id, id_place, place_section) values (16, 4, "Laboratorio de Química I (Edificio 'e')");
insert into place_section (id, id_place, place_section) values (17, 4, "Laboratorio de Química II (Edificio 'e')");
insert into place_section (id, id_place, place_section) values (18, 4, "Laboratorio de Microbiología (edificio 'e')");
insert into place_section (id, id_place, place_section) values (19, 4, "Taller de Lácteos (edificio 'e')");
insert into place_section (id, id_place, place_section) values (20, 4, "Taller de Frutas y Hortalizas (Edificio 'e')");
insert into place_section (id, id_place, place_section) values (21, 4, "Taller de Carnes (Edificio 'e')");
insert into place_section (id, id_place, place_section) values (22, 4, "Laboratorio de Alimentos y Bebidas (Edificio 'h')");
insert into place_section (id, id_place, place_section) values (23, 4, "Biblioteca (Edificio 'A')");
insert into place_section (id, id_place, place_section) values (24, 4, "Auditorio Bicentenario (Edificio 'c')");

CREATE TABLE IF NOT EXISTS activities (
  id integer(3) NOT NULL,
  id_place_section integer(3) NOT NULL,
  day varchar(10) NOT NULL,
  activitie varchar(200) NOT NULL,  
  hour varchar(200) NOT NULL,
  h1 integer(3) NOT NULL,
  h2 integer(3) NOT NULL,
  capacity_max integer(3) NOT NULL,
  capacity_min integer(3) NOT NULL,
  FOREIGN KEY (id_place_section) REFERENCES place_section(id),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (1, 1, "20", "Registro", "08:00-10:00", 480, 600, 2, 1);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (2, 1, "20", "Inauguración", "10:00-11:00", 600, 660, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (3, 1, "20", "Conferencia Magistral: 'Legislación de aditivos alimentarios en el mundo' Dra. Sara Valdéz Martínez Presidenta de la Asociación de Tecnólogos de México (1500 asistentes)", "11:00 a 12:00", 660, 720, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (4, 1, "20", "Conferencia Magistral: 'Acciones para asegurar la inocuidad de los alimentos en cumplimiento con las nuevas regulaciones  internacionales' M. Sc. Gisella Kopper Arguedas Presidenta de la Asociación de Tecnólogos de Alimentos Latinoamérica.", "12:00 a 13:00", 720, 780, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (5, 1, "20", "Evento Cultural: Banda Sinfónica del Estado de Hidalgo", "18:30 a 20:30", 1110, 1230, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (6, 1, "21", "Conferencia Magistral. Dr. Benito Manrique De Lara y Soria Presidente del Consejo de Administración San Miguel de Proyectos Agropecuarios", "9:00 A 10:00", 540, 600, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (7, 1, "21", "Conferencia Magistral: Lic. Víctor José Gavito y Marco Presidente del Grupo Alpura", "10:00 a 11:00", 600, 660, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (8, 1, "21", "Conferencia Magistral: 'Aplicación de la cadena de frío en la industria de los alimentos'  Dr. Ignacio Covarrubias Gutiérrez Profesor Investigador de la UACH", "11:00 a 12:00", 660, 720, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (9, 1, "21", "Conferencia Magistral: 'Alimentos Funcionales:   Desarrollo y Comercialización' Dra. Socorro Josefina Villanueva Investigadora  del CIATEJ", "16:00 a 17:00", 960, 1020, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (10, 1, "21", "Conferencia Magistral: 'Acuacultura' Biol. Juan Silvestre Lechuga Peña Director de Acuacultura de la Secretaría de Desarrollo Agropecuario", "17:00 a 18:00", 1020, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (11, 1, "21", "Evento cultural:  Ballet Folklórico de Alvaro Serrano", "18:00 a 20:00", 1080, 1200, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (12, 1, "22", "Conferencia Magistral: 'Elemento finito en sistemas de refrigeración por Peltier y Absorción en el transporte de Guayaba' Dr. Olivares Ramírez Juan Manuel Profesor Investigador de la UT de San Juan del Río Querétaro", "9:00 a 10:00", 540, 600, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (13, 1, "22", "Conferencia Magistral: 'La conservación de alimentos en el México Prehispánico' Chef Alfonso Rocha Robles Chef Irad Santacruz Arciniega Chef Alfonso Llaven Slow Food International", "10:00 a 11:00", 600, 660, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (14, 1, "22", "Conferencia Magistral: 'Tensoactivos bacterianos, gran potencial de uso' Dr. Jorge Gracida Rodrígez Profesor Investigador de la UPP", "11:00 a 12:00", 660, 720, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (15, 1, "22", "Conferencia Magistral: 'Inocuidad Agroalimentaria' Biol. Carmen Dorantes Martínez Delegada de la SAGARPA en el Estado de Hidalgo (1400 participantes", "12:00 a 13:00", 720, 780, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (16, 1, "22", "Clausura", "13:00 a 15:00", 780, 900, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (17, 2, "20", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (18, 2, "21", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria' Concurso de Creatividad.", "11:00 a 14:00", 660, 840, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (19, 2, "21", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "16:00 a 20:00", 960, 1200, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (20, 2, "22", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "09:00 a 13:00", 540, 780, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (21, 3, "20", "Salida a visita cultural", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (22, 3, "21", "Salida a visita industrial. Nueve visitas industriales.", "09:00 a 14:00", 540, 840, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (23, 4, "20", "Comida  (1500 asistentes)", "13:00 a 15:00", 780, 900, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (24, 4, "21", "Comida  (1500 asistentes)", "13:00 a 15:00", 780, 900, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (25, 5, "20", "Ponencias: Biotecnología (BA)  (250 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (26, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes)", "11:00 a 14:00", 660, 840, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (27, 6, "20", "Ponencias: Procesos Agroindustriales (PA) (250 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (28, 6, "21", "Ponencias: Procesos Agroindustriales (PA) (250 participantes)", "11:00 a 13:00", 660, 780, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (29, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) (250 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (30, 7, "21", "Ponencias: Ciencia de los Alimentos (CA)  Aplicación de las energías renovables en la conservación y Transformación de Alimentos. (250 participantes)", "11:00 a 13:00", 660, 	780, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (31, 8, "20", "Ponencias: Inocuidad Alimentaria (100 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (32, 9, "20", "Expo Empresarial (140 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (33, 9, "21", "Expo Empresarial (100 participantes por hora)", "11:00 a 16:00", 660, 960, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (34, 10, "20", "Expo Empresarial (100 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (35, 10, "21", "Expo Proyectos. Concurso de creatividad. (100 participantes por hora)", "11:00 a 16:00", 660, 960, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (36, 11, "20", "Expo Hidalgo (100 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (37, 11, "21", "Expo Hidalgo (100 participantes por hora)", "11:00 a 16:00", 660, 960, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (38, 12, "20", "Ponencias: Salud y Nutrición. (100 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (39, 12, "21", "Foro de investigación. (50  participantes)", "10:00 a 12:00", 600, 720, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (40, 13, "20", "Ponencias: Aplicaciones de la computación en la agroindustria y la biotecnología. (50 participantes)", "15:00 a 18:00", 900, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (41, 13, "21", "Reunión de Cuerpos Académicos (50 participantes)", "14:00 a 16:00", 840, 960, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (42, 13, "22", "Foro de egresados (50 participantes)", "10:00 a 12:00", 600, 720, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (43, 14, "21", "Comida", "13:00 a 15:00", 780, 900, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (44, 15, "21", "Práctica de laboratorio: Determinación de proteína en flores sábila. (25 participantes)", "11:00 a 14:00", 660, 840, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (45, 16, "21", "Práctica de taller: Elaboración de bolitas Gourmet a base de dátil. (25 participantes)", "09:00 a 11:00", 540, 660, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (46, 16, "21", "Práctica de taller: De confitería Ing. Celerino Arroyo Cruz, UT del Valle del Mezquital (25 participantes)", "12:00 a 15:00", 720, 900, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (47, 17, "21", "Práctica de laboratorio: Análisis fisico-químicos de agua para consumo humano (25 participantes).", "11:00 a 13:00", 660, 780, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (48, 18, "21", "Práctica de taller: Elaboración de queso Chihuahua y sus pruebas de calidad (25 participantes).", "09:00 a 13:00", 540, 780, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (49, 19, "21", "Práctica de taller: Elaboración de base frutal para  yogurt (30 participantes)", "09:00 a 11:00", 540, 660, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (50, 19, "21", "Práctica demostrativa: Concentración de proteínas de suero por ultrafiltración (30 participantes)", "11:00 a 14:00", 660, 840, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (51, 20, "21", "Práctica de taller: Elaboración de cárnicos a base de guajolote criollo. (25  participantes)", "09:00 a 12:00", 540, 720, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (52, 20, "21", "Práctica de taller: Proceso de conservación por salmuera y ahumado en chuletas de cerdo (25 participantes)", "12:00 a 14:00", 720, 840, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (53, 21, "21", "Práctica de taller: Elaboración de yogurt  aflanado y cremoso. (20 participantes)", "12:00 a 14:00", 720, 840, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (54, 22, "21", "Práctica de taller: Técnicas de Atención y servicio al cliente en la industria alimentaria (20 participantes)", "09:00 a 11:00", 540, 660, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (55, 23, "21", "Plática demostrativa: Afilado de cuchillos y cuchillas para la industria cárnica (200 participantes). Nota: Esta actividad esta reservada para los participantes de los talleres.", "11:00 a 14:00", 660, 840, 0, 0);



CREATE TABLE IF NOT EXISTS activitie_participant (
  id_activitie integer(3) NOT NULL,
  email varchar(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_activitie) REFERENCES activities(id),
  UNIQUE (id_activitie, email)
);