-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 30-06-2022 a las 23:47:12
-- Versión del servidor: 5.7.28
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `latienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `CUIT` varchar(11) COLLATE utf8_bin NOT NULL,
  `ApyNom` varchar(50) COLLATE utf8_bin NOT NULL,
  `idcondiciontributaria` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `condiciontributaria` (`idcondiciontributaria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `CUIT`, `ApyNom`, `idcondiciontributaria`) VALUES
(1, '0', 'Anonimo', 5),
(2, '20267825055', 'Cristian Aparicio', 5),
(3, '22295123209', 'Raul Ramirez', 2),
(4, '285223569', 'Britney Spears', 4),
(5, '25235008368', 'Bradley Cooper', 3),
(6, '20298365294', 'Guadalupe Luna', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `color`
--

DROP TABLE IF EXISTS `color`;
CREATE TABLE IF NOT EXISTS `color` (
  `idColor` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idColor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `color`
--

INSERT INTO `color` (`idColor`, `descripcion`) VALUES
(1, 'Verde'),
(2, 'Azul'),
(3, 'Negro'),
(4, 'Amarillo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE IF NOT EXISTS `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idempleado` int(11) NOT NULL,
  `idproveedor` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idproveedor` (`idproveedor`),
  KEY `idempleado` (`idempleado`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
CREATE TABLE IF NOT EXISTS `comprobante` (
  `idComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idComprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `comprobante`
--

INSERT INTO `comprobante` (`idComprobante`, `descripcion`) VALUES
(1, 'Factura A'),
(2, 'Factura B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condiciontributaria`
--

DROP TABLE IF EXISTS `condiciontributaria`;
CREATE TABLE IF NOT EXISTS `condiciontributaria` (
  `idcondiciontributaria` int(11) NOT NULL,
  `idComprobante` int(15) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idcondiciontributaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `condiciontributaria`
--

INSERT INTO `condiciontributaria` (`idcondiciontributaria`, `idComprobante`, `descripcion`) VALUES
(1, 1, 'Responsable Inscripto'),
(2, 1, 'Monotributo'),
(3, 2, 'Exento'),
(4, 2, 'No Responsable'),
(5, 2, 'Consumidor Final');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
CREATE TABLE IF NOT EXISTS `detalleventa` (
  `iddetalleventa` int(50) NOT NULL AUTO_INCREMENT,
  `idventa` int(15) NOT NULL,
  `cantidad` int(50) NOT NULL,
  `precioVenta` double(10,2) NOT NULL,
  `idstock` int(11) NOT NULL,
  PRIMARY KEY (`iddetalleventa`),
  KEY `idventa` (`idstock`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`iddetalleventa`, `idventa`, `cantidad`, `precioVenta`, `idstock`) VALUES
(10, 19, 1, 7274.52, 1),
(11, 20, 1, 7274.52, 6),
(12, 21, 3, 7274.52, 6),
(13, 21, 3, 1452.00, 2),
(14, 22, 3, 1452.00, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `idempleado` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `Apellido` varchar(50) COLLATE utf8_bin NOT NULL,
  `DNI` varchar(8) COLLATE utf8_bin NOT NULL,
  `Domiciilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `idSucursal` (`idSucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `Nombre`, `Apellido`, `DNI`, `Domiciilio`, `Telefono`, `idSucursal`) VALUES
(1, 'Ramiro', 'Neder', '30268712', 'Esteban Echeverría 164', 3814982227, 1),
(2, 'Aldo', 'Cocheri', '28410321', 'Jujuy 303', 3815341056, 2),
(3, 'Flores', 'Claudia', '33580531', 'Marcos 3600', 3812580321, 2),
(4, 'Leandro', 'Iguzquiza', '35410321', 'Santiago 4200', 3815483021, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`idMarca`, `descripcion`) VALUES
(1, 'Adidas'),
(2, 'Lacoste'),
(3, 'La Argentina'),
(4, 'Nike'),
(5, 'Reebok'),
(6, 'Puma'),
(8, 'Raider'),
(10, 'Tommy Hilfiger'),
(11, 'Topper'),
(12, 'Bando'),
(24, 'Wrangler'),
(25, 'Montagne'),
(26, 'Pampero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `idPago` double NOT NULL AUTO_INCREMENT,
  `Monto` varchar(45) COLLATE utf8_bin NOT NULL,
  `idventa` int(11) NOT NULL,
  `formaPago` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `idventa` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  `costo` double(8,2) NOT NULL,
  `margenGanancia` decimal(5,2) NOT NULL,
  `IVA` decimal(5,2) NOT NULL,
  `netoGravado` double(8,2) NOT NULL,
  `idrubro` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idStock` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `rubro` (`idrubro`),
  KEY `marca` (`idMarca`),
  KEY `idStock` (`idStock`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `descripcion`, `costo`, `margenGanancia`, `IVA`, `netoGravado`, `idrubro`, `idMarca`, `idStock`) VALUES
(4, 'Algodon Pima', 5010.00, '20.00', '21.00', 6012.00, 3, 2, 10),
(5, 'Camisa Hawaiana', 1000.00, '20.00', '21.00', 1200.00, 2, 3, 15),
(6, 'Pantalon Corto', 5000.00, '20.00', '21.00', 6000.00, 4, 4, 20),
(7, 'Galaxy 5', 6000.00, '20.00', '21.00', 7260.00, 1, 1, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productocolor`
--

DROP TABLE IF EXISTS `productocolor`;
CREATE TABLE IF NOT EXISTS `productocolor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idproducto` int(11) NOT NULL,
  `idColor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idproducto` (`idproducto`),
  KEY `idColor` (`idColor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `productocolor`
--

INSERT INTO `productocolor` (`id`, `idproducto`, `idColor`) VALUES
(1, 4, 1),
(2, 4, 4),
(3, 4, 3),
(4, 4, 2),
(5, 5, 1),
(7, 10, 1),
(8, 10, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productotalle`
--

DROP TABLE IF EXISTS `productotalle`;
CREATE TABLE IF NOT EXISTS `productotalle` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `idproducto` int(11) NOT NULL,
  `Ntalle` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idproducto` (`idproducto`),
  KEY `Ntalle` (`Ntalle`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `productotalle`
--

INSERT INTO `productotalle` (`id`, `idproducto`, `Ntalle`) VALUES
(12, 4, 1),
(13, 5, 1),
(14, 5, 2),
(16, 5, 3),
(17, 6, 1),
(18, 6, 2),
(19, 7, 7),
(20, 7, 8),
(21, 7, 9),
(23, 6, 3),
(24, 6, 4),
(25, 4, 2),
(26, 7, 10),
(27, 7, 11),
(28, 7, 12),
(29, 4, 3),
(30, 5, 4),
(31, 4, 4),
(32, 7, 13),
(34, 9, 2),
(35, 5, 4),
(36, 5, 4),
(40, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `RazonSocial` varchar(45) COLLATE utf8_bin NOT NULL,
  `idproducto` int(11) NOT NULL,
  PRIMARY KEY (`idproveedor`),
  KEY `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubro`
--

DROP TABLE IF EXISTS `rubro`;
CREATE TABLE IF NOT EXISTS `rubro` (
  `idrubro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idrubro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `rubro`
--

INSERT INTO `rubro` (`idrubro`, `descripcion`) VALUES
(1, 'Zapatillas'),
(2, 'Camisas'),
(3, 'Remeras'),
(4, 'Short');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `idStock` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `idproducto` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `Ntalle` int(11) NOT NULL,
  `idColor` int(11) NOT NULL,
  PRIMARY KEY (`idStock`),
  KEY `idproducto` (`idproducto`),
  KEY `idSucursal` (`idSucursal`),
  KEY `Ntalle` (`Ntalle`),
  KEY `idColor` (`idColor`),
  KEY `	idproducto` (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`idStock`, `cantidad`, `idproducto`, `idSucursal`, `Ntalle`, `idColor`) VALUES
(1, 9, 4, 1, 1, 1),
(2, 9, 5, 2, 1, 1),
(3, 20, 6, 1, 2, 2),
(4, 29, 6, 1, 8, 4),
(5, 45, 5, 1, 4, 3),
(6, 31, 4, 2, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE IF NOT EXISTS `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) COLLATE utf8_bin NOT NULL,
  `Domicilio` varchar(50) COLLATE utf8_bin NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  PRIMARY KEY (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`idSucursal`, `Descripcion`, `Domicilio`, `Telefono`) VALUES
(1, 'Norte', 'Muñecas 500', 3815982226),
(2, 'Centro', 'Maipu 100', 3815982227);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `talle`
--

DROP TABLE IF EXISTS `talle`;
CREATE TABLE IF NOT EXISTS `talle` (
  `Ntalle` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `talle` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Ntalle`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `talle`
--

INSERT INTO `talle` (`Ntalle`, `descripcion`, `talle`) VALUES
(1, 'Small', 'S'),
(2, 'Medium', 'M'),
(3, 'Large', 'L'),
(4, 'XtraLarge', 'XL'),
(5, 'ExtraSmall', 'XS'),
(6, '2 ExtraLarge', 'XLL'),
(7, '35 Femenino', '35'),
(8, '36 Femenino', '36'),
(9, '36 ½ Femenino', '36 ½'),
(10, '37  Femenino', '37'),
(11, '37 ½  Femenino', '37 ½'),
(12, '38  Femenino', '38'),
(13, '38 ½ Femenino', '38 ½'),
(14, '39 Femenino', '39'),
(15, '39 ½ Femenino', '39 ½'),
(16, '40 Femenino', '40'),
(17, '40 ½ Femenino', '40 ½'),
(18, '41 Femenino', '41'),
(19, '42 Femenino', '42'),
(20, '39 Masculino', '39'),
(21, '39 ½ Masculino', '39 ½'),
(22, '40 Masculino', '40'),
(23, '40 ½ Masculino', '40 ½'),
(24, '41 Masculino', '41'),
(25, '41 ½ Masculino', '41 ½'),
(26, '42 Masculino', '42'),
(27, '42 ½ Masculino', '42 ½'),
(28, '43 Masculino', '43'),
(29, '43 ½ Masculino', '43 ½'),
(30, '44 Masculino', '44'),
(31, '44 ½ Masculino', '44 ½'),
(32, '43 ½ Masculino', '43 ½'),
(33, '44 Masculino', '44'),
(34, '44 ½ Masculino', '44 ½'),
(35, '45 Masculino', '45'),
(36, '46 Masculino', '46'),
(37, '47 Masculino', '47'),
(38, '35 Big Kid 7 a 12', '35'),
(39, '36 Big Kid 7 a 12', '36'),
(40, '37 Big Kid 7 a 12', '37'),
(41, '38 Big Kid 7 a 12', '38'),
(42, '39 Big Kid 7 a 12', '39'),
(43, '27 Little Kid 4 a 7', '27'),
(44, '28 Little Kid 4 a 7', '28'),
(45, '29 Little Kid 4 a 7', '29'),
(46, '30 Little Kid 4 a 7', '30'),
(47, '31 Little Kid 4 a 7', '31'),
(48, '32 Little Kid 4 a 7', '32'),
(49, '33 Little Kid 4 a 7', '33'),
(50, '34 Little Kid 4 a 7', '34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
CREATE TABLE IF NOT EXISTS `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`idTipoUsuario`, `descripcion`) VALUES
(1, 'Administrador'),
(2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `NombreUsuario` varchar(50) COLLATE utf8_bin NOT NULL,
  `Clave` varchar(50) COLLATE utf8_bin NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `idtipousuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `usuario` (`idtipousuario`),
  KEY `empleado` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `NombreUsuario`, `Clave`, `idEmpleado`, `idtipousuario`) VALUES
(1, 'rneder', 'Axr22am2021', 1, 1),
(2, 'acocheri', 'Uxr22am2021', 2, 2),
(3, 'cflores', '123', 3, 1),
(4, 'lIguzquiza', 'Uxr22am2022', 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(15) NOT NULL,
  `fecha` varchar(45) COLLATE utf8_bin NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `CAE` int(15) NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `idCliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idventa`, `idusuario`, `fecha`, `idCliente`, `idComprobante`, `CAE`) VALUES
(19, 4, '2022-03-25', 1, 2, 0),
(20, 2, '2022-03-25', 1, 2, 0),
(21, 2, '2022-03-25', 2, 2, 0),
(22, 2, '2022-03-25', 2, 2, 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idcondiciontributaria`) REFERENCES `condiciontributaria` (`idcondiciontributaria`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_rubro` FOREIGN KEY (`idrubro`) REFERENCES `rubro` (`idrubro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idempleado`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_tipo usuario` FOREIGN KEY (`idtipousuario`) REFERENCES `tipousuario` (`idTipoUsuario`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
