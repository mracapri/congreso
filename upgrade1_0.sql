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
  activitie mediumtext NOT NULL,  
  hour varchar(200) NOT NULL,
  h1 integer(3) NOT NULL,
  h2 integer(3) NOT NULL,
  capacity_max integer(3) NOT NULL,
  capacity_min integer(3) NOT NULL,
  is_visit varchar(2) default 'NO',
  FOREIGN KEY (id_place_section) REFERENCES place_section(id),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (1, 1, "20", "Registro", "08:00-10:00", 480, 600, 1500, 1850);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (2, 1, "20", "Inauguración", "10:00-11:00", 600, 660, 1500, 1850);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (3, 1, "20", "Conferencia Magistral: 'Legislación de aditivos alimentarios en el mundo' Dra. Sara Valdéz Martínez Presidenta de la Asociación de Tecnólogos de México (1500 asistentes)", "11:00 a 12:00", 660, 720, 1500, 1500);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (4, 1, "20", "Conferencia Magistral: 'Acciones para asegurar la inocuidad de los alimentos en cumplimiento con las nuevas regulaciones  internacionales' M. Sc. Gisella Kopper Arguedas Presidenta de la Asociación de Tecnólogos de Alimentos Latinoamérica.", "12:00 a 13:00", 720, 780, 1500, 1500);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (5, 1, "20", "Evento Cultural: Banda Sinfónica del Estado de Hidalgo", "18:30 a 20:30", 1110, 1230, 1500, 1500);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (6, 1, "21", "Conferencia Magistral. Dr. Benito Manrique De Lara y Soria Presidente del Consejo de Administración San Miguel de Proyectos Agropecuarios AMARANTO NUEVO FRONTERA AGROINDUSTRIAL Y DE SOBERANIA ALIMENTARIA", "09:00 A 10:00", 540, 600, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (7, 1, "21", "Conferencia Magistral: Lic. Víctor José Gavito y Marco Presidente del Grupo Alpura", "10:00 a 11:00", 600, 660, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (8, 1, "21", "Conferencia Magistral: 'Aplicación de la cadena de frío en la industria de los alimentos'  Dr. Ignacio Covarrubias Gutiérrez Profesor Investigador de la UACH APLICACIÓN DE LA CADENA DE FRIO EN LA INDUSTRIA DE LOS ALIMENTOS", "11:00 a 12:00", 660, 720, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (9, 1, "21", "Conferencia Magistral: 'Alimentos Funcionales:   Desarrollo y Comercialización' Dra. Socorro Josefina Villanueva Investigadora  del CIATEJ ALIMENTOS FUNCIONALES INGREDIENTES NUTRACÉUTICOS", "16:00 a 17:00", 960, 1020, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (10, 1, "21", "Conferencia Magistral: 'Acuacultura' Biol. Juan Silvestre Lechuga Peña Director de Acuacultura de la Secretaría de Desarrollo Agropecuario ACUACULTURA", "17:00 a 18:00", 1020, 1080, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (11, 1, "21", "Evento cultural:  Ballet Folklórico de Alvaro Serrano", "18:00 a 20:00", 1080, 1200, 0, 0);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (12, 1, "22", "Conferencia Magistral: 'Elemento finito en sistemas de refrigeración por Peltier y Absorción en el transporte de Guayaba' Dr. Olivares Ramírez Juan Manuel Profesor Investigador de la UT de San Juan del Río Querétaro", "9:00 a 10:00", 540, 600, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (13, 1, "22", "Conferencia Magistral: 'La conservación de alimentos en el México Prehispánico' Chef Alfonso Rocha Robles Chef Irad Santacruz Arciniega Chef Alfonso Llaven Slow Food International", "10:00 a 11:00", 600, 660, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (14, 1, "22", "Conferencia Magistral: 'Tensoactivos bacterianos, gran potencial de uso' Dr. Jorge Gracida Rodrígez Profesor Investigador de la UPP", "11:00 a 12:00", 660, 720, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (15, 1, "22", "Conferencia Magistral: 'Inocuidad Agroalimentaria' Biol. Carmen Dorantes Martínez Delegada de la SAGARPA en el Estado de Hidalgo (1400 participantes", "12:00 a 13:00", 720, 780, 1300, 1400);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (16, 1, "22", "Clausura", "13:00 a 15:00", 780, 900, 1500, 1500);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (17, 2, "20", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (18, 2, "21", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria' Concurso de Creatividad.", "11:00 a 14:00", 660, 840, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (19, 2, "21", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "16:00 a 20:00", 960, 1200, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (20, 2, "22", "Exposición de Carteles: 'Ciencia y Tecnología Bioalimentaria'", "09:00 a 13:00", 540, 780, 0, 0);

/* visitas culturales */
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (21, 3, "20", "SI", "Salida a visita cultural: Zona Arqueológica de Tula", "13:00 a 18:00", 780, 1080, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (22, 3, "20", "SI", "Salida a visita cultural: Parque Ecológico Cubitos", "13:00 a 18:00", 780, 1080, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (23, 3, "20", "SI", "Salida a visita cultural: Reserva de la biosfera", "13:00 a 18:00", 780, 1080, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (24, 3, "20", "SI", "Salida a visita cultural: Museo Mina Acosto", "13:00 a 18:00", 780, 1080, 30, 40);
/* visitas culturales */


/* visitas industriales */
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (25, 3, "21", "SI", "Salida a visita industrial. SOCIEDAD COOPERATIVA DE TRABAJADORES DE PASCUAL (BOING) TIZAYUCA, HGO", "09:00 a 14:00", 540, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (26, 3, "21", "SI", "Salida a visita industrial. CABAS FREIXENET EZEQUIEL MONTES QUERETARO", "09:00 a 17:00", 540, 1020, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (27, 3, "21", "SI", "Salida a visita industrial. SAN SEBASTIAN TENOCHTITLAN NOPALA HGO", "08:00 a 15:00", 480, 900, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (28, 3, "21", "SI", "Salida a visita industrial. MULTILACTEOS TIZAYUCA, HGO", "08:00 a 13:00", 480, 780, 19, 29);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (29, 3, "21", "SI", "Salida a visita industrial. GRANJA INTEGRAL DE POLICULTIVO, TEZONTEPEC HGO", "09:00 a 14:00", 540, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (30, 3, "21", "SI", "Salida a visita industrial. RANCHO LA QUINTA, ACTOPAN HGO", "10:00 a 14:00", 600, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (31, 3, "21", "SI", "Salida a visita industrial. EL VERGEL, ZAPOTLAN HGO", "11:00 a 14:00", 660, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (32, 3, "21", "SI", "Salida a visita industrial. GANADERÍA HERMANOS RÁMIREZ SINGUILUCAN, HGO", "11:00 a 14:00", 660, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (33, 3, "21", "SI", "Salida a visita industrial. CERVECERIA SAN JUAN PUEBLILLA, ZEMPOALA HGO", "11:00 a 14:00", 660, 840, 30, 40);
insert into activities (id, id_place_section, day, is_visit, activitie, hour, h1, h2, capacity_max, capacity_min) values (34, 3, "21", "SI", "Salida a visita industrial. COMERCIALIZADORA LOS ALTOS, MINERAL DE LA REFORMA HGO", "11:00 a 14:00", 660, 840, 30, 40);
/* visitas industriales */

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (35, 4, "20", "Comida", "13:00 a 15:00", 780, 900, 1500, 1500);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (36, 4, "21", "Comida", "13:00 a 15:00", 780, 900, 875, 875);


/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (37, 5, "20", "Ponencias: Biotecnología (BA) EVALUCIÓN DE LA CALIDAD POSTCOSECHA DEL LITCHI A DIFERENTES TEMPERATURAS DE ALMACIONAMIENTO", "15:00 a 15:20", 900, 920, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (38, 5, "20", "Ponencias: Biotecnología (BA) RELACIÓN DE LOS PROTOZOARIOS CON LA EFICIENCIA DE REMOCIÓN DE MATERIA ORGÁNICA EN UN SEQUENCING BATCH REACTOR EMPACADO CON TEZONTLE", "15:20 a 15:40", 920, 940, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (39, 5, "20", "Ponencias: Biotecnología (BA) RED DE VALORES PARA CHILES DEL VALLE DE TEHUACÁN-CUICATLAN", "15:40 a 16:00", 940, 960, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (40, 5, "20", "Ponencias: Biotecnología (BA) BENCILADENINA Y ACIDO GIBERÉLICO EN LA PROMOCIÓN FLORAL DEL ALCATRAZ", "16:00 a 16:20", 960, 980, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (41, 5, "20", "Ponencias: Biotecnología (BA) RECESO ", "16:20 a 16:40", 980, 1000, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (42, 5, "20", "Ponencias: Biotecnología (BA) INFLUENCIA DEL ESTADO NUTRICIONAL DEL NOPAL SOBRE LA CALIDAD LA GRANA COCHINILLA ", "16:40 a 17:00", 1000, 1020, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (43, 5, "20", "Ponencias: Biotecnología (BA) CARACTERIZACIÓN MORFOLÓGICA Y DISTRICUCIÓN DE MATERIA SECA EN GRANOS DE HABA", "17:00 a 17:20", 1000, 1020, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (44, 5, "20", "Ponencias: Biotecnología (BA) EVALUACIÓN DE LA PRODUCCIÓN DE 5 SEPAS DE HONGOS COMESTIBLES (Pleurotus) EN PAJA DE TRIGO", "17:20 a 17:40", 1040, 1060, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (45, 5, "20", "Ponencias: Biotecnología (BA) PARASITISMO NATURAL DEL GUSANO COGOLLERO EN MAÍZ DE LOS MUNICIPIOS DE INDARAPEO TARIMBARO Y QUIROGA MICHOACAN", "17:40 a 18:00", 1060, 1080, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (46, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) CARACTERIZACIÓN DE UN BIOPOLIMERO A PARTIR DEL ALMIDÓN DE MAÍZ", "11:00 a 11:20", 660, 680, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (47, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) EL POTENCIAL BIOTECNOLÓGICO DE LA DIVERSIDAD MICROBIANA EN LA AGRICULTURA Y ALIMENTOS", "11:20 a 11:40", 680, 700, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (48, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) ESCALAMIENTO DE UN BIOFILTRO A ESCALA SEMIPILOTO PARA EL TRATAMIENTO DE AGUAS RESIDUALES", "11:40 a 12:00", 700, 720, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (49, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) CARACTERIZACIÓN FISICO-QUIMICA DE FRUTOS DE CIRUELA MEXICANA NATIVAS", "12:00 a 12:20", 720, 740, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (50, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) RECESO", "12:20 a 12:40", 740, 760, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (51, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) EVALUACIÓN DE SUSTRATOS ORGANICOS EN LA PRODUCCIÓN DE LOMBRICOMPOSTA Y EL DESARROLLO FISIOLOGICO DE LOMBRIZ", "12:40 a 13:00", 760, 780, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (52, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) DESARROLLO DE PROCESO QUIMICO-ENZIMÁTICO PARA LA OBTENCIÓN DE COMPUESTOS DE VALOR AGREGADO EN EL USO DE FRAGANCIAS Y POLÍMEROS BIODEGRADABLES", "13:00 a 13:20", 780, 800, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (53, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) USO DE BACTERIAS ACIDO LÁCTICAS EN LA ELABORACIÓN Y CONSERVACIÓN DE PRODUCTOS CÁRNICOS", "13:20 a 13:40", 800, 820, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (54, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) EFECTOS ANTIOXIDANTES SOBRE LAS PROPIEDADES FISICO-QUIMICAS Y SENSORIALES EN JICAMA", "13:40 a 14:00", 820, 840, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (55, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) TRATAMIENTO DE AGUAS RESIDUALES DEL VALLE DEL MEZQUITAL CON MICROALGAS Y CARACTERIZACIÓN PARCIAL DE SU BIOMASA", "14:00 a 14:20", 840, 860, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (56, 5, "21", "Ponencias: Biotecnología (BA) (250 participantes) AISLAMIENTO E IDENTIFICACIÓN DE MICROORGANISMOS ASOCIADOS AL TRACTO INTESTINAL DE LA GRANA COCHINILLA", "14:20 a 14:40", 860, 880, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (57, 6, "20", "Ponencias: Procesos Agroindustriales (PA) EVALUCAIÓN DE LAS PROPIEDADES REOLÓGICAS DE PASTAS HECHAS A BASE DE ALMIDÓN DE PLÁTANO", "15:00 a 15:20", 900, 920, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (58, 6, "20", "Ponencias: Procesos Agroindustriales (PA) EL XOCONOSTLE: UNA PROPUESTA DE APROVECHAMIENTO", "15:20 a 15:40", 920, 940, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (59, 6, "20", "Ponencias: Procesos Agroindustriales (PA) INDICE DE CORTE EN MANEJO POSTCOSECHA DE FLORES TROPICALES EN TABASCO", "15:40 a 16:00", 940, 960, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (60, 6, "20", "Ponencias: Procesos Agroindustriales (PA) RECESO", "16:00 a 16:20", 960, 980, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (61, 6, "20", "Ponencias: Procesos Agroindustriales (PA) EXTRACCIÓN DE CITRATO DE CALCIO A PARTIR DE RESIDUOS AGROINDUSTRIALES, COMO FORTIFICADOR EN LA ELABORACIÓN DE QUESOS", "16:20 a 16:40", 980, 1000, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (62, 6, "20", "Ponencias: Procesos Agroindustriales (PA) OBTENCIÓN DE PECTINAS A APARTIR DE LA LIMA PERSA DE PRIMERA CALIDAD", "16:40 a 17:00", 1000, 1020, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (63, 6, "21", "Ponencias: Procesos Agroindustriales (PA) OBTENCION DE JAMON DE CARNE DE CONEJO ENRIQUECIDO CON PROTEINA DE ORIGEN VEGETAL", "11:00 a 11:20", 660, 680, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (64, 6, "21", "Ponencias: Procesos Agroindustriales (PA) CINÉTICA DE SECADO CONVECTIVO DE HOJAS DE MORINGA", "11:20 a 11:40", 680, 700, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (65, 6, "21", "Ponencias: Procesos Agroindustriales (PA) COMPOSTAJE Y CALIDAD AGRICOLA DERIVADO DE DISTINTAS MEZCLAS DE RESIDUOS AGROPECUARIOS", "11:40 a 12:00", 700, 720, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (66, 6, "21", "Ponencias: Procesos Agroindustriales (PA) EFECTO DEL ESPESOR EN LAS CINÉTICAS DE SECADO CONVECTIVO DE YUCA", "12:00 a 12:20", 720, 740, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (67, 6, "21", "Ponencias: Procesos Agroindustriales (PA) RECESO", "12:20 a 12:40", 740, 760, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (68, 6, "21", "Ponencias: Procesos Agroindustriales (PA) POTENCIAL AGROINDUSTRIAL DE LA CHILACAYOTA", "12:40 a 13:00", 760, 780, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (69, 6, "21", "Ponencias: Procesos Agroindustriales (PA) INFLUENCIA DE LA FRECUENCIA DE AIREACIÓN EN EL PROCESO DE COMPOSTEO", "13:00 a 13:20", 780, 800, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (70, 6, "21", "Ponencias: Procesos Agroindustriales (PA) DESHIDRATACIÓN DE GUAJE PARA LA FORMULACIÓN DE GUISOS TRADICIONALES", "13:20 a 13:40", 800, 820, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (71, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) EFECTO DEL SECADO SOBRE LOS COMPUESTOS BIOACTIVOS DE HIJAS MORINGA OLEIFERA ", "15:00 a 15:20", 900, 920, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (72, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) DETERMINACIÓN DE LA TOXICOLOGÍA DE LA CARNE DEL PLECOSTOMUS (PEZ DIABLO)", "15:20 a 15:40", 920, 940, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (73, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) SEPARACIÓN Y CARACTERIZACIÓN PARCIAL DE FRUCTANOS DE ALTO RENDIMIENTO DE Agave Tequilana Weber Var Azul", "15:40 a 16:00", 940, 960, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (74, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) MICROENCAPSULACIÓN DE Lactobacillus reuteri ", "16:00 a 16:20", 960, 980, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (75, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) RECESO ", "16:20 a 16:40", 980, 1000, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (76, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) PESTICIDAS ORGANOCLORADOS EN AGUA, SEDIMENTOS Y SUELOS AGRICOLAS ", "16:40 a 17:00", 1000, 1020, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (77, 7, "20", "Ponencias: Ciencia de los Alimentos (CA) DETERMINACION DE FITOQUIMICOS DE NATURALEZA ANTIOXIDANTE EN FLOR DE JAMAICA (Hibiscus Sabdariffa) Y NANCHE DESHIDRATADO (Byrsonimia crassifolia) ", "17:00 a 17:20", 1000, 1020, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (78, 7, "20", "Ponencias: Ciencia de los Alimentos (CA)  DETECCIÓN DE N-NITROSAMINAS EN LA CARNE DE TILAPIA EN PROCESO DE DESCOMPOSICIÓN POR CROMATOGRAFÍA DE GASES ACOMPLADA A ESPECTROMETRÍA DE MASAS", "17:20 a 17:40", 1040, 1060, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (79, 7, "21", "Ponencias: Ciencia de los Alimentos (CA) DETERMINACIÓN DE AMINAS BIÓGENAS EN TILAPIA EMPLEANDO ESPECTROSCOPÍA INFRAROJA POR TRANSFORMADAS DE FOURIER", "11:00 a 11:20", 660, 680, 225, 250);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (80, 7, "21", "Ponencias: Ciencia de los Alimentos (CA) ANÁLISIS DE FACTORES QUE MODIFICAN LA REOLOGÍA DE CREMAS PARA BATIR TIPO CHANTILLI ELABORADOS EN MÉXICO Y DENOMINADOS CREMA Q Y HQ", "11:20 a 11:40", 680, 700, 225, 250);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (81, 7, "21", "Ponencias: Aplicación de la energía renovable en la conservación y transformación de los alimentos MODULO DEMOSTRATIVO DE PRODUCCIÓN SUSTENTABLE DE ALIMENTOS: EL HUERTO FAMILIAR (CINÉTICA DE SECADO SOLAR)", "11:40 a 12:00", 680, 700, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (82, 7, "21", "Ponencias: Aplicación de la energía renovable en la conservación y transformación de los alimentos DESHIDRATADOR SOLAR EN EL PROCESO DE PRODUCCIÓN DE GRANA COCHINILLA", "12:00 a 12:20", 700, 720, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (83, 7, "21", "Ponencias: Aplicación de la energía renovable en la conservación y transformación de los alimentos SELECCIÓN DEL EMPLAZAMIENTO ADECUADO PARA SISTEMAS EÓLICOS Y TERMOSOLARES OPTIMIZANDO LOS RECURSOS RENOVABLES DISPONIBLES MEDIANTE UN SOFTWARE", "12:20 a 12:40", 720, 740, 90, 100);
/* ponencias */


/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (84, 8, "20", "Ponencias: Inocuidad Alimentaria CAPACITACIÓN DE LOS TEMAS DEL SISTEMA DE GESTIÓN COMO HERRAMIENTA, PARA LA CERTIFICACIÓN EN LA FSSC:22000", "15:00 a 15:20", 900, 920, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (85, 8, "20", "Ponencias: Inocuidad Alimentaria EVALUCIÓN DE CONDICIONES Y MANEJO SANITARIO DE LAS MICROEMPRESAS DEL RAMO ALIMENTARIO INCUBADAS EN LA UT DE TABASCO", "15:20 a 15:40", 920, 940, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (86, 8, "20", "Ponencias: Inocuidad Alimentaria EVALUACIÓN DE Bacillus subtitis COMO BIOINDICADORES DE ANTIMICROBIANOS PRESENTES EN LA LECHE PASTEURIZADA", "15:40 a 16:00", 940, 960, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (87, 8, "20", "Ponencias: Inocuidad Alimentaria DETERMINCIÓN DE LA CALIDAD MICROBIOLÓGICA DE LOS ALIMENTOS EXPEDIDOS EN LA FERIA DE LA CIUDAD DE PUEBLA DEL 2012", "16:00 a 16:20", 960, 980, 90, 100);
/* ponencias */


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (88, 9, "20", "Expo Empresarial (140 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (89, 9, "21", "Expo Empresarial (100 participantes por hora)", "11:00 a 16:00", 660, 960, 90, 100);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (90, 10, "20", "Expo Empresarial (100 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (91, 10, "21", "Expo Proyectos. Concurso de creatividad. (100 participantes por hora)", "11:00 a 16:00", 660, 960, 90, 100);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (92, 11, "20", "Expo Hidalgo (100 participantes por hora)", "13:00 a 18:00", 780, 1080, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (93, 11, "21", "Expo Hidalgo (100 participantes por hora)", "11:00 a 16:00", 660, 960, 90, 100);

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (94, 12, "20", "Ponencias: Salud y Nutrición MICROENCAPSULACIÓN DE L. acidophilus MEDIANTE LIOFILIZACIÓN Y EVALUACIÓN DE SU SUPERVIVENCIA EN CONDICIONES GASTROINTESTINALES SIMULADAS ", "15:00 a 15:20", 900, 920, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (95, 12, "20", "Ponencias: Salud y Nutrición EFECTO DE LA EXTRACCIÓN ASISTIDA POR ONDAS DE ULTRASONIDO SOBRE EL CONTEIDO FENÓLICO Y LA ACTIVIDAD ANTIRADICAL DE ESTRATOS ETANÓLICOS DE HOJAS DE moringa oleífera", "15:20 a 15:40", 920, 940, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (96, 12, "20", "Ponencias: Salud y Nutrición DESARROLLO DE SALCHICHA DE POLLO FORMULADA CON ACEITE VEGETAL Y ENRIQUEDICA CON NOPAL COMO FUENTE DE FIBRA", "15:40 a 16:00", 940, 960, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (97, 12, "20", "Ponencias: Salud y Nutrición ELABORACIÓN DE UNA BEBIDA FUNCIONAL A BASE DE NANCHE DESHIDRATADO", "16:00 a 16:20", 960, 980, 90, 100);
/* ponencias */


/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (98, 12, "21", "Ponencias: Equipo para la agroindustria MATERIALES DE ÚLTIMA GENERACIÓN EN EL EMPACADO Y ENVASADO DE ALIMENTOS (LA IMPORTANCIA DEL RECICLAJE)", "11:00 a 11:20", 660, 680, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (99, 12, "21", "Ponencias: Equipo para la agroindustria DISEÑO DE MAQUINARIA AGRICOLA (CONSIDERACIONES GENERALES)", "11:20 a 11:40", 680, 700, 90, 100);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (100, 12, "21", "Ponencias: Tecnologías regionales ANÁLISIS ESTADÍSTICO EVALUACIÓN SENSORIAL EN PRODUCTOS DE CEREALES ADICIONADOS CON OLEORESINA DE CHILE", "11:40 a 12:00", 700, 720, 90, 100);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (101, 12, "21", "Ponencias: Turismo rural GASTRONOMÍA EN FLORES ORGÁNICAS: EXPERIENCÍA AGROTURÍSTICA EN LA COMUNIDAD RURAL CAPULA", "12:00 a 12:20", 720, 740, 90, 100);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (102, 12, "21", "Ponencias: Turismo rural PASIÓN, RECUERDO Y COLORES... SEMANA SANTA EN TEZONTEPEC DE ALDAMA HGO", "12:20 a 12:40", 740, 760, 90, 100);
/* ponencias */

/* ponencias */
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (103, 12, "21", "Ponencias: Acuicultura EL Branchiopodo streptocephalus COMO ALIMENTO VIVO PARA ACUACULTURA", "12:40 a 13:00", 760, 780, 90, 100);
/* ponencias */

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (104, 12, "21", "Foro de investigación. (50  participantes)", "10:00 a 12:00", 600, 720, 90, 100);

/* ponencias */ 
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (105, 13, "20", "Ponencias: Aplicaciones de la computación en la agroindustria y la biotecnología PARFIN2 SOFTWARE PARA RESOLVER SISTEMA DE ECUACIONES DIFERENCIALES", "15:00 a 15:20", 900, 920, 40, 50);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (106, 13, "20", "Ponencias: Aplicaciones de la computación en la agroindustria y la biotecnología PAPEL DEL PORTAFOLIO DE EVIDENCIAS DIGITAL EN LINEA DEL PROGRAMA EDUCATIVO DE ACUICULTURA DE LA UTVM", "15:20 a 15:40", 920, 940, 40, 40);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (107, 13, "20", "Ponencias: Aplicaciones de la computación en la agroindustria y la biotecnología MODULO ADMINISTRATIVO DE XIDO HAI s.p de r.i", "15:40 a 16:00", 940, 960, 40, 50);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (108, 13, "20", "Ponencias: Aplicaciones de la computación en la agroindustria y la biotecnología ADOPCIÓN Y USO DE LAS TICS EN EL SECTOR PRODUCTIVO AGRICOLA COMO SISTEMAS PROMOTORES DE LA COMPETITIVIDAD", "16:00 a 16:20", 960, 980, 40, 50);
/* ponencias */

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (109, 13, "21", "Reunión de Cuerpos Académicos (50 participantes)", "14:00 a 16:00", 840, 960, 0, 0);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (110, 13, "22", "Foro de egresados (50 participantes)", "10:00 a 12:00", 600, 720, 40, 50);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (111, 14, "21", "Comida", "13:00 a 15:00", 780, 900, 875, 875);
/* ponencias */ 
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (112, 14, "20", "Ponencias: Productos Agroindustriales como Agronegocios ESTRATEGIAS ORGANIZACIONALES COMO VENTAJA COMPETITIVA EN EL SECTOR AGROINDUSTRIAL", "15:00 a 15:20", 900, 920, 40, 50);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (113, 14, "20", "Ponencias: Productos Agroindustriales como Agronegocios ANALISIS DEL SECTOR AGROINDUSTRIAL COMO ESLABÓN DEL SISTEMA PRODUCTIVO LECHERO DE LA CUENCA DE TECAMACHALCO PUEBLA", "15:20 a 15:40", 920, 940, 40, 40);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (114, 14, "20", "Ponencias: Productos Agroindustriales como Agronegocios RESULTADOS PRELIMINARES: DIAGNOSTICO DEL CONSUMO DE SUBPRODUCTOS DEL COCO EN EL ESTADO DE TABASCO", "15:40 a 16:00", 940, 960, 40, 50);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (115, 14, "20", "Ponencias: Productos Agroindustriales como Agronegocios AGRONEGOCIOS: IMPORTANCIA DE LOS COSTOS EN EL PROCESO DE PRODUCCCIÓN DE HORTALIZAS COMO BASE PARA SU COMERCIALIZACIÓN", "16:00 a 16:20", 960, 980, 40, 50);
/* ponencias */


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (116, 15, "21", "Práctica de laboratorio: Determinación de proteína en flores sábila.", "11:00 a 14:00", 660, 840, 20, 25);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (117, 16, "21", "Práctica de taller: Elaboración de bolitas Gourmet a base de dátil.", "09:00 a 11:00", 540, 660, 20, 25);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (118, 16, "21", "Práctica de taller: De confitería Ing. Celerino Arroyo Cruz, UT del Valle del Mezquital", "12:00 a 15:00", 720, 900, 0, 0);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (119, 17, "21", "Práctica de laboratorio: Análisis fisico-químicos de agua para consumo humano.", "11:00 a 13:00", 660, 780, 20, 25);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (120, 18, "21", "Práctica de taller: Elaboración de queso Chihuahua y sus pruebas de calidad.", "09:00 a 13:00", 540, 780, 20, 25);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (121, 19, "21", "Práctica de taller: Elaboración de base frutal para  yogurt", "09:00 a 11:00", 540, 660, 20, 25);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (122, 19, "21", "Práctica demostrativa: Concentración de proteínas de suero por ultrafiltración", "11:00 a 14:00", 660, 840, 20, 25);


insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (123, 20, "21", "Práctica de taller: Elaboración de cárnicos a base de guajolote criollo.", "09:00 a 12:00", 540, 720, 20, 25);
insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (124, 20, "21", "Práctica de taller: Proceso de conservación por salmuera y ahumado en chuletas de cerdo", "12:00 a 14:00", 720, 840, 20, 25);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (125, 21, "21", "Práctica de taller: Elaboración de yogurt  aflanado y cremoso.", "12:00 a 14:00", 720, 840, 15, 20);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (126, 22, "21", "Práctica de taller: Técnicas de Atención y servicio al cliente en la industria alimentaria", "09:00 a 11:00", 540, 660, 15, 20);

insert into activities (id, id_place_section, day, activitie, hour, h1, h2, capacity_max, capacity_min) values (127, 23, "21", "Plática demostrativa: Afilado de cuchillos y cuchillas para la industria cárnica", "11:00 a 14:00", 660, 840, 190, 200);



CREATE TABLE IF NOT EXISTS activitie_participant (
  id_activitie integer(3) NOT NULL,
  email varchar(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES information_account(email),
  FOREIGN KEY (id_activitie) REFERENCES activities(id),
  UNIQUE (id_activitie, email)
);