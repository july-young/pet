/*
SQLyog Job Agent v12.4.1 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 10.1.44-MariaDB-0ubuntu0.18.04.1 : Database - pet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pet` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `pet`;

/*Table structure for table `t_goods` */

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除',
  `name` varchar(127) DEFAULT NULL COMMENT '商品名称',
  `brand` varchar(127) DEFAULT NULL COMMENT '品牌',
  `category` varchar(127) DEFAULT NULL COMMENT '猫砂/猫粮/零食',
  `weight` int(11) DEFAULT NULL COMMENT '重量',
  `speciality` varchar(127) DEFAULT NULL COMMENT '种类/口味',
  `img_urls` varchar(1023) DEFAULT NULL COMMENT 'josn数组（商品图片地址）',
  `code` varchar(127) DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_goods` */

insert  into `t_goods` values
(10,'2020-08-04','2020-08-04',NULL,NULL,0,'鱼肉猫粮','apple','catFood',15,'sweet','[\"https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3472225673,1999680163&fm=26&gp=0.jpg\"]','gc_apple_catFood_sweet_15_鱼肉猫粮');

/*Table structure for table `t_goods_item` */

DROP TABLE IF EXISTS `t_goods_item`;

CREATE TABLE `t_goods_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品的id',
  `gmt_open` date DEFAULT NULL COMMENT '开袋时间',
  `gmt_last_open` date DEFAULT NULL COMMENT '上一次的开袋时间',
  `gmt_expire` date DEFAULT NULL COMMENT '过期时间',
  `gmt_buy` date DEFAULT NULL COMMENT '购买时间',
  `channel` varchar(127) DEFAULT NULL COMMENT '渠道',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `price` int(11) DEFAULT NULL COMMENT '价格',
  `history_id` bigint(20) DEFAULT NULL COMMENT '购买记录ID',
  `category` varchar(127) DEFAULT NULL COMMENT '猫砂/猫粮/零食',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_goods_item` */

insert  into `t_goods_item` values
(21,'2020-08-04','2020-08-04',NULL,NULL,0,10,'2020-08-04',NULL,NULL,'2019-12-29','tianMao',1,1000,5,'catFood'),
(22,'2020-08-04','2020-08-04',NULL,NULL,0,10,'2020-08-04','2020-08-04',NULL,'2019-12-29','tianMao',1,1000,5,'catFood'),
(23,'2020-08-04','2020-08-04',NULL,NULL,0,10,'2020-08-04','2020-08-04',NULL,'2019-12-29','tianMao',1,1000,6,'catFood'),
(24,'2020-08-04','2020-08-04',NULL,NULL,0,10,NULL,NULL,NULL,'2019-12-29','tianMao',1,1000,6,'catFood'),
(25,'2020-08-04','2020-08-04',NULL,NULL,0,10,NULL,NULL,NULL,'2019-12-29','tianMao',1,1000,6,'catFood');

/*Table structure for table `t_goods_spec` */

DROP TABLE IF EXISTS `t_goods_spec`;

CREATE TABLE `t_goods_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除',
  `cate` varchar(31) NOT NULL COMMENT '类',
  `code` varchar(31) NOT NULL COMMENT '键',
  `name` varchar(31) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_goods_spec` */

insert  into `t_goods_spec` values
(1,NULL,NULL,NULL,NULL,0,'goodsCategory','snack','零食'),
(2,NULL,NULL,NULL,NULL,0,'goodsCategory','catFood','猫粮'),
(3,NULL,NULL,NULL,NULL,0,'goodsCategory','catLitter','猫砂'),
(4,NULL,NULL,NULL,NULL,0,'goodsChannel','tianMao','天猫'),
(5,NULL,NULL,NULL,NULL,0,'goodsChannel','jingdong','京东'),
(6,NULL,NULL,NULL,NULL,0,'goodsChannel','taoBao','淘宝'),
(7,NULL,NULL,NULL,NULL,0,'goodsBrand','apple','苹果'),
(8,NULL,NULL,NULL,NULL,0,'goodsBrand','sony','索尼'),
(9,NULL,NULL,NULL,NULL,0,'goodsSpecility','sweet','甜');

/*Table structure for table `t_message` */

DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除',
  `content` varchar(1023) DEFAULT NULL COMMENT '消息内容',
  `title` varchar(127) DEFAULT NULL COMMENT '标题',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发给用户的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_message` */

/*Table structure for table `t_pet` */

DROP TABLE IF EXISTS `t_pet`;

CREATE TABLE `t_pet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除',
  `nick_name` varchar(127) DEFAULT NULL COMMENT '昵称',
  `brand` varchar(127) DEFAULT NULL COMMENT '品种',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `children` int(11) DEFAULT NULL COMMENT '生育小孩数',
  `vaccine` int(11) DEFAULT NULL COMMENT '是否打疫苗',
  `repellent` tinyint(1) DEFAULT NULL COMMENT '是否驱虫',
  `sterilization` tinyint(1) DEFAULT NULL COMMENT '是否绝育',
  `bear` tinyint(1) DEFAULT NULL COMMENT '是否生育',
  `img_urls` varchar(255) DEFAULT NULL COMMENT '宠物图片(json数组)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_pet` */

insert  into `t_pet` values
(1,'2020-08-01','2020-08-01',NULL,NULL,0,'shasha','中华田园猫',0,0,0,0,0,0,'[\"string\"]');

/*Table structure for table `t_purchase_history` */

DROP TABLE IF EXISTS `t_purchase_history`;

CREATE TABLE `t_purchase_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除',
  `price` int(11) DEFAULT NULL COMMENT '价格',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `channel` varchar(127) DEFAULT NULL COMMENT '渠道',
  `gmt_expire` date DEFAULT NULL COMMENT '到期日',
  `gmt_buy` date DEFAULT NULL COMMENT '购买日期',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `gmt_open` date DEFAULT NULL COMMENT '开袋时间',
  `left_days` int(11) DEFAULT NULL COMMENT '剩余天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_purchase_history` */

insert  into `t_purchase_history` values
(6,'2020-08-04','2020-08-04',NULL,NULL,0,1000,5,'tianMao',NULL,'2019-12-29',1,10,NULL,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `gmt_create` date DEFAULT NULL COMMENT '数据的创建时间',
  `gmt_update` date DEFAULT NULL COMMENT '数据的更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '数据的创建者',
  `updater` bigint(20) DEFAULT NULL COMMENT '数据的更新者',
  `deleted` tinyint(1) NOT NULL COMMENT '删除',
  `nick_name` varchar(127) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(127) DEFAULT NULL COMMENT '头像地址',
  `wx_num` varchar(127) DEFAULT NULL COMMENT '微信号',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `pet_food_consumption` int(11) DEFAULT NULL COMMENT '猫粮使用量（一天）',
  `pet_litter_consumption` int(11) DEFAULT NULL COMMENT '猫砂使用量（一天）',
  `pet_snack_consumption` int(11) DEFAULT NULL COMMENT '零食使用量（一天）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user` */

insert  into `t_user` values
(4,'2020-07-31','2020-07-31',NULL,NULL,0,'admin','www.baidu.com','','',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
