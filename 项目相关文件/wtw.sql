/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.41 : Database - wtw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wtw` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `wtw`;

/*Table structure for table `historical_records` */

DROP TABLE IF EXISTS `historical_records`;

CREATE TABLE `historical_records` (
  `hr_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m_title` varchar(600) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`hr_id`),
  KEY `userId` (`user_id`),
  CONSTRAINT `historical_records_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电影id',
  `title` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电影名',
  `introduction` mediumtext COLLATE utf8_unicode_ci COMMENT '电影简介',
  `cover` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电影封面',
  `resources` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '资源',
  `url` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电影url',
  `types` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电影类型',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=583761 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `types_id` int(11) NOT NULL AUTO_INCREMENT,
  `types_name` varchar(30) CHARACTER SET utf32 COLLATE utf32_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`types_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `nickname` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `view_type_statistics` */

DROP TABLE IF EXISTS `view_type_statistics`;

CREATE TABLE `view_type_statistics` (
  `vts_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m_type` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `times` mediumint(9) DEFAULT '1',
  PRIMARY KEY (`vts_id`),
  KEY `userId` (`user_id`),
  CONSTRAINT `view_type_statistics_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
