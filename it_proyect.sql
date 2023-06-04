-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2023 a las 13:35:34
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS `it_proyect`;
CREATE DATABASE `it_proyect` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `it_proyect`;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `it_proyect`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivos`
--

CREATE TABLE `archivos` (
  `IdArchivo` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL,
  `Documento` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE `envio` (
  `IdEnvio` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  `IdForo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `envio`
--

INSERT INTO `envio` (`IdEnvio`, `IdPersona`, `IdForo`) VALUES
(1, 2, 1),
(2, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foro`
--

CREATE TABLE `foro` (
  `IdForo` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `foro`
--

INSERT INTO `foro` (`IdForo`, `IdProyecto`, `Descripcion`) VALUES
(1, 1, 'Descripcion foro 1'),
(5, 2, 'Foro 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe`
--

CREATE TABLE `informe` (
  `IdInforme` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL,
  `Documento` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `IdMensaje` int(11) NOT NULL,
  `IdEnvio` int(11) NOT NULL,
  `Contenido` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`IdMensaje`, `IdEnvio`, `Contenido`) VALUES
(1, 1, 'Holis'),
(2, 1, 'Buenos dias'),
(3, 2, 'fnksdj');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participacion`
--

CREATE TABLE `participacion` (
  `IdParticipacion` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  `IdProyecto` int(11) NOT NULL,
  `IdRol` int(11) NOT NULL,
  `Cuota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `participacion`
--

INSERT INTO `participacion` (`IdParticipacion`, `IdPersona`, `IdProyecto`, `IdRol`, `Cuota`) VALUES
(3, 2, 1, 2, 25),
(4, 2, 2, 1, 50),
(5, 3, 3, 3, 100),
(6, 3, 1, 1, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `IdPersona` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Admin` tinyint(1) NOT NULL DEFAULT 0,
  `Usuario` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`IdPersona`, `Nombre`, `Apellidos`, `DNI`, `Admin`, `Usuario`, `Password`) VALUES
(2, 'María', 'García', '23456789B', 1, 'maria.garcia', '5678'),
(3, 'Pedro', 'Sánchez', '34567890C', 0, 'pedro.sanchez', '9012'),
(5, 'Juan', 'Pérez', '12345678D', 0, 'juan.perez', 'juan'),
(7, 'Maria', 'Perula', '12345678L', 1, 'maria.perula', 'maria.perula');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `IdProyecto` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `Descripcion` varchar(255) NOT NULL,
  `IdForo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`IdProyecto`, `Nombre`, `FechaInicio`, `FechaFin`, `Descripcion`, `IdForo`) VALUES
(1, 'Proyecto A', '2023-05-01', '2023-06-30', 'Descripci√≥n del proyecto A kjfsd', 1),
(2, 'Proyecto B', '2023-06-01', '2023-07-31', 'Descripci√≥n del proyecto B', 5),
(3, 'Proyecto C', '2023-07-01', '2023-08-31', 'Descripción del proyecto C', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `IdRol` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Acceso` int(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`IdRol`, `Nombre`, `Descripcion`, `Acceso`) VALUES
(1, 'Rol 1', 'Descripción del rol 1', 1),
(2, 'Rol 2', 'Descripción del rol 2', 0),
(3, 'Rol 3', 'Descripción del rol 3', 0),
(4, 'Rol 4', 'Descripcion Rol 4 nueva', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE `tarea` (
  `IdTarea` int(11) NOT NULL,
  `IdParticipacion` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  `Completado` tinyint(1) NOT NULL DEFAULT 0,
  `IdTareaPredecesora` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`IdTarea`, `IdParticipacion`, `Nombre`, `Descripcion`, `FechaInicio`, `FechaFin`, `Completado`, `IdTareaPredecesora`) VALUES
(6, 4, 'Tarea 6', 'Descripción de la tarea 6', '2023-06-16', '2023-06-30', 0, NULL),
(7, 5, 'Tarea 7', 'Descripción de la tarea 7', '2023-07-01', '2023-07-15', 0, NULL),
(9, 3, '*', 'NJKFSD', '2022-12-12', '2023-12-12', 1, NULL),
(11, 3, 'T3', 'NFJDSKFNKN', '2022-12-12', '2023-12-12', 0, NULL),
(12, 3, 'Tarea Prueba', 'nKJSFDKN', '2022-12-12', '2023-12-12', 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `archivos`
--
ALTER TABLE `archivos`
  ADD PRIMARY KEY (`IdArchivo`),
  ADD KEY `archivos_proyecto_fk` (`IdProyecto`);

--
-- Indices de la tabla `envio`
--
ALTER TABLE `envio`
  ADD PRIMARY KEY (`IdEnvio`),
  ADD KEY `envio_persona_fk` (`IdPersona`),
  ADD KEY `envio_foro_fk` (`IdForo`);

--
-- Indices de la tabla `foro`
--
ALTER TABLE `foro`
  ADD PRIMARY KEY (`IdForo`),
  ADD KEY `foro_proyecto_fk` (`IdProyecto`);

--
-- Indices de la tabla `informe`
--
ALTER TABLE `informe`
  ADD PRIMARY KEY (`IdInforme`),
  ADD KEY `informe_proyecto_fk` (`IdProyecto`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`IdMensaje`),
  ADD KEY `mensaje_envio_fk` (`IdEnvio`);

--
-- Indices de la tabla `participacion`
--
ALTER TABLE `participacion`
  ADD PRIMARY KEY (`IdParticipacion`),
  ADD KEY `participacion_persona_fk` (`IdPersona`),
  ADD KEY `participacion_rol_fk` (`IdRol`),
  ADD KEY `participacion_proyecto_fk` (`IdProyecto`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`IdPersona`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`IdProyecto`),
  ADD UNIQUE KEY `IdForo` (`IdForo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`IdRol`);

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`IdTarea`),
  ADD KEY `tarea_participacion_fk` (`IdParticipacion`),
  ADD KEY `tarea_tarea_fk` (`IdTareaPredecesora`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivos`
--
ALTER TABLE `archivos`
  MODIFY `IdArchivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `envio`
--
ALTER TABLE `envio`
  MODIFY `IdEnvio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `foro`
--
ALTER TABLE `foro`
  MODIFY `IdForo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `informe`
--
ALTER TABLE `informe`
  MODIFY `IdInforme` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `IdMensaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `participacion`
--
ALTER TABLE `participacion`
  MODIFY `IdParticipacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `IdPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `IdProyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `IdRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `IdTarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `archivos`
--
ALTER TABLE `archivos`
  ADD CONSTRAINT `archivos_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `envio`
--
ALTER TABLE `envio`
  ADD CONSTRAINT `envio_foro_fk` FOREIGN KEY (`IdForo`) REFERENCES `foro` (`IdForo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `envio_persona_fk` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `foro`
--
ALTER TABLE `foro`
  ADD CONSTRAINT `foro_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `informe`
--
ALTER TABLE `informe`
  ADD CONSTRAINT `informe_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_envio_fk` FOREIGN KEY (`IdEnvio`) REFERENCES `envio` (`IdEnvio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `participacion`
--
ALTER TABLE `participacion`
  ADD CONSTRAINT `participacion_persona_fk` FOREIGN KEY (`IdPersona`) REFERENCES `persona` (`IdPersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participacion_proyecto_fk` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participacion_rol_fk` FOREIGN KEY (`IdRol`) REFERENCES `rol` (`IdRol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `proyecto_foro_fk` FOREIGN KEY (`IdForo`) REFERENCES `foro` (`IdForo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_participacion_fk` FOREIGN KEY (`IdParticipacion`) REFERENCES `participacion` (`IdParticipacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tarea_tarea_fk` FOREIGN KEY (`IdTareaPredecesora`) REFERENCES `tarea` (`IdTarea`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
