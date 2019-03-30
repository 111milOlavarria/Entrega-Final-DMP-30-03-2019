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
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS historial;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE historial (
  usuario varchar(20) DEFAULT NULL,
  enfermedad varchar(45) DEFAULT NULL,
  nombreValor varchar(45) DEFAULT NULL,
  valor float DEFAULT NULL,
  resultado varchar(45) DEFAULT NULL,
  recomendacion varchar(45) DEFAULT NULL,
  vacuna varchar(100) DEFAULT NULL,
  fecha date DEFAULT NULL,
  KEY usuario_idx (usuario),
  CONSTRAINT usuario FOREIGN KEY (usuario) REFERENCES usuarios (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

INSERT INTO historial VALUES ('Jeremias','Ninguna','Glucemia',80,'Normal',NULL,NULL,'2019-03-08'),('Jeremias','Ninguna','Presion',12.9,'Normal',NULL,NULL,'2019-03-08'),('Jeremias','Ninguna','Globulos Blancos',4000,'Normal Bajo',NULL,NULL,'2019-03-08'),('Jeremias','Ninguna','Globulos Rojos',5000000,'Normal',NULL,NULL,'2019-03-08'),('Jeremias','Ninguna','Temperatura',36,'Normal',NULL,NULL,'2019-03-08');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
