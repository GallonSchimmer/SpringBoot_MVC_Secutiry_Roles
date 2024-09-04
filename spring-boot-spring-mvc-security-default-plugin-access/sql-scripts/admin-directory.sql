CREATE DATABASE  IF NOT EXISTS `admin_directory`;
USE `admin_directory`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  -- `last_name` varchar(45) DEFAULT NULL,
  -- `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `admin`
--

INSERT INTO `admin` VALUES 
	(1,'admin');
	

