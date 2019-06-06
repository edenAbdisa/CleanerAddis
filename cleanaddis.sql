-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cleanaddis
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address` (
  `uuid` binary(16) NOT NULL,
  `country` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `subcity` varchar(100) DEFAULT NULL,
  `woreda` varchar(100) DEFAULT NULL,
  `street_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `uuid` binary(16) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `media_uuid` binary(16) DEFAULT NULL,
  `text` text,
  `full_text` mediumtext,
  `published_date` date DEFAULT NULL,
  `published_status` enum('DRAFT','APPROVED','PUBLISHED','UPDATED','REMOVED') DEFAULT NULL,
  `updated_by` varchar(200) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `published_by` varchar(200) DEFAULT NULL,
  `view_count` bigint(20) DEFAULT NULL,
  `category_uuid` binary(16) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `media_uuid_idx` (`media_uuid`),
  KEY `category_uuid_idx` (`category_uuid`),
  CONSTRAINT `article_category_uuid_fk` FOREIGN KEY (`category_uuid`) REFERENCES `category` (`uuid`),
  CONSTRAINT `article_media_uuid_fk` FOREIGN KEY (`media_uuid`) REFERENCES `media` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `name` varchar(200) NOT NULL,
  `uuid` binary(16) NOT NULL,
  `for_what` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `user_uuid_idx` (`name`),
  KEY `role_uuid_idx` (`for_what`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `friends` (
  `uuid` binary(16) NOT NULL,
  `status` enum('REQUESTED','ACCEPTED','REMOVED') DEFAULT NULL,
  `username_requestor` varchar(255) DEFAULT NULL,
  `username_acceptor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `friends_username_requestor_idx` (`username_requestor`),
  KEY `riends_username_acceptor_idx` (`username_acceptor`),
  CONSTRAINT `friends_username_requestor` FOREIGN KEY (`username_requestor`) REFERENCES `user` (`username`),
  CONSTRAINT `riends_username_acceptor` FOREIGN KEY (`username_acceptor`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `media` (
  `uuid` binary(16) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `type` enum('VIDEO','IMAGE','VOICE') DEFAULT NULL,
  `for_what_data` varchar(100) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `post` (
  `uuid` binary(16) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `media_uuid` binary(16) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `no_like` bigint(20) DEFAULT NULL,
  `no_view` bigint(20) DEFAULT NULL,
  `status` enum('POSTED','REMOVEDBYREPORT','DELETED','EDITED') DEFAULT NULL,
  `downloadable` bit(1) DEFAULT NULL,
  `can_be_viewed_by` enum('FRIENDS','FRIENDSOFFRIENDS','MEONLY','ALL') DEFAULT NULL,
  `allow_to_be_used_for_article` bit(1) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `post_username_idx` (`username`),
  KEY `post_media_uuid_idx` (`media_uuid`),
  CONSTRAINT `post_media_uuid` FOREIGN KEY (`media_uuid`) REFERENCES `media` (`uuid`),
  CONSTRAINT `post_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `report` (
  `uuid` binary(16) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `media_uuid` binary(16) DEFAULT NULL,
  `report_type` enum('WASTE','POST') DEFAULT NULL,
  `date` date DEFAULT NULL,
  `address_uuid` binary(16) DEFAULT NULL,
  `impact` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `report_address_uuid_idx` (`address_uuid`),
  KEY `report_media_uuid_idx` (`media_uuid`),
  KEY `report_username_idx` (`username`),
  CONSTRAINT `report_address_uuid` FOREIGN KEY (`address_uuid`) REFERENCES `address` (`uuid`),
  CONSTRAINT `report_media_uuid` FOREIGN KEY (`media_uuid`) REFERENCES `media` (`uuid`),
  CONSTRAINT `report_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `uuid` binary(16) NOT NULL,
  `role` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching`
--

DROP TABLE IF EXISTS `teaching`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teaching` (
  `uuid` binary(16) NOT NULL,
  `media_uuid` binary(16) DEFAULT NULL,
  `published_date` date DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `category_uuid` binary(16) DEFAULT NULL,
  `text` text,
  `status` enum('DRAFT','APPROVED','PUBLISHED','UPDATED') DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `media_uuid_idx` (`media_uuid`),
  KEY `category_uuid_idx` (`category_uuid`),
  CONSTRAINT `category_uuid` FOREIGN KEY (`category_uuid`) REFERENCES `category` (`uuid`),
  CONSTRAINT `media_uuid` FOREIGN KEY (`media_uuid`) REFERENCES `media` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching`
--

LOCK TABLES `teaching` WRITE;
/*!40000 ALTER TABLE `teaching` DISABLE KEYS */;
/*!40000 ALTER TABLE `teaching` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uuid` binary(16) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fName` varchar(45) NOT NULL,
  `lName` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `activated` bit(1) NOT NULL,
  `blocked` bit(1) NOT NULL,
  `role_uuid` binary(16) DEFAULT NULL,
  `last_vist` date DEFAULT NULL,
  `activated_date` date DEFAULT NULL,
  `usercol` varchar(45) DEFAULT NULL,
  `usercol1` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_uuid` binary(16) NOT NULL,
  `role_uuid` binary(16) DEFAULT NULL,
  `uuid` binary(16) DEFAULT NULL,
  PRIMARY KEY (`user_uuid`),
  KEY `role_uuid_idx` (`role_uuid`),
  CONSTRAINT `role_uuid` FOREIGN KEY (`role_uuid`) REFERENCES `role` (`uuid`),
  CONSTRAINT `user_uuid` FOREIGN KEY (`user_uuid`) REFERENCES `user` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-03 12:02:40
