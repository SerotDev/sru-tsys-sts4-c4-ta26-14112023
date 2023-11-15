DROP DATABASE IF EXISTS C4_TA26_PT1;
CREATE DATABASE C4_TA26_PT1;
USE C4_TA26_PT1;

CREATE TABLE proveedores(
	id VARCHAR(4) PRIMARY KEY,
	nombre VARCHAR(100)
);

CREATE TABLE piezas(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100)
);

CREATE TABLE suministra(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_pieza INT,
	id_proveedor VARCHAR(4),
	precio INT,
	CONSTRAINT suministra_piezas_fk FOREIGN KEY (id_pieza) REFERENCES piezas (id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT suministra_proveedores_fk FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO proveedores (id, nombre) VALUES
('P001', 'Proveedor1'),
('P002', 'Proveedor2'),
('P003', 'Proveedor3'),
('P004', 'Proveedor4'),
('P005', 'Proveedor5'),
('P006', 'Proveedor6'),
('P007', 'Proveedor7'),
('P008', 'Proveedor8');

INSERT INTO piezas (nombre) VALUES
('PiezaA'),
('PiezaB'),
('PiezaC'),
('PiezaD'),
('PiezaE'),
('PiezaF'),
('PiezaG'),
('PiezaH');

INSERT INTO suministra (id_pieza, id_proveedor, precio) VALUES
(1, 'P001', 10),
(2, 'P002', 15),
(3, 'P003', 20),
(4, 'P004', 25),
(5, 'P005', 30),
(6, 'P006', 35),
(7, 'P007', 40),
(8, 'P008', 45);