/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.22-community-nt : Database - wechat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wechat` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `wtw`;

/*Table structure for table `historical_records` */

DROP TABLE IF EXISTS `historical_records`;

CREATE TABLE `historical_records` (
  `hrId` int(11) NOT NULL auto_increment,
  `userId` int(11) default NULL,
  `mTitle` mediumtext collate utf8_unicode_ci,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`hrId`),
  KEY `userId` (`userId`),
  CONSTRAINT `historical_records_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL COMMENT '电影id',
  `title` mediumtext collate utf8_unicode_ci COMMENT '电影名',
  `introduction` mediumtext collate utf8_unicode_ci COMMENT '电影简介',
  `cover` mediumtext collate utf8_unicode_ci COMMENT '电影封面',
  `resources` mediumtext collate utf8_unicode_ci COMMENT '资源',
  `url` mediumtext collate utf8_unicode_ci COMMENT '电影url',
  `types` mediumtext collate utf8_unicode_ci COMMENT '电影类型',
  PRIMARY KEY  (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL COMMENT '用户id',
  `nickName` varchar(500) collate utf8_unicode_ci default NULL COMMENT '昵称',
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `view_type_statistics` */

DROP TABLE IF EXISTS `view_type_statistics`;

CREATE TABLE `view_type_statistics` (
  `vtsId` int(11) NOT NULL auto_increment,
  `userId` int(11) default NULL,
  `mType` mediumtext collate utf8_unicode_ci,
  `times` mediumint(9) default NULL,
  PRIMARY KEY  (`vtsId`),
  KEY `userId` (`userId`),
  CONSTRAINT `view_type_statistics_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
