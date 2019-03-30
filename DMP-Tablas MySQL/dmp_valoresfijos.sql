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
-- Table structure for table `valoresfijos`
--

DROP TABLE IF EXISTS valoresfijos;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE valoresfijos (
  PresionMax float DEFAULT NULL,
  PresionMin float DEFAULT NULL,
  GlucemiaMax float DEFAULT NULL,
  GlucemiaMin float DEFAULT NULL,
  globulosBlancosMax float DEFAULT NULL,
  globulosBlancosMin float DEFAULT NULL,
  globulosRojosMax float DEFAULT NULL,
  globulosRojosMin float DEFAULT NULL,
  colesterolMax float DEFAULT NULL,
  colesterolMin float DEFAULT NULL,
  trigliceridosMax float DEFAULT NULL,
  trigliceridosMin float DEFAULT NULL,
  acidoUricoMax float DEFAULT NULL,
  acidoUricoMin float DEFAULT NULL,
  uremiaMax float DEFAULT NULL,
  uremiaMin float DEFAULT NULL,
  creatininaMax float DEFAULT NULL,
  creatininaMin float DEFAULT NULL,
  iptMax float DEFAULT NULL COMMENT 'Ionograma plasmatico',
  iptMin float DEFAULT NULL COMMENT 'Ionograma plasmatico',
  tgoMax float DEFAULT NULL COMMENT 'Transaminasa Glutamico Oxalecetica',
  tgoMin float DEFAULT NULL COMMENT 'Transaminasa Glutamico Oxalecetica',
  tgpMax float DEFAULT NULL COMMENT 'Transaminasa Glutamico Piruvica',
  tgpMin float DEFAULT NULL COMMENT 'Transaminasa Glutamico Piruvica',
  faMax float DEFAULT NULL COMMENT 'Fosfatasa Alcalina',
  faMin float DEFAULT NULL COMMENT 'Fosfatasa Alcalina',
  plaquetasMax float DEFAULT NULL,
  plaquetasMin float DEFAULT NULL,
  ppmMax float DEFAULT NULL,
  ppmMin float DEFAULT NULL,
  hemoglobinaMax float DEFAULT NULL,
  hemoglobinaMin float DEFAULT NULL,
  hierroMax float DEFAULT NULL,
  hierroMin float DEFAULT NULL,
  TemperaturaMax float DEFAULT NULL,
  TemperaturaMin float DEFAULT NULL,
  enfermedadesPadecidas varchar(45) DEFAULT NULL,
  recomendaciones varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoresfijos`
--

INSERT INTO valoresfijos VALUES (13.8,9.6,120,60,11000,4000,6000000,4500000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,39.5,35.5,NULL,NULL);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
