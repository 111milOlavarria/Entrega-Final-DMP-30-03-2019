CREATE DATABASE  IF NOT EXISTS `dmp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `dmp`;
-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: dmp
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS usuarios;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE usuarios (
  idusuarios int(11) NOT NULL AUTO_INCREMENT,
  tipoUsuario int(11) DEFAULT NULL,
  usuario varchar(20) DEFAULT NULL,
  `contraseña` varchar(20) DEFAULT NULL,
  matricula varchar(20) DEFAULT NULL,
  codigoValidacion varchar(100) DEFAULT NULL,
  nombre varchar(60) DEFAULT NULL,
  apellido varchar(60) DEFAULT NULL,
  dni varchar(10) DEFAULT NULL,
  mail varchar(100) DEFAULT NULL,
  direccion varchar(60) DEFAULT NULL,
  telefono varchar(20) DEFAULT NULL,
  sexo varchar(10) DEFAULT NULL,
  edad int(11) DEFAULT NULL,
  peso float DEFAULT NULL,
  altura float DEFAULT NULL,
  fechaNacimiento varchar(10) DEFAULT NULL,
  grupoYFactor varchar(3) DEFAULT NULL,
  imc float DEFAULT NULL,
  especialidad varchar(45) DEFAULT NULL,
  nombreCompania varchar(45) DEFAULT NULL,
  enfermedadPrincipal varchar(45) DEFAULT NULL,
  enfermedadPreexistente varchar(45) DEFAULT NULL,
  mensaje varchar(1000) DEFAULT NULL,
  mensajeFecha date DEFAULT NULL,
  mensajeDe varchar(45) DEFAULT NULL,
  compartirDatos int(11) DEFAULT NULL,
  preguntaClave varchar(100) DEFAULT NULL,
  respuestaClave varchar(45) DEFAULT NULL,
  localidad varchar(45) DEFAULT NULL,
  PRIMARY KEY (idusuarios),
  KEY usuario (usuario)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

INSERT INTO usuarios VALUES (68,2,'medico','123','0001',NULL,'Gerardo','Staldeker','4444444444','staldeker@yahoo.com.ar','25 de Mayo 5345','0228415552271','Masculino',NULL,NULL,NULL,'09/04/1969',NULL,NULL,'Licenciado En Enfermeria',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'¿Cual es el nombre de su mascota?','wilson','Olavarria'),(69,2,'Medico2','123','WASD',NULL,'Medico','Med','444444444','med@gmail.com','25 De Mayo 5345','0228415677678','Masculino',NULL,NULL,NULL,'11/06/1999',NULL,NULL,'Pediatra',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'¿Cual es su color favorito?','rojo','Olavarria'),(70,1,'Jeremias','123',NULL,NULL,'Jeremias','Staldeker','42040309','staldekerjeremias@outlook.com','25 de Mayo 5345','0228415682667','Masculino',19,90,1.89,NULL,'0+',25.1953,NULL,NULL,'Ninguna','Ninguna',NULL,NULL,NULL,1,'¿Cual es su color favorito?','rojo','Olavarria'),(71,3,'investigador','12345',NULL,'WASD',NULL,NULL,NULL,'investigador@gmail.com','null','02284156569586',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Investigaciones SRL',NULL,NULL,NULL,NULL,NULL,NULL,'¿Cual es su color favorito?','rojo',NULL);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
