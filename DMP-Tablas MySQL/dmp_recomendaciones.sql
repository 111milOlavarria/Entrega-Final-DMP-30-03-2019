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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
