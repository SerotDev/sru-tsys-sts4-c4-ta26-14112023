DROP DATABASE IF EXISTS C4_TA26_PT2;
CREATE DATABASE C4_TA26_PT2;
USE C4_TA26_PT2;

CREATE TABLE cientificos(
	dni VARCHAR(8) PRIMARY KEY,
	nom_apels VARCHAR(255)
);

CREATE TABLE proyectos(
	id VARCHAR(4) PRIMARY KEY,
	nombre VARCHAR(255),
	horas INT
);

CREATE TABLE asignado_a(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dni_cientifico VARCHAR(8),
	id_proyecto VARCHAR(4),
	FOREIGN KEY (dni_cientifico) REFERENCES cientificos (dni) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_proyecto) REFERENCES proyectos (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla cientificos
INSERT INTO cientificos (dni, nom_apels) VALUES
('1234567A', 'Sergi Rodriguez Utge'),
('2345678A', 'Nerea Prados Mata'),
('3456789A', 'Miguel Rodriguez Martinez'),
('4567890A', 'Maria Lopez Fernandez'),
('5678901A', 'Carlos Martinez Ruiz'),
('6789012A', 'Laura Sanchez Perez'),
('7890123A', 'Pedro Ramirez Gomez'),
('8901234A', 'Isabel Jimenez Martin');

-- Tabla proyectos
INSERT INTO proyectos (id, nombre, horas) VALUES
('P001', 'Proyecto de Investigacion', 100),
('P002', 'Proyecto de Desarrollo', 150),
('P003', 'Proyecto de Innovación', 200),
('P004', 'Proyecto de Estudio', 120),
('P005', 'Proyecto de Tecnología', 180),
('P006', 'Proyecto de Ciencia', 130),
('P007', 'Proyecto de Medio Ambiente', 160),
('P008', 'Proyecto de Salud', 140);

-- Tabla asignado_a
INSERT INTO asignado_a (dni_cientifico, id_proyecto) VALUES
('1234567A', 'P001'),
('2345678A', 'P002'),
('3456789A', 'P003'),
('4567890A', 'P004'),
('5678901A', 'P005'),
('6789012A', 'P006'),
('7890123A', 'P007'),
('8901234A', 'P008');