/*
SQLyog Enterprise - MySQL GUI v5.25
Host - 5.0.89-community-nt : Database - dbpool
*********************************************************************
Server version : 5.0.89-community-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `dbpool`;

USE `dbpool`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `responsexml` */

DROP TABLE IF EXISTS `responsexml`;

CREATE TABLE `responsexml` (
  `name` varchar(50) default NULL,
  `value` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `responsexml` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
