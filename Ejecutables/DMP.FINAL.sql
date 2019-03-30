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
-- Table structure for table `enfermedades`
--

DROP TABLE IF EXISTS enfermedades;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE enfermedades (
  idEnfermedad int(11) NOT NULL AUTO_INCREMENT,
  enfermedad varchar(45) DEFAULT NULL,
  enfermedadSolicitud varchar(45) DEFAULT NULL,
  PRIMARY KEY (idEnfermedad)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedades`
--

INSERT INTO enfermedades VALUES (1,'Diabetes',NULL),(2,'Hipertension',NULL),(3,'Leucemia',NULL),(4,'Obesidad',NULL);

--
-- Table structure for table `especialistas`
--

DROP TABLE IF EXISTS especialistas;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE especialistas (
  usuario varchar(20) DEFAULT NULL,
  idMatricula varchar(45) DEFAULT NULL,
  nombre varchar(45) DEFAULT NULL,
  apellido varchar(45) DEFAULT NULL,
  KEY usuario (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialistas`
--

INSERT INTO especialistas VALUES ('Jeremias','0001','Gerardo','Staldeker');

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

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS mensajes;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE mensajes (
  usuario varchar(20) DEFAULT NULL,
  mensaje varchar(300) DEFAULT NULL,
  mensajeDe varchar(45) DEFAULT NULL,
  fecha varchar(45) DEFAULT NULL,
  KEY usuario (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

INSERT INTO mensajes VALUES ('Jeremias','Hola paciente Jeremias.','Gerardo Staldeker','8/3/2019 15:55:50');

--
-- Table structure for table `recomendaciones`
--

DROP TABLE IF EXISTS recomendaciones;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE recomendaciones (
  GlucemiaAlto longtext,
  GlucemiaBajo longtext,
  PresionAlto longtext,
  PresionBajo longtext,
  GlobulosBlancosAlto longtext,
  GlobulosBlancosBajo longtext,
  GlobulosRojosAlto longtext,
  GlobulosRojosBajo longtext,
  TemperaturaAlto longtext,
  TemperaturaBajo longtext,
  GlucemiaNormal longtext,
  PresionNormal longtext,
  GlobulosRojosNormal longtext,
  GlobulosBlancosNormal longtext,
  TemperaturaNormal longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendaciones`
--

INSERT INTO recomendaciones VALUES ('SE RECOMIENDA ACUDIR LO MAS PRONTO POSIBLE A UN MEDICO O GUARDIA MEDICA. La Insulina es el elemento que bajara el nivel de glucosa, lo más rápido posible. También puede reducir los niveles, tomando mucha agua, con caminata, con actividad física, y cuidándose en las comidas. Hiperglucemia. Eventos que pueden subir el nivel de glucosa: comer comidas altas en calorías. No hacer suficiente actividad física. Olvidarse de tomar sus medicamentos para controlar su diabetes. Tener que lidiar con la enfermedad. El estrés. Las angustias. Shock sorpresivo, como malas noticias.','Comer algún elemento dulce, ej. azúcar, caramelo, miel, gaseosa azucarada, glucosa concentrada. Esperar 10 minutos a que el azúcar actué. Volver a medir la glucosa, y ver si normalizó. La hipoglucemia en la diabetes. Eventos que pueden ocasionar bajo nivel de azúcar en sangre: Saltearse las comidas. No comer lo suficiente a las horas de las comidas o de los tentempiés. Hacer mucho ejercicio o con más intensidad de la habitual sin comer más de lo habitual. Inyectarte demasiada insulina. Darse un baño caliente justo después de inyectarse insulina. Inyectarse la insulina en un músculo en vez de en la capa de grasa que hay debajo de la piel. Inyectarse la insulina en una parte del cuerpo que se usa mucho en el deporte que se vaya a practicar (como en la pierna justo antes de empezar a jugar a fútbol.','SE RECOMIENDA ACUDIR LO MAS PRONTO POSIBLE A UN MEDICO O GUARDIA MEDICA. Para BAJAR la Presión: Si no es hipertenso y la presión arterial se eleva sin ningún otro síntoma se aconseja: Intentar relajarse un poco en un sitio calmo (medite y recree en su mente un lugar que le haya traído mucha paz). Beber un vaso de jugo de naranja natural, esperar durante 1 hora para medir la presión de nuevo. Si siente síntomas como dolor de cabeza muy fuerte, mareo y visión borrosa se debe: Tratar de evitar situaciones de Stress, Angustia, y alteraciones de enojo. Tomar el medicamento indicado por el cardiólogo. Acudir a la emergencia hospitalaria, debido a que en algunas situaciones la aparición de estos síntomas puede indicar la presencia de un ACV o un infarto.','¿Cómo detectar si se le bajo la Presión? (se recomienda una medición). Pero estos son síntomas de presión arterial baja: debilidad., Fatiga. Somnolencia, Sensación de debilidad, Sudor más del normal, Náuseas, Palpitaciones (si la presión arterial baja es consecuencia de una afección cardíaca), Fiebre o escalofríos (si la presión arterial baja es consecuencia de una infección), Diabetes, Embarazo. Medicamentos como los ansiolíticos o diuréticos. Exposición a altas temperaturas. Alcohol,	Deshidratación, Problemas del hígado, Vómitos o diarrea, Hemorragias, Arritmia cardíaca, Infección en la sangre, Anafilaxis, Estar acostado durante mucho tiempo, Desmayo, Vértigo, Visión borrosa, Somnolencia, Debilidad, Dolor de cabeza. Remedios caseros para subir la tensión: Beber mucha agua. Hidratarse es clave para mantener estable la tensión arterial. Quizás beber sólo agua te resulte pesado, por lo que también puedes hidratarte con té, infusiones, caldos, zumos, etc. Además, hay muchos alimentos que contienen agua como la sandía, el coco, la manzana, etc.','SE RECOMIENDA ACUDIR LO MAS PRONTO POSIBLE A UN MEDICO O GUARDIA MEDICA.Para bajar los leucocitos de forma natural se puede comer fruta o preparar jugos con ellos, especialmente el limón, la naranja, el pomelo, la lima y la mandarina. Comer zanahoria gracias a su contenido de Beta caroteno. 2 o 3 dientes de ajo diarios ya que es el alimento más completo e ideal para bajar los leucocitos de forma natural. El ajo es muy popular como remedio casero para mejorar la circulación y las enfermedades cardiovasculares, controlar la diabetes, para perder peso, prevenir la retención de líquidos, favorecer la digestión, entre muchas otras alteraciones.','Una medición BAJA de Leucocitos, genera: Problemas en el funcionamiento de la médula ósea, bien sea por tumores, fibrosis o intoxicación. También Enfermedades autoinmunes, como el Lupus. O Problemas a nivel del hígado y los riñones. O Exposición a la radiación. Y-o-Presencia de sustancia citotóxicas. Para SUBIR LOS GLOBULOS BLANCOS: ES ideal comenzar el día con un buen desayuno, beber más de dos litros de agua diarios, eliminar los fritos, consumir pescado dos a tres veces por semana, incorporar ácidos grasos omega 3 y 6, consumir vitamina C, que aumenta la inmunidad de la mucosa y vitamina B (legumbres).','Para reducir el nivel de Hematíes. Consumir: Té verde luego de cada comida. Pimiento cayena, dado que estimula la circulación de la sangre y ayuda a que esta se adelgace. Dientes de ajo crudos, cuyas propiedades anticoagulantes ayudan en el tratamiento contra la policitemia','SE RECOMIENDA ACUDIR LO MAS PRONTO POSIBLE A UN MEDICO O GUARDIA MEDICA.El médico investigará cuál es la 	causa de la anemia, que puede tener un origen 	banal (lo cual es frecuente) o peligroso, como es el caso de la leucemia. Síntomas: el principal es el estado de cansancio, además puede haber lesiones en el 	corazón, en el cerebro y en otros órganos del cuerpo. MÉDULA ÓSEA. Los glóbulos rojos se producen en la médula ósea, tejido esponjoso que se encuentra en el interior de los huesos. Los glóbulos blancos y las plaquetas también se producen en la médula ósea. Para subir la cantidad de Glóbulos Rojos= Incorporar: Ácido fólico, también conocido como VITAMINA B9, que encontramos en productos como panes enriquecidos y cereales, verduras de hojas verdes, frijoles secos, judías y frutos secos. VITAMINA B12, encontrada en alimentos como el hígado de res, las carnes rojas, los huevos, la leche y sus derivados, los pescados, los cereales para desayuno y las levaduras nutricionales. HIERRO, que encontramos en alimentos como las carnes rojas, órganos como riñón e hígado, frijoles, lentejas, vegetales de hoja verde, frutos secos y yemas de huevo. Origen de anemias: Los diferentes tipos de anemias: Anemias FERROPENICAS, originadas por una falta de hierro, aumento de pérdidas de sangre (mucha menstruación, sangrado digestivo, sangre en orina). También, de la necesidad de hierro del propio cuerpo, motivado por circunstancias pasajeras: es el caso de un embarazo, la lactancia, el proceso de crecimiento, etcétera. Otra causa de anemias es la disminución en absorción intestinal de pacientes operados del estómago. También el caso de pacientes 	padeciendo procesos de diarrea u otras enfermedades del aparato digestivo que 	‘gasten’ una cantidad inusitada de sangre. La anemia ferropénica puede venir derivada también de una alimentación escasa y/o de una dieta pobre en proteínas.Las TALASEMIAS –un segundo grupo de anemias –o hemoglobinopatías, son formas originadas por una hemoglobina es defectuosa que no transporta adecuadamente el oxígeno. Es una enfermedad hereditaria genética, por lo que en estos tiempos los 	modernos exámenes de genoma podrán aportar previsiones. La APLASIA MEDULAR (alteración en la síntesis y maduración de los precursores hematopoyéticos, con la consiguiente pancitopenia: anemia, leucopenia y trombocitopenia) es un problema de la médula ','SE RECOMIENDA ACUDIR LO MAS PRONTO POSIBLE A UN MEDICO O GUARDIA MEDICA.En niños, esto no siempre es señal de enfermedad, ya que también puede ser provocada por el calor, exceso de ropa, el nacimiento de los dientes o como reacción a una vacuna. Como BAJARLA: con baños en agua templada a no más de 36º. Con paños húmedos con agua, o combinación de jugo de Limón diluido en agua, en la frente, en la nuca, en las axilas, en la ingle. Retirar el exceso de ropa; beber líquidos, que pueden ser leche (en el caso de los bebés) o agua. En medicamentos de venta libre se indican antipiréticos, Dipirona, Ibuprofeno, paracetamol. El medico también puede recomendar algún antibiótico, en caso de infección bacteriana. ACUDA INMEDIATAMENTE AL MEDICO: cuando la fiebre ocurre debido a una infección por un virus, hongo o bacteria, en estas situaciones lo más común es que la fiebre surja de forma repentina y alta, y no cede con las medidas caseras. ','Como subir la fiebre corporal: Colocando paños humedecidos en agua caliente, sobre la frente, o la nuca. Abrigarse con todo tipo de prendas térmicas o con forro, tomar comidas y líquidos muy calientes, ya sean caldos, infusiones, cremas, guisos, todo tipo de comida rica en vitamina B, etc.','CONTINÚA CUIDANDO TU SALUD. TU ERES EL UNICO QUE PUEDE HACERLO POR TI MISMO.','CONTINÚA CUIDANDO TU SALUD. TU ERES EL UNICO QUE PUEDE HACERLO POR TI MISMO.','CONTINÚA CUIDANDO TU SALUD. TU ERES EL UNICO QUE PUEDE HACERLO POR TI MISMO.','CONTINÚA CUIDANDO TU SALUD. TU ERES EL UNICO QUE PUEDE HACERLO POR TI MISMO.','CONTINÚA CUIDANDO TU SALUD. TU ERES EL UNICO QUE PUEDE HACERLO POR TI MISMO.');

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

--
-- Table structure for table `vacunas`
--

DROP TABLE IF EXISTS vacunas;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE vacunas (
  usuario varchar(20) DEFAULT NULL,
  vacuna varchar(100) DEFAULT NULL,
  KEY usuario_idx (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacunas`
--

INSERT INTO vacunas VALUES ('Jeremias','BCG'),('Jeremias','Hepatitis B'),('Jeremias','Neumococo Conjugada'),('Jeremias','Pentavalente'),('Jeremias','Poliovirus Inactiva'),('Jeremias','Poliovirus Oral'),('Jeremias','Rotavirus');

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
