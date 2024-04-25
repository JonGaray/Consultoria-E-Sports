/*Equipos*/
INSERT INTO equipos (nombre, fecha_fundacion) VALUES
('Team Alpha', TO_DATE('01/01/2015', 'DD/MM/YYYY'));
INSERT INTO equipos (nombre, fecha_fundacion) VALUES
('Team Bravo', TO_DATE('15/07/2016', 'DD/MM/YYYY'));
INSERT INTO equipos (nombre, fecha_fundacion) VALUES
('Team Charlie', TO_DATE('10/03/2017', 'DD/MM/YYYY'));
INSERT INTO equipos (nombre, fecha_fundacion) VALUES
('Team Delta', TO_DATE('20/11/2018', 'DD/MM/YYYY'));


/*Jugadores*/
INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('John Smith', 'Estados Unidos', '10/06/1995', 'xXxGamerxXx', 'ADC', 1500,2);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Maria Garcia', 'Espa�a', '10/03/1999', 'KillerQueen', 'Support', 1400,2); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Jung Min-woo', 'Corea del Sur', '19/02/1985', 'SniperKing', 'Jungler', 1600,2); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Luis Hernandez', 'M�xico', '20/09/2000', 'AztecWarrior', 'Top', 1350,3); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Anna Schmidt', 'Alemania', '10/08/1955', 'Blitzkrieg', 'Mid', 1450,1); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Chen Wei', 'China', '10/11/1989', 'DragonMaster', 'ADC', 1550,2); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Ryuji Tanaka', 'Jap�n', '10/01/1975', 'SamuraiSlicer', 'Top', 1400,4); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Sofia Petrova', 'Rusia', '10/06/1995', 'IceQueen', 'Support', 1380,4); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Ricardo Silva', 'Brasil', '10/06/1995', 'SambaGod', 'Mid', 1420,1); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Elias Nielsen', 'Dinamarca', '10/06/1995', 'VikingWarrior', 'Jungler', 1450,4); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Ahmed Hassan', 'Egipto', '10/06/1995', 'Pharaoh', 'ADC', 1600,1); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Lee Sung-hoon', 'Corea del Sur', '10/06/1995', 'NinjaAssassin', 'Mid', 1480,1);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Mateo Fernandez', 'Argentina', '10/06/1995', 'TangoMaster', 'Support', 1375,4);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Katarina Ivanova', 'Bulgaria', '10/06/1995', 'DarkKnightess', 'Mid', 1360,3);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Luca Rossi', 'Italia', '10/06/1995', 'Gladiator', 'Top', 1500,3); 

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Haruto Yamamoto', 'Jap�n', '10/06/1995', 'Ronin', 'Jungler', 1450,3);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Miguel Rodriguez', 'Espa�a', '10/06/1995', 'Matador', 'ADC', 1550,1);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Nadia Kovalenko', 'Ucrania', '10/06/1995', 'Blizzard', 'Support', 1400,2);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Andrei Popescu', 'Rumania', '10/06/1995', 'CountDracula', 'Mid', 1450,4);

INSERT INTO jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Tobias Jensen', 'Dinamarca', '10/06/1995', 'Thundergod', 'Top', 1400,3);

/*Staff*/
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Alvaro','Entrenador',1400,1);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Adrian','Entrenador',1325,2);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Alberto','Entrenador',1600,3);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Lucia','Entrenador',1500,4);


/*Patrocinadores*/
INSERT INTO patrocinadores (nombre) VALUES
('CyberTech Solutions');
INSERT INTO patrocinadores (nombre) VALUES 
('EliteGaming Gear');
INSERT INTO patrocinadores (nombre) VALUES 
('HyperXperience');
INSERT INTO patrocinadores (nombre) VALUES 
('NovaForce Gaming');
INSERT INTO patrocinadores (nombre) VALUES 
('Quantum eSports');
INSERT INTO patrocinadores (nombre) VALUES 
('Vortex Ventures');
INSERT INTO patrocinadores (nombre) VALUES 
('ThunderByte Technologies');
INSERT INTO patrocinadores (nombre) VALUES 
('PhoenixRise Corporation');
INSERT INTO patrocinadores (nombre) VALUES 
('TitanTech Innovations');
INSERT INTO patrocinadores (nombre) VALUES 
('Apex Alliance');
INSERT INTO patrocinadores (nombre) VALUES 
('SpectraSphere Gaming');
INSERT INTO patrocinadores (nombre) VALUES 
('Ignite Impact');
INSERT INTO patrocinadores (nombre) VALUES 
('VelocityVision');
INSERT INTO patrocinadores (nombre) VALUES 
('Zenith eSports');
INSERT INTO patrocinadores (nombre) VALUES 
('FusionForce Enterprises');
INSERT INTO patrocinadores (nombre) VALUES 
('AlphaStrike Solutions');
INSERT INTO patrocinadores (nombre) VALUES 
('Nexus Nexus Corporation');
INSERT INTO patrocinadores (nombre) VALUES 
('OmegaGaming Group');
INSERT INTO patrocinadores (nombre) VALUES 
('BlazeByte Brands');
INSERT INTO patrocinadores (nombre) VALUES 
('CrystalClear Sponsorship');


/*Patrocinadores_equipo*/
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,2);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,15);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,5);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,1);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,11);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,4);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(3,12);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(3,10);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,20);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,12);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,14);

/*Juegos*/
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('lol','Riot','10/10/2010');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('Minecraft','Mojang','18/07/2012');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('CSGO','Valve','11/12/2005');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('Valorant','Riot','14/04/2020');


/*Competicion*/
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 1','25/04/2020','25/05/2020',0,null,1);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 2','20/10/2017','20/11/2017',0,null,2);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 3','20/10/2019','20/10/2019',0,null,3);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 4','15/08/2015','10/09/2015',0,null,4);


/*Equipo_competicion*/
insert into equipo_competicion (cod_equipo,cod_competicion)values(1,1);
insert into equipo_competicion (cod_equipo,cod_competicion)values(2,1);
insert into equipo_competicion (cod_equipo,cod_competicion)values(3,1);
insert into equipo_competicion (cod_equipo,cod_competicion)values(4,1);
insert into equipo_competicion (cod_equipo,cod_competicion)values(2,2);
insert into equipo_competicion (cod_equipo,cod_competicion)values(3,2);