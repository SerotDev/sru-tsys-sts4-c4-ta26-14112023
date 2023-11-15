DROP DATABASE IF EXISTS C4_TA26_PT3;
CREATE DATABASE C4_TA26_PT3;
USE C4_TA26_PT3;

CREATE TABLE cajeros(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nom_apels VARCHAR(255)
);

CREATE TABLE productos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100),
	precio INT
);

CREATE TABLE maquinas_registradoras(
	id INT AUTO_INCREMENT PRIMARY KEY,
	piso INT
);

CREATE TABLE asignado_a(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_cajero INT,
	id_maquina INT,
	id_producto INT,
	FOREIGN KEY (id_cajero) REFERENCES cajeros (id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_maquina) REFERENCES maquinas_registradoras (id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_producto) REFERENCES productos (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cajeros (nom_apels) VALUES
('Sergi Rodriguez Utge'),
('Nerea Prados Mata'),
('Miguel Rodriguez Martinez'),
('Maria Lopez Fernandez'),
('Carlos Martinez Ruiz'),
('Laura Sanchez Perez'),
('Pedro Ramirez Gomez'),
('Isabel Jimenez Martin');

INSERT INTO productos (nombre, precio) VALUES
('Producto1', 10),
('Producto2', 15),
('Producto3', 20),
('Producto4', 25),
('Producto5', 30),
('Producto6', 35),
('Producto7', 40),
('Producto8', 45);

INSERT INTO maquinas_registradoras (piso) VALUES
(1),
(2),
(1),
(3),
(2),
(3),
(1),
(2);

INSERT INTO asignado_a (id_cajero, id_maquina, id_producto) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 1, 4),
(5, 2, 5),
(6, 3, 6),
(7, 1, 7),
(8, 2, 8);