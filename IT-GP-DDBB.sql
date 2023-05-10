
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS `it_proyect`;
CREATE DATABASE `it_proyect` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `it_proyect`;


CREATE TABLE `persona` (
  `IdPersona` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Admin` tinyint(1) NOT NULL DEFAULT 0,
  `Usuario` varchar(255) NOT NULL UNIQUE KEY,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `proyecto` (
  `IdProyecto` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `Descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `archivos` (
  `IdArchivo` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdProyecto` int(11) NOT NULL,
  `Documento` mediumblob NOT NULL,
  CONSTRAINT `archivos_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `rol` (
  `IdRol` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255),
  `Acceso` int(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `participacion` (
  `IdParticipacion` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdPersona` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL,
  `IdRol` int(11) NOT NULL,
  `Cuota` int(11) NOT NULL,
  CONSTRAINT `participacion_persona_fk` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `participacion_rol_fk` FOREIGN KEY (`IdRol`) REFERENCES `rol` (`IdRol`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `participacion_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `informe` (
  `IdInforme` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdProyecto` int(11) NOT NULL,
  `Documento` mediumblob NOT NULL,
  CONSTRAINT `informe_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `foro` (
  `IdForo` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdProyecto` int(11) NOT NULL,
  `Descripcion` varchar(255),
  CONSTRAINT `foro_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `proyecto` 
ADD COLUMN `IdForo` int(11) NULL,
ADD CONSTRAINT `proyecto_foro_fk` FOREIGN KEY (`IdForo`) REFERENCES `foro` (`IdForo`) ON UPDATE CASCADE ON DELETE CASCADE,
ADD UNIQUE (`IdForo`);

CREATE TABLE `tarea` (
  `IdTarea` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdParticipacion` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255),
  `FechaInicio` date NOT NULL,
  `FechaFin` date,
  `Completado` tinyint(1) NOT NULL DEFAULT 0,
  `IdTareaPredecesora` int(11),
  CONSTRAINT `tarea_participacion_fk` FOREIGN KEY (`IdParticipacion`) REFERENCES `participacion` (`IdParticipacion`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `tarea_tarea_fk` FOREIGN KEY (`IdTareaPredecesora`) REFERENCES `tarea` (`IdTarea`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `envio` (
  `IdEnvio` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdPersona` int(11) NOT NULL,
  `IdForo` int(11) NOT NULL,
  CONSTRAINT `envio_persona_fk` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `envio_foro_fk` FOREIGN KEY (`IdForo`) REFERENCES `foro` (`IdForo`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `mensaje` (
  `IdMensaje` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IdEnvio` int(11) NOT NULL,
  `Contenido` varchar(255) NOT NULL,
  CONSTRAINT `mensaje_envio_fk` FOREIGN KEY (`IdEnvio`) REFERENCES `envio` (`IdEnvio`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO persona (Nombre, Apellidos, DNI, Admin, Usuario, Password) VALUES
('Juan', 'Pérez', '12345678A', 0, 'juan.perez', '1234'),
('María', 'García', '23456789B', 1, 'maria.garcia', '5678'),
('Pedro', 'Sánchez', '34567890C', 0, 'pedro.sanchez', '9012');

INSERT INTO proyecto (Nombre, FechaInicio, FechaFin, Descripcion) VALUES
('Proyecto A', '2023-05-01', '2023-06-30', 'Descripción del proyecto A'),
('Proyecto B', '2023-06-01', '2023-07-31', 'Descripción del proyecto B'),
('Proyecto C', '2023-07-01', '2023-08-31', 'Descripción del proyecto C');

INSERT INTO rol (Nombre, Descripcion, Acceso) VALUES
('Rol 1', 'Descripción del rol 1', 1),
('Rol 2', 'Descripción del rol 2', 0),
('Rol 3', 'Descripción del rol 3', 0);

INSERT INTO participacion (IdPersona, IdProyecto, IdRol, Cuota) VALUES
(1, 1, 1, 50),
(1, 2, 2, 25),
(2, 1, 2, 25),
(2, 2, 1, 50),
(3, 3, 3, 100);

INSERT INTO tarea (IdParticipacion, Nombre, Descripcion, FechaInicio, FechaFin, Completado, IdTareaPredecesora) VALUES
(1, 'Tarea 1', 'Descripción de la tarea 1', '2023-05-01', '2023-05-15', 1, NULL),
(1, 'Tarea 2', 'Descripción de la tarea 2', '2023-05-16', '2023-05-31', 0, 1),
(2, 'Tarea 3', 'Descripción de la tarea 3', '2023-06-01', '2023-06-15', 0, NULL),
(2, 'Tarea 4', 'Descripción de la tarea 4', '2023-06-16', '2023-06-30', 0, 3),
(3, 'Tarea 5', 'Descripción de la tarea 5', '2023-07-01', '2023-07-15', 0, NULL),
(4, 'Tarea 6', 'Descripción de la tarea 6', '2023-06-16', '2023-06-30', 0, NULL),
(5, 'Tarea 7', 'Descripción de la tarea 7', '2023-07-01', '2023-07-15', 0, NULL);