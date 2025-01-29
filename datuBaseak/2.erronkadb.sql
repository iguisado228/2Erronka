-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: 2.erronka
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bezeroa`
--

DROP TABLE IF EXISTS `bezeroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bezeroa` (
  `idBezeroa` int NOT NULL AUTO_INCREMENT,
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(20) NOT NULL,
  `abizena` varchar(45) NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `helbidea` longtext NOT NULL,
  `erabiltzaileIzena` varchar(45) NOT NULL,
  `pasahitza` varchar(20) NOT NULL,
  `helbideElektronikoa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idBezeroa`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bezeroa`
--

LOCK TABLES `bezeroa` WRITE;
/*!40000 ALTER TABLE `bezeroa` DISABLE KEYS */;
INSERT INTO `bezeroa` VALUES (1,'12345678A','Jon','Etxebarria','600123456','Calle Mayor 1, Bilbao','jonetxe','P@ssw0rd1','jetxebarria@gmail.com'),(2,'23456789B','Amaia','Goikoetxea','600234567','Calle Los Álamos 4, Donostia','amaiagoi','Amaia!123','agoikoetxea@gmail.com'),(3,'34567890C','Mikel','Zubizarreta','600345678','Calle Arenal 7, Vitoria','mikelzub','Zubiz@rr3ta','mzubizarreta@gmail.com'),(4,'45678901D','Nerea','Aranburu','600456789','Calle Txindoki 12, Eibar','nereaara','Nerea2023','naranburu@gmail.com'),(5,'56789012E','Aitor','Lasa','600567890','Calle Gipuzkoa 15, Hernani','aitorlasa','P@ssLasa','alasa@gmail.com'),(6,'67890123F','Irati','Mendizabal','600678901','Calle Urumea 18, Tolosa','iratimendi','M3nd1z@b@l','imendizabal@gmail.com'),(7,'78901234G','Unai','Iraola','600789012','Calle Atxuri 21, Bilbao','unaiira','Iraol@2023','uiraola@gmail.com'),(8,'89012345H','Ane','Zuaznabar','600890123','Calle Antiguo 24, Donostia','anezuaz','Zua$123','azuaznabar@gmail.com'),(9,'90123456I','Oier','Imaz','600901234','Calle Aralar 27, Beasain','oierimaz','P@ss123','oimaz@gmail.com'),(10,'01234567J','Eneko','Lopez','600012345','Calle Errekalde 30, Zumaia','enekolopez','L0pez!@#','elopez@gmail.com'),(11,'11234567K','Maite','Urbieta','600112345','Calle Eroski 33, Galdakao','maiteurb','Urb!2023','murbieta@gmail.com'),(12,'21234567L','Ander','Altuna','600212345','Calle Santa Clara 36, Hondarribia','anderalt','Altuna123','aaltuna@gmail.com'),(13,'31234567M','Edurne','Garmendia','600312345','Calle Zabalburu 39, Bilbao','edurnegar','P@sswEdurne','egarmendia@gmail.com'),(14,'41234567N','Xabier','Egiguren','600412345','Calle Matia 42, Donostia','xabiegig','Egiguren99','xegiguren@gmail.com'),(15,'51234567O','Iker','Lertxundi','600512345','Calle Mendizorrotza 45, Vitoria','ikerler','L3rtxundi','ilertxundi@gmail.com'),(16,'61234567P','Leire','Bikandi','600612345','Calle Urdaibai 48, Gernika','leirebik','Bikandi2023','lbikandi@gmail.com'),(17,'71234567Q','Arantxa','Larrea','600712345','Calle Baserri 51, Oñati','arantxalar','Larrea$$','alarrea@gmail.com'),(18,'81234567R','Beñat','Eguren','600812345','Calle Atxondo 54, Durango','benategu','Eguren!@','beguren@gmail.com'),(19,'91234567S','Garazi','Zabala','600912345','Calle Urkizu 57, Tolosa','garazizab','Zabala123','gzabala@gmail.com'),(20,'01324567T','Xabi','Goiria','600013456','Calle Zurriola 60, Donostia','xabigoir','GoiriaP@ss','xgoiria@gmail.com'),(21,'22334567U','Aitor','Olabarri','600223456','Calle Getxo 63, Getxo','aitorolab','Olabarri!1','aolabarri@gmail.com'),(22,'32334567V','Jone','Errekondo','600323456','Calle Garbera 66, Donostia','jonerrek','Errek2023','jerrekondo@gmail.com'),(23,'42334567W','Maddi','Lekue','600423456','Calle Anboto 69, Arrasate','maddilek','Lekue$$$','mlekue@gmail.com'),(24,'52334567X','Iban','Azkue','600523456','Calle Tabira 72, Durango','ibanazk','Azkue456','iazkue@gmail.com'),(25,'62334567Y','Aiora','Etxaniz','600623456','Calle Egia 75, Donostia','aioraetx','Etx@123','aetxaniz@gmail.com'),(26,'72334567Z','Iñigo','Uribarri','600723456','Calle Loiola 78, Donostia','inigurib','Urib@2023','iuribarri@gmail.com'),(27,'82334567A','Naiara','Sagastibeltza','600823456','Calle Landako 81, Durango','naiarasag','Sagasti!@','nsagastibeltza@gmail.com'),(28,'92334567B','Gaizka','Jauregi','600923456','Calle Igeldo 84, Donostia','gaizkaja','Jauregi2023','gjauregi@gmail.com'),(29,'03334567C','Uxue','Elorza','600033456','Calle Txomin 87, Eibar','uxuelor','Elorza***','uelorza@gmail.com'),(30,'13334567D','Patxi','Bereziartua','600133456','Calle Amara 90, Donostia','patxiber','Berezi2023','pbereziartua@gmail.com');
/*!40000 ALTER TABLE `bezeroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bezeroahistorikoa`
--

DROP TABLE IF EXISTS `bezeroahistorikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bezeroahistorikoa` (
  `idBezeroa` int DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `izena` varchar(20) DEFAULT NULL,
  `abizena` varchar(45) DEFAULT NULL,
  `telefonoa` varchar(9) DEFAULT NULL,
  `helbidea` longtext,
  `erabiltzaileIzena` varchar(45) DEFAULT NULL,
  `pasahitza` varchar(20) DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bezeroahistorikoa`
--

LOCK TABLES `bezeroahistorikoa` WRITE;
/*!40000 ALTER TABLE `bezeroahistorikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `bezeroahistorikoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera`
--

DROP TABLE IF EXISTS `eskaera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera` (
  `idEskaera` int NOT NULL AUTO_INCREMENT,
  `helbidea` longtext NOT NULL,
  `eskaeraData` date NOT NULL,
  `egoera` varchar(45) NOT NULL,
  `bezeroa_idBezeroa` int NOT NULL,
  PRIMARY KEY (`idEskaera`,`bezeroa_idBezeroa`),
  KEY `fk_eskaera_bezeroa1_idx` (`bezeroa_idBezeroa`),
  CONSTRAINT `fk_eskaera_bezeroa1` FOREIGN KEY (`bezeroa_idBezeroa`) REFERENCES `bezeroa` (`idBezeroa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera`
--

LOCK TABLES `eskaera` WRITE;
/*!40000 ALTER TABLE `eskaera` DISABLE KEYS */;
/*!40000 ALTER TABLE `eskaera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera_has_produktua`
--

DROP TABLE IF EXISTS `eskaera_has_produktua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera_has_produktua` (
  `eskaera_idEskaera` int NOT NULL,
  `eskaera_bezeroa_idBezeroa` int NOT NULL,
  `produktua_idProduktua` int NOT NULL,
  `produktuKopurua` int NOT NULL,
  PRIMARY KEY (`eskaera_idEskaera`,`eskaera_bezeroa_idBezeroa`,`produktua_idProduktua`),
  KEY `fk_eskaera_has_produktua_produktua1_idx` (`produktua_idProduktua`),
  KEY `fk_eskaera_has_produktua_eskaera1_idx` (`eskaera_idEskaera`,`eskaera_bezeroa_idBezeroa`),
  CONSTRAINT `fk_eskaera_has_produktua_eskaera1` FOREIGN KEY (`eskaera_idEskaera`, `eskaera_bezeroa_idBezeroa`) REFERENCES `eskaera` (`idEskaera`, `bezeroa_idBezeroa`),
  CONSTRAINT `fk_eskaera_has_produktua_produktua1` FOREIGN KEY (`produktua_idProduktua`) REFERENCES `produktua` (`idProduktua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera_has_produktua`
--

LOCK TABLES `eskaera_has_produktua` WRITE;
/*!40000 ALTER TABLE `eskaera_has_produktua` DISABLE KEYS */;
/*!40000 ALTER TABLE `eskaera_has_produktua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera_has_produktua_historikoa`
--

DROP TABLE IF EXISTS `eskaera_has_produktua_historikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera_has_produktua_historikoa` (
  `eskaera_idEskaera` int DEFAULT NULL,
  `eskaera_bezeroa_idBezeroa` int DEFAULT NULL,
  `prduktua_idProduktua` int DEFAULT NULL,
  `produktuKopurua` int DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera_has_produktua_historikoa`
--

LOCK TABLES `eskaera_has_produktua_historikoa` WRITE;
/*!40000 ALTER TABLE `eskaera_has_produktua_historikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `eskaera_has_produktua_historikoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaerahistorikoa`
--

DROP TABLE IF EXISTS `eskaerahistorikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaerahistorikoa` (
  `idEskaera` int DEFAULT NULL,
  `helbidea` longtext,
  `eskaeraData` date DEFAULT NULL,
  `egoera` varchar(45) DEFAULT NULL,
  `bezeroa_idBezeroa` int DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaerahistorikoa`
--

LOCK TABLES `eskaerahistorikoa` WRITE;
/*!40000 ALTER TABLE `eskaerahistorikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `eskaerahistorikoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hornitzailea`
--

DROP TABLE IF EXISTS `hornitzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hornitzailea` (
  `idHornitzailea` int NOT NULL AUTO_INCREMENT,
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(20) NOT NULL,
  `abizena` varchar(45) NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `helbidea` longtext NOT NULL,
  `erabiltzaileIzena` varchar(45) NOT NULL,
  `pasahitza` varchar(20) NOT NULL,
  PRIMARY KEY (`idHornitzailea`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hornitzailea`
--

LOCK TABLES `hornitzailea` WRITE;
/*!40000 ALTER TABLE `hornitzailea` DISABLE KEYS */;
INSERT INTO `hornitzailea` VALUES (1,'12345678A','Iñaki','Arrieta','700123456','Calle Foruak 1, Bilbao','inakiarri','Arrieta!23'),(2,'23456789B','Ane','Uribe','700234567','Calle Mendieta 3, Donostia','aneuribe','Uribe2023'),(3,'34567890C','Unai','Egibar','700345678','Calle Basque 5, Vitoria','unaiegib','Egib@r!'),(4,'45678901D','Leire','Artola','700456789','Calle Hondar 7, Zarautz','leireart','Art0l@99'),(5,'56789012E','Olatz','Etxebarria','700567890','Calle Iparralde 9, Hernani','olatze','Etxebarri@1'),(6,'67890123F','Jon','Gorostidi','700678901','Calle Ola 11, Tolosa','jongoro','Gor0$123'),(7,'78901234G','Irati','Larrinaga','700789012','Calle Txoko 13, Oñati','iratilar','L@rrinaga'),(8,'89012345H','Mikel','Urkia','700890123','Calle Gazta 15, Getaria','mikelurk','Urk1a2023'),(9,'90123456I','Aitor','Goiuria','700901234','Calle Argia 17, Azpeitia','aitorgoi','Goi@123'),(10,'01234567J','Eneko','Iturri','700012345','Calle Mendi 19, Zumaia','enekoitu','Iturr1!!'),(11,'11234567K','Maialen','Olaberria','700112345','Calle Lore 21, Beasain','maialeno','Olaberria!'),(12,'21234567L','Ander','Zubia','700212345','Calle Zilar 23, Eibar','anderzub','Zub!aP@ss'),(13,'31234567M','Amaia','Aizpuru','700312345','Calle Zurriola 25, Donostia','amaiaaiz','Aizpuru12'),(14,'41234567N','Beñat','Arrizabalaga','700412345','Calle Alde 27, Durango','benatarri','Arriz@balaga'),(15,'51234567O','Edurne','Zarandona','700512345','Calle Txistulari 29, Galdakao','edurnezar','Zar@ndona!'),(16,'61234567P','Xabier','Arana','700612345','Calle Matxin 31, Basauri','xabiaran','Arana2023'),(17,'71234567Q','Garazi','Eguren','700712345','Calle Loiola 33, Donostia','garazieg','Eguren!@@'),(18,'81234567R','Nerea','Ibarguren','700812345','Calle Txalaparta 35, Vitoria','nereibarg','Ibargur3n'),(19,'91234567S','Oier','Arrinda','700912345','Calle Zazpi 37, Bilbao','oierarri','ArrindaP@ss'),(20,'01324567T','Aitor','Mendizabal','700013456','Calle Anboto 39, Eibar','aitormen','Mendi123'),(21,'22334567U','Iker','Lasa','700223456','Calle Eguzkia 41, Zarautz','ikerlasa','L@sa2023'),(22,'32334567V','Jone','Aretxaga','700323456','Calle Santutxu 43, Bilbao','jonearet','Aretxaga!'),(23,'42334567W','Maite','Lizarazu','700423456','Calle Zuloaga 45, Oñati','maiteliz','Liz@2023'),(24,'52334567X','Iban','Erro','700523456','Calle Amara 47, Donostia','ibanerr','Erro!P@ss'),(25,'62334567Y','Maddi','Lete','700623456','Calle Artxanda 49, Bilbao','maddilete','Lete123'),(26,'72334567Z','Arantxa','Oiartzun','700723456','Calle Mendibil 51, Hernani','arantxao','Oi@rtzun'),(27,'82334567A','Gaizka','Zubeldia','700823456','Calle Andoain 53, Tolosa','gaizkazub','Zub3ldia'),(28,'92334567B','Uxue','Altuna','700923456','Calle Uribarri 55, Bilbao','uxuealt','Altun@23'),(29,'03334567C','Patxi','Sagastibeltza','700033456','Calle Otxandio 57, Durango','patxisag','Sag@123'),(30,'13334567D','Leire','Murueta','700133456','Calle Txindoki 59, Zarautz','leiremur','Muruet@2023');
/*!40000 ALTER TABLE `hornitzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hornitzaileahistorikoa`
--

DROP TABLE IF EXISTS `hornitzaileahistorikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hornitzaileahistorikoa` (
  `idHornitzailea` int DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `izena` varchar(20) DEFAULT NULL,
  `abizena` varchar(45) DEFAULT NULL,
  `telefonoa` varchar(9) DEFAULT NULL,
  `helbidea` longtext,
  `erabiltzaileaIzena` varchar(45) DEFAULT NULL,
  `pasahitza` varchar(20) DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hornitzaileahistorikoa`
--

LOCK TABLES `hornitzaileahistorikoa` WRITE;
/*!40000 ALTER TABLE `hornitzaileahistorikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `hornitzaileahistorikoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langilea`
--

DROP TABLE IF EXISTS `langilea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `langilea` (
  `idLangilea` int NOT NULL AUTO_INCREMENT,
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(20) NOT NULL,
  `abizena` varchar(45) NOT NULL,
  `lanPostua` varchar(45) NOT NULL,
  `admin` tinyint NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `helbidea` longtext NOT NULL,
  `postaKodea` varchar(5) NOT NULL,
  `erabiltzaileIzena` varchar(45) NOT NULL,
  `pasahitza` varchar(20) NOT NULL,
  PRIMARY KEY (`idLangilea`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langilea`
--

LOCK TABLES `langilea` WRITE;
/*!40000 ALTER TABLE `langilea` DISABLE KEYS */;
INSERT INTO `langilea` VALUES (1,'12345678A','Iñaki','Etxebarria','Ingeniero',1,'800123456','Calle Alde Zaharra 1, Bilbao','48001','inakietx','Etxebarria@1'),(2,'23456789B','Ane','Goikoetxea','Administrativo',0,'800234567','Calle Miramar 2, Donostia','20009','anegoik','GoikoetxeaP@ss'),(3,'34567890C','Unai','Zubiri','Mecánico',0,'800345678','Calle Alava 3, Vitoria','01001','unaizub','Zubiri123'),(4,'45678901D','Leire','Altuna','Contable',1,'800456789','Calle Urumea 4, Hernani','20120','leirealt','Altuna2023'),(5,'56789012E','Jon','Larrinaga','Técnico',0,'800567890','Calle Errenteria 5, Errenteria','20100','jonlarr','Larrinaga!123'),(6,'67890123F','Irati','Garai','Supervisor',1,'800678901','Calle Anboto 6, Durango','48200','iratigar','Garai123'),(7,'78901234G','Aitor','Zabala','Ingeniero',0,'800789012','Calle Uribarri 7, Bilbao','48005','aitorzab','Zabala@1'),(8,'89012345H','Maddi','Olaberria','Administrador',1,'800890123','Calle Mendi 8, Zumaia','20750','maddiola','Olaberria2023'),(9,'90123456I','Nerea','Aranburu','Mecánico',0,'800901234','Calle Zurriola 9, Donostia','20008','nerearan','Aranburu!'),(10,'01234567J','Xabi','Lertxundi','Supervisor',1,'800012345','Calle Gazta 10, Getaria','20808','xabilert','Lertxundi123'),(11,'11234567K','Garazi','Urrutia','Ingeniero',0,'800112345','Calle Iparralde 11, Hernani','20120','garaziurr','UrrutiaP@ss'),(12,'21234567L','Oier','Arrizabalaga','Contable',1,'800212345','Calle Loiola 12, Donostia','20006','oierarri','Arrizabalaga99'),(13,'31234567M','Ander','Eguren','Técnico',0,'800312345','Calle Egia 13, Donostia','20010','andereg','Eguren!2023'),(14,'41234567N','Beñat','Iturria','Administrador',1,'800412345','Calle Baserri 14, Oñati','20560','benatit','Iturria@123'),(15,'51234567O','Maite','Etxaniz','Supervisor',1,'800512345','Calle Loiu 15, Loiu','48180','maiteetx','Etxaniz!'),(16,'61234567P','Leire','Sagastibeltza','Ingeniero',0,'800612345','Calle Zabalburu 16, Bilbao','48011','leiresag','Sagastibeltza123'),(17,'71234567Q','Unai','Jauregi','Técnico',0,'800712345','Calle Tabira 17, Durango','48200','unaijaur','Jauregi!@#'),(18,'81234567R','Amaia','Garmendia','Contable',1,'800812345','Calle Altza 18, Donostia','20017','amaiagar','Garmendia$$'),(19,'91234567S','Eneko','Lasa','Administrador',1,'800912345','Calle Amara 19, Donostia','20006','enekolasa','LasaP@ss'),(20,'01324567T','Aiora','Erro','Supervisor',1,'800013456','Calle Errekalde 20, Zumaia','20750','aioraerr','Erro!2023'),(21,'22334567U','Iban','Altube','Mecánico',0,'800223456','Calle Alde Zaharra 21, Getxo','48930','ibanalt','Altube123'),(22,'32334567V','Xabier','Zubiri','Ingeniero',0,'800323456','Calle Bidasoa 22, Hondarribia','20280','xabizub','Zubiri2023'),(23,'42334567W','Edurne','Larrea','Supervisor',1,'800423456','Calle Erandio 23, Bilbao','48950','edurnelar','Larrea!@'),(24,'52334567X','Gaizka','Lekue','Administrador',1,'800523456','Calle Antiguo 24, Donostia','20009','gaizkalek','LekueP@ss'),(25,'62334567Y','Arantxa','Zubeldia','Mecánico',0,'800623456','Calle Landako 25, Durango','48200','arantxazu','Zubeldia$$'),(26,'72334567Z','Uxue','Bereziartua','Ingeniero',0,'800723456','Calle Loiola 26, Donostia','20006','uxueb','Bereziartua@1'),(27,'82334567A','Maddi','Elorza','Contable',1,'800823456','Calle Zorroza 27, Bilbao','48013','maddielo','Elorza!'),(28,'92334567B','Patxi','Arana','Supervisor',1,'800923456','Calle Arenal 28, Bilbao','48005','patxiar','AranaP@ss'),(29,'03334567C','Jon','Ibarguren','Administrador',1,'800033456','Calle Mazarredo 29, Bilbao','48009','joniba','Ibarguren123'),(30,'13334567D','Maialen','Oiartzun','Técnico',0,'800133456','Calle Erribera 30, Gernika','48300','maialenoi','Oiartzun@1');
/*!40000 ALTER TABLE `langilea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langileahistorikoa`
--

DROP TABLE IF EXISTS `langileahistorikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `langileahistorikoa` (
  `idLangilea` int DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `izena` varchar(20) DEFAULT NULL,
  `abizena` varchar(45) DEFAULT NULL,
  `lanPostua` varchar(45) DEFAULT NULL,
  `admin` tinyint DEFAULT NULL,
  `telefonoa` varchar(9) DEFAULT NULL,
  `helbidea` longtext,
  `postaKodea` varchar(5) DEFAULT NULL,
  `erabiltzaileIzena` varchar(45) DEFAULT NULL,
  `pasahitza` varchar(20) DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langileahistorikoa`
--

LOCK TABLES `langileahistorikoa` WRITE;
/*!40000 ALTER TABLE `langileahistorikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `langileahistorikoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktua`
--

DROP TABLE IF EXISTS `produktua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produktua` (
  `idProduktua` int NOT NULL AUTO_INCREMENT,
  `izena` varchar(45) NOT NULL,
  `stock` int NOT NULL,
  `prezioa` double NOT NULL,
  `deskribapena` longtext NOT NULL,
  `langilea_idLangilea` int NOT NULL,
  `hornitzailea_idHornitzailea` int NOT NULL,
  `irudia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProduktua`,`langilea_idLangilea`,`hornitzailea_idHornitzailea`),
  KEY `fk_produktua_langilea_idx` (`langilea_idLangilea`),
  KEY `fk_produktua_hornitzailea1_idx` (`hornitzailea_idHornitzailea`),
  CONSTRAINT `fk_produktua_hornitzailea1` FOREIGN KEY (`hornitzailea_idHornitzailea`) REFERENCES `hornitzailea` (`idHornitzailea`),
  CONSTRAINT `fk_produktua_langilea` FOREIGN KEY (`langilea_idLangilea`) REFERENCES `langilea` (`idLangilea`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktua`
--

LOCK TABLES `produktua` WRITE;
/*!40000 ALTER TABLE `produktua` DISABLE KEYS */;
INSERT INTO `produktua` VALUES (1,'Asus ROG Strix Scar',30,1899.99,'Asus ROG Strix Scar joko-portatila bat da, potentzia handiko prozesadore eta grafikoekin.',2,1,'produktu1.png'),(2,'Oppo Reno6 Z',120,499.99,'Oppo Reno6 Z 5G telefono adimentsu bat da, argazki kalitate handiko kamera eta 5G konektibitatearekin.',4,2,'produktu2.jpg'),(3,'Philips Monitor 27\"',50,219.99,'Philips 27\" monitore honek irudi bizia eta zehatza eskaintzen du, lan eta entretenimendurako egokia.',6,3,'produktu3.png'),(4,'Impresora HP LaserJet',25,299.99,'HP LaserJet inpresora sarekoa eta abiadura handikoa da, bulegoko lanetarako egokia.',8,4,'produktu4.png'),(5,'Sony HT-G700',10,349.95,'Sony HT-G700 soinu-barra modernoa eta potentzia handiko audioarekin, etxean entretenimendu hobea eskainiz.',10,5,'produktu5.png'),(6,'Samsung Galaxy Tab S7',35,649.99,'Samsung Galaxy Tab S7 tablet moderno eta sendoa da, pantaila handia eta potentzia handiko prozesadorearekin.',12,6,'produktu6.png'),(7,'Dell XPS 13',15,1399,'Dell XPS 13 laptop dotore eta arina, produktibitatea eta mugikortasuna lehenesteko.',14,7,'produktu7.png'),(8,'Logitech MX Master 3S',80,99.99,'Logitech MX Master 3S sagua, erabilera erosoa eta zehatza eskaintzen duena.',16,8,'produktu8.png'),(9,'Corsair K95 RGB Platinum',60,179.99,'Corsair K95 RGB Platinum teklatu mekaniko profesionala, jokoaren zaleentzat diseinatua.',18,9,'produktu9.png'),(10,'Canon EOS 250D',20,899.99,'Canon EOS 250D kamera DSLR malgua eta erabilerraza, hasiberrientzat egokia.',20,10,'produktu10.png'),(11,'JBL Tune Flex',70,79.99,'JBL Tune Flex entzungailuak, musika eta audio esperientzia hobetzeko, diseinu arin eta konfortagarria.',2,11,'produktu11.jpg'),(12,'WD My Passport 2TB',100,89.99,'WD My Passport 2TB disko gogor kanpora eramateko, biltegiratze handia eta segurtasuna eskaintzen dituena.',4,12,'produktu12.png'),(13,'SanDisk Ultra Dual Drive',250,29.99,'SanDisk Ultra Dual Drive Luxe USB disko, biltegiratze erraza eta azkarra eskaintzen duena.',6,13,'produktu13.png'),(14,'Logitech C920s Pro',40,69.99,'Logitech C920s Pro webkamera HD kalitatez eta soinua ondo jasotzeko gaitasunarekin.',8,14,'produktu14.png'),(15,'JBL Flip 5',90,99.95,'JBL Flip 5 bluetooth bozgorailua, soinu sendo eta garbia eskaintzen duena.',10,15,'produktu15.png'),(16,'Anker PowerPort Atom III',30,39.99,'Anker PowerPort Atom III kargagailu konpaktua eta azkarra, gailu anitzentzat erabilgarria.',12,16,'produktu16.png'),(17,'Audio-Technica ATH-M50X',50,149.99,'Audio-Technica ATH-M50X entzungailuak, soinu kalitate ezin hobea eta erosotasun luzerako.',14,17,'produktu17.png'),(18,'Apple Watch Series 7',45,399.99,'Apple Watch Series 7 smartwatch, osasun eta fitness monitorizazio aurreratua eta eguneratutako diseinua.',16,18,'produktu18.png'),(19,'Brother DS-940DW',20,199.99,'Brother DS-940DW skaner mugikorra, dokumentuak azkar eskaneatzeko eta biltegiratzeko.',18,19,'produktu19.png'),(20,'Netgear R7000',75,129.95,'Netgear R7000 router WiFi, abiadura handiko eta sare zabaleko etxeentzako.',20,20,'produktu20.jpg'),(21,'Razer BlackShark V2',60,99.99,'Razer BlackShark V2 entzungailuak, joko esperientzia hobetzeko audio eta mikrofono aurreratuarekin.',2,21,'produktu21.png'),(22,'NVIDIA RTX 3080',25,699.99,'NVIDIA RTX 3080 grafiko-txartelaren errendimendu paregabea joko eta sormen lanetarako.',4,22,'produktu22.png'),(23,'MSI Optix MAG274QRF-QD',45,329.99,'MSI Optix MAG274QRF-QD monitore profesionala, kolore eta zehaztasun handiko pantaila eskaintzen duena.',6,23,'produktu23.png'),(24,'Gigabyte AORUS 15G',20,1799.99,'Gigabyte AORUS 15G laptop jokoetarako, grafiko eta prozesadore indartsuak dituena.',8,24,'produktu24.png'),(25,'Bose QuietComfort 45',40,329.99,'Bose QuietComfort 45 entzungailuak, zaratarik gabeko soinua eta erosotasun maila altua eskaintzen ditu.',10,25,'produktu25.png'),(26,'Xbox Wireless Controller',50,59.99,'Xbox Wireless Controller, jolasten egon ahal izateko fidagarri eta erosoa den kontrolagailua.',12,26,'produktu26.png'),(27,'Corsair RM750x PSU',40,129.99,'Corsair RM750x PSU, potentzia iturri fidagarri eta eraginkorra.',14,27,'produktu27.png'),(28,'AmazonBasics HDMI Cable',200,12.99,'AmazonBasics HDMI kablea, konexio azkar eta fidagarriaren eskaintza.',16,28,'produktu28.png'),(29,'AMD Radeon RX 6900 XT',10,1299.99,'AMD Radeon RX 6900 XT grafiko-txartela, joko esperientzia handitzeko eta grafiko aurreratuak eskaintzeko.',18,29,'produktu29.jpg'),(30,'Cooler Master Notepal X3',60,49.99,'Cooler Master Notepal X3 notebook freskagailua, lan egiteko edo jolasteko egokia.',20,30,'produktu30.png');
/*!40000 ALTER TABLE `produktua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktuahistorikoa`
--

DROP TABLE IF EXISTS `produktuahistorikoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produktuahistorikoa` (
  `idProduktua` int DEFAULT NULL,
  `izena` varchar(45) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `prezioa` double DEFAULT NULL,
  `deskribapena` longtext,
  `langilea_idLangilea` int DEFAULT NULL,
  `hornitzailea_idHornitzailea` int DEFAULT NULL,
  `aldaketa_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `operazio_mota` enum('UPDATE','DELETE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktuahistorikoa`
--

LOCK TABLES `produktuahistorikoa` WRITE;
/*!40000 ALTER TABLE `produktuahistorikoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `produktuahistorikoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-29 12:03:06
