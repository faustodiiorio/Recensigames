CREATE DATABASE  IF NOT EXISTS `recensigames` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `recensigames`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: recensigames
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CATEGORIA` varchar(45) NOT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_id_categoria_id_idx` (`ID_CATEGORIA`),
  CONSTRAINT `fk_id_categoria_id` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categorie` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Azione',1),(2,'Stealth',1),(3,'RPG Giapponese',2),(4,'Strategia',2),(5,'Avventura',3);
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consoles`
--

DROP TABLE IF EXISTS `consoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consoles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CONSOLE` varchar(45) NOT NULL,
  `ID_PRODUTTORE_CONSOLE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_produttore_consoles_idx` (`ID_PRODUTTORE_CONSOLE`),
  CONSTRAINT `fk_produttore_consoles` FOREIGN KEY (`ID_PRODUTTORE_CONSOLE`) REFERENCES `produttori_consoles` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consoles`
--

LOCK TABLES `consoles` WRITE;
/*!40000 ALTER TABLE `consoles` DISABLE KEYS */;
INSERT INTO `consoles` VALUES (1,'Playstation',1),(2,'Playstation 2',1),(3,'Playstation 3',1),(4,'Playstation 4',1),(5,'Nintendo 64',2),(6,'Gamecube',2),(7,'Wii',2),(8,'Wii U',2),(9,'Nintendo Switch',2),(10,'Xbox',3),(11,'Xbox 360',3),(12,'Xbox One',3);
/*!40000 ALTER TABLE `consoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domande`
--

DROP TABLE IF EXISTS `domande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domande` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITOLO` varchar(100) NOT NULL,
  `TESTO` tinytext NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  `DATA` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_domande_utenti_idx` (`ID_UTENTE`),
  CONSTRAINT `fk_domande_utenti` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domande`
--

LOCK TABLES `domande` WRITE;
/*!40000 ALTER TABLE `domande` DISABLE KEYS */;
/*!40000 ALTER TABLE `domande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giochi`
--

DROP TABLE IF EXISTS `giochi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giochi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITOLO_GIOCO` varchar(100) NOT NULL,
  `VOTO` float NOT NULL,
  `TRAMA` varchar(300) NOT NULL,
  `COPERTINA` varchar(100) NOT NULL,
  `TRAILER` varchar(100) NOT NULL,
  `DATA_PUBBLICAZIONE` date DEFAULT NULL,
  `ID_PRODUTTORE_GIOCHI` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_produttore_giochi_idx` (`ID_PRODUTTORE_GIOCHI`),
  CONSTRAINT `fk_produttore_giochi` FOREIGN KEY (`ID_PRODUTTORE_GIOCHI`) REFERENCES `produttori_giochi` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giochi`
--

LOCK TABLES `giochi` WRITE;
/*!40000 ALTER TABLE `giochi` DISABLE KEYS */;
INSERT INTO `giochi` VALUES (1,'The Legend of Zelda: Ocarina of Time',10,'Narra le gesta di Link contro Ganondorf per salvare Zelda','www.google.com','www.google.com','1998-11-11',8),(2,'Final Fantasy VII',10,'Narra le gesta di Cloud Strife contro Sephirot','www.google.com','www.google.com','1997-11-17',5),(3,'Metal Gear Solid',10,'Narra le gesta di Solid Snake contro i membri della Fox Hound, capeggiati da Liquid Snake','www.google.com','www.google.com','1999-02-26',2);
/*!40000 ALTER TABLE `giochi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giochi_categorie`
--

DROP TABLE IF EXISTS `giochi_categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giochi_categorie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_GIOCO` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_gioco_categoria_idx` (`ID_GIOCO`),
  KEY `fk_categoria_gioco_idx` (`ID_CATEGORIA`),
  CONSTRAINT `fk_categoria_gioco` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categorie` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_gioco_categoria` FOREIGN KEY (`ID_GIOCO`) REFERENCES `giochi` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giochi_categorie`
--

LOCK TABLES `giochi_categorie` WRITE;
/*!40000 ALTER TABLE `giochi_categorie` DISABLE KEYS */;
INSERT INTO `giochi_categorie` VALUES (1,1,3),(2,1,5),(3,2,3),(4,2,5),(5,3,1),(6,3,2);
/*!40000 ALTER TABLE `giochi_categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giochi_consoles`
--

DROP TABLE IF EXISTS `giochi_consoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giochi_consoles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_GIOCO` int(11) DEFAULT NULL,
  `ID_CONSOLE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_gioco_console_idx` (`ID_GIOCO`),
  KEY `fk_console_gioco_idx` (`ID_CONSOLE`),
  CONSTRAINT `fk_console_gioco` FOREIGN KEY (`ID_CONSOLE`) REFERENCES `consoles` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_gioco_console` FOREIGN KEY (`ID_GIOCO`) REFERENCES `giochi` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giochi_consoles`
--

LOCK TABLES `giochi_consoles` WRITE;
/*!40000 ALTER TABLE `giochi_consoles` DISABLE KEYS */;
INSERT INTO `giochi_consoles` VALUES (1,1,5),(2,1,6),(3,1,7),(4,2,1),(5,2,3),(6,3,1),(7,3,3);
/*!40000 ALTER TABLE `giochi_consoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produttori_consoles`
--

DROP TABLE IF EXISTS `produttori_consoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produttori_consoles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_PRODUTTORE_CONSOLES` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produttori_consoles`
--

LOCK TABLES `produttori_consoles` WRITE;
/*!40000 ALTER TABLE `produttori_consoles` DISABLE KEYS */;
INSERT INTO `produttori_consoles` VALUES (1,'Sony'),(2,'Nintendo'),(3,'Microsoft');
/*!40000 ALTER TABLE `produttori_consoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produttori_giochi`
--

DROP TABLE IF EXISTS `produttori_giochi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produttori_giochi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_PRODUTTORE_GIOCHI` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produttori_giochi`
--

LOCK TABLES `produttori_giochi` WRITE;
/*!40000 ALTER TABLE `produttori_giochi` DISABLE KEYS */;
INSERT INTO `produttori_giochi` VALUES (1,'Namco'),(2,'Konami'),(3,'Level-5 Inc.'),(4,'Square Enix'),(5,'Square'),(6,'Naughty Dog'),(7,'Capcom'),(8,'Nintendo');
/*!40000 ALTER TABLE `produttori_giochi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensioni`
--

DROP TABLE IF EXISTS `recensioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recensioni` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITOLO_RECENSIONE` varchar(45) NOT NULL,
  `FEEDBACK` float DEFAULT NULL,
  `DESCRIZIONE` mediumtext NOT NULL,
  `VIDEO_RECENSIONE` varchar(200) DEFAULT NULL,
  `TIPOLOGIA` varchar(10) NOT NULL,
  `ID_GIOCO` int(11) NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_gioco_recensione_idx` (`ID_GIOCO`),
  KEY `fk_utente_recensione_idx` (`ID_UTENTE`),
  CONSTRAINT `fk_gioco_recensione` FOREIGN KEY (`ID_GIOCO`) REFERENCES `giochi` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_utente_recensione` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensioni`
--

LOCK TABLES `recensioni` WRITE;
/*!40000 ALTER TABLE `recensioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `recensioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risposte`
--

DROP TABLE IF EXISTS `risposte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risposte` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TESTO` mediumtext NOT NULL,
  `DATA` date NOT NULL,
  `ID_DOMANDA` int(11) NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_risposte_domande_idx` (`ID_DOMANDA`),
  KEY `fk_risposte_utenti_idx` (`ID_UTENTE`),
  CONSTRAINT `fk_risposte_domande` FOREIGN KEY (`ID_DOMANDA`) REFERENCES `domande` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_risposte_utenti` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risposte`
--

LOCK TABLES `risposte` WRITE;
/*!40000 ALTER TABLE `risposte` DISABLE KEYS */;
/*!40000 ALTER TABLE `risposte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `COGNOME` varchar(45) NOT NULL,
  `DATA_NASCITA` date NOT NULL,
  `USERNAME` varchar(10) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `BANNATO` varchar(5) NOT NULL,
  `TIPOLOGIA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'Fausto','Di Iorio','1994-01-22','fausto.94','@Tempor6','fausto.94@live.it','NO','MASTER');
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-10 17:46:52
