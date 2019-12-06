# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: greens
# ------------------------------------------------------
# Server version 5.1.42-community

DROP DATABASE IF EXISTS `greens`;
CREATE DATABASE `greens` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `greens`;

#
# Source for table address
#

CREATE TABLE `address` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `consignee` varchar(80) NOT NULL,
  `telNumber` varchar(80) NOT NULL,
  `provinceName` varchar(80) NOT NULL,
  `cityName` varchar(80) NOT NULL,
  `districtName` varchar(80) NOT NULL,
  `detailInfo` varchar(80) DEFAULT NULL,
  `uid` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table address
#
LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;

INSERT INTO `address` VALUES (1,'徐行','1234566','重庆市','重庆市','渝中区','重庆工程学院',1);
INSERT INTO `address` VALUES (2,'胖子','1234567','重庆市','重庆市','渝中区','重庆理工大学',1);
INSERT INTO `address` VALUES (3,'张维泽','123456789','北京市','北京市','东城区','医药学院',1);
INSERT INTO `address` VALUES (7,'钢门','12345678','重庆市','重庆市','巴南区','你在哪个地方？',1);
INSERT INTO `address` VALUES (9,'张涛','1235778','重庆市','重庆市','大足区','龙水',1);
INSERT INTO `address` VALUES (10,'张三','13193066812','重庆市','重庆市','大足区','宏城广场',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table comment
#

CREATE TABLE `comment` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `userPic` varchar(255) NOT NULL DEFAULT '',
  `userComment` varchar(255) NOT NULL,
  `Likes` varchar(50) DEFAULT '0',
  `isGave` varchar(20) DEFAULT '0',
  `judge` int(4) NOT NULL DEFAULT '0',
  `commentTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Dumping data for table comment
#
LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;

INSERT INTO `comment` VALUES (1,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','哈哈哈哈超级好吃哦','4','0',0,'2019-07-04 14:41:17');
INSERT INTO `comment` VALUES (2,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','啊哈哈哈哈疯狂杀跌离开超级发李开复但是了多少积分考虑考虑去玩呢强奸了额据权威回去我i额欧文企鹅','0','0',0,'2019-07-11 15:50:00');
INSERT INTO `comment` VALUES (3,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','冷却降温哦亲我且请问卡拉卡斯','2','0',0,'2019-07-05 14:41:17');
INSERT INTO `comment` VALUES (4,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','超级好吃啊啊啊啊啊啥哈哈哈哈哈哈哈哈窃取我唔哦呢亲我','1','0',0,'2019-07-02 14:41:17');
INSERT INTO `comment` VALUES (5,'零三分','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','加强恩录取为两千而且','1','0',0,'2019-07-12 16:29:48');
INSERT INTO `comment` VALUES (6,'我','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','每次迫切尔皮克蔷薇科目前为','1','0',0,'2019-07-12 16:30:13');
INSERT INTO `comment` VALUES (7,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','哈哈哈','1','0',0,'2019-07-12 21:43:26');
INSERT INTO `comment` VALUES (8,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','真的超级好吃','0','0',0,'2019-07-12 21:44:20');
INSERT INTO `comment` VALUES (9,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','情况较为强烈可能开发的说法加哦就群殴盘文件前为的萨芬啊','8','0',0,'2019-07-12 21:46:07');
INSERT INTO `comment` VALUES (10,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','就爱看','24','0',0,'2019-07-12 21:55:45');
INSERT INTO `comment` VALUES (11,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','dsf ','48','0',0,'2019-07-13 01:49:40');
INSERT INTO `comment` VALUES (12,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','案发当时','1','0',0,'2019-07-15 16:14:20');
INSERT INTO `comment` VALUES (13,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','方法','3','0',0,'2019-07-15 16:31:03');
INSERT INTO `comment` VALUES (14,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','看见七五九二七五你','1','0',0,'2019-07-16 13:59:31');
INSERT INTO `comment` VALUES (15,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','发大水',NULL,'0',0,'2019-09-02 00:01:10');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu
#

CREATE TABLE `ex_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `typePic` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu
#
LOCK TABLES `ex_menu` WRITE;
/*!40000 ALTER TABLE `ex_menu` DISABLE KEYS */;

INSERT INTO `ex_menu` VALUES (1,'川菜','menu.pic',1);
INSERT INTO `ex_menu` VALUES (2,'鲁菜','menu.pic',4);
INSERT INTO `ex_menu` VALUES (3,'苏菜','menu.pic',3);
INSERT INTO `ex_menu` VALUES (4,'粤菜','menu.pic',2);
INSERT INTO `ex_menu` VALUES (5,'甜品','menu.pic',5);
/*!40000 ALTER TABLE `ex_menu` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_allfoot
#

CREATE TABLE `ex_menu_allfoot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) NOT NULL,
  `productId` varchar(30) NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT '0',
  `productPic` varchar(255) NOT NULL,
  `type` char(20) NOT NULL DEFAULT '',
  `isBuy` int(4) DEFAULT '0',
  `buycount` int(10) DEFAULT '0',
  `isFinish` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

#
# Dumping data for table ex_menu_allfoot
#
LOCK TABLES `ex_menu_allfoot` WRITE;
/*!40000 ALTER TABLE `ex_menu_allfoot` DISABLE KEYS */;

INSERT INTO `ex_menu_allfoot` VALUES (1,'鸭血毛肚血旺','1',12.5,5,'chuancai1.jpg','1',0,0,0);
INSERT INTO `ex_menu_allfoot` VALUES (2,'宫爆鸡丁','3',22,5,'chuancai2.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (3,'鱼香肉丝','4',16,5,'chuancai3.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (4,'麻婆豆腐','5',24,5,'chuancai4.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (5,'回锅肉','6',21,5,'chuancai5.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (6,'夫妻肺片','7',22.5,5,'chuancai6.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (7,'辣子鸡丁','8',31,5,'chuancai7.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (8,'水煮肉片','2',30,5,'chuancai8.jpg','1',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (9,'烩乌鱼蛋汤','9',21,5,'lucai1.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (10,'油爆双脆','10',2,5,'lucai2.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (11,'蟹黄鱼翅','11',3,5,'lucai3.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (12,'清汤西施舌','12',4,5,'lucai4.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (13,'奶汤核桃肉','13',4,5,'lucai5.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (14,'九转大肠','14',2,5,'lucai6.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (15,'扒原壳鲍鱼','15',3,5,'lucai7.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (16,'清汤银耳','16',4,5,'lucai8.jpg','4',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (17,'狮子头','17',4,5,'sucai1.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (18,'清炖蟹粉狮子头','18',2,5,'sucai2.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (19,'清蒸鲥鱼','19',3,5,'sucai3.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (20,'双皮刀鱼','20',4,5,'sucai4.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (21,'盐水鸭','21',4,5,'sucai5.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (22,'镇江肴蹄','22',2,5,'sucai6.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (23,'松鼠鳜鱼','23',3,5,'sucai7.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (24,'清汤银耳','24',4,5,'sucai8.jpg','3',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (25,'烟筒白菜','25',4,5,'yuecai1.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (26,'鱼头豆腐汤','26',2,5,'yuecai2.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (27,'盐焗鸡','27',3,5,'yuecai3.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (28,'香煎芙蓉蛋','28',4,5,'yuecai4.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (29,'煲仔饭','29',4,5,'yuecai5.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (30,'梅菜扣肉','30',2,5,'yuecai6.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (31,'广州文昌鸡','31',3,5,'yuecai7.jpg','2',0,0,1);
INSERT INTO `ex_menu_allfoot` VALUES (32,'南乳粗斋煲','32',4,5,'yuecai8.jpg','2',0,0,1);
/*!40000 ALTER TABLE `ex_menu_allfoot` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_chuancai
#

CREATE TABLE `ex_menu_chuancai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `isBuy` int(4) DEFAULT '0',
  `buycount` int(10) DEFAULT '0',
  `isFinish` int(4) DEFAULT '1',
  `type` varchar(4) COLLATE utf8_unicode_ci DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu_chuancai
#
LOCK TABLES `ex_menu_chuancai` WRITE;
/*!40000 ALTER TABLE `ex_menu_chuancai` DISABLE KEYS */;

INSERT INTO `ex_menu_chuancai` VALUES (1,'鸭血毛肚血旺','1',12.5,5,'chuancai1.jpg',0,0,0,'1');
INSERT INTO `ex_menu_chuancai` VALUES (2,'宫爆鸡丁','3',22,5,'chuancai2.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (3,'鱼香肉丝','4',16,5,'chuancai3.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (4,'麻婆豆腐','5',24,5,'chuancai4.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (5,'回锅肉','6',21,5,'chuancai5.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (6,'夫妻肺片','7',22.5,5,'chuancai6.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (7,'辣子鸡丁','8',31,5,'chuancai7.jpg',0,0,1,'1');
INSERT INTO `ex_menu_chuancai` VALUES (8,'水煮肉片','2',30,5,'chuancai8.jpg',0,0,1,'1');
/*!40000 ALTER TABLE `ex_menu_chuancai` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_dessert
#

CREATE TABLE `ex_menu_dessert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `surplus` int(11) DEFAULT NULL,
  `buycount` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu_dessert
#
LOCK TABLES `ex_menu_dessert` WRITE;
/*!40000 ALTER TABLE `ex_menu_dessert` DISABLE KEYS */;

INSERT INTO `ex_menu_dessert` VALUES (1,'奶油泡芙','33',4,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (2,'鲜奶吐司','34',2,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (3,'冰淇淋奶酪','35',3,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (4,'果仁布朗尼','36',4,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (5,'巧克力奶昔','37',4,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (6,'巧克力曲奇','38',2,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (7,'香草冰淇淋','39',3,5,'dessert.jpg',10,0);
INSERT INTO `ex_menu_dessert` VALUES (8,'嘉莉朵','40',4,5,'dessert.jpg',10,0);
/*!40000 ALTER TABLE `ex_menu_dessert` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_lucai
#

CREATE TABLE `ex_menu_lucai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `buycount` int(10) DEFAULT '0',
  `isBuy` int(4) DEFAULT '0',
  `isFinish` varchar(20) COLLATE utf8_unicode_ci DEFAULT '1',
  `type` varchar(4) COLLATE utf8_unicode_ci DEFAULT '4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu_lucai
#
LOCK TABLES `ex_menu_lucai` WRITE;
/*!40000 ALTER TABLE `ex_menu_lucai` DISABLE KEYS */;

INSERT INTO `ex_menu_lucai` VALUES (1,'烩乌鱼蛋汤','9',21,5,'lucai1.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (2,'油爆双脆','10',2,5,'lucai2.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (3,'蟹黄鱼翅','11',3,5,'lucai3.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (4,'清汤西施舌','12',4,5,'lucai4.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (5,'奶汤核桃肉','13',4,5,'lucai5.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (6,'九转大肠','14',2,5,'lucai6.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (7,'扒原壳鲍鱼','15',3,5,'lucai7.jpg',0,0,'1','4');
INSERT INTO `ex_menu_lucai` VALUES (8,'清汤银耳','16',4,5,'lucai8.jpg',0,0,'1','4');
/*!40000 ALTER TABLE `ex_menu_lucai` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_sucai
#

CREATE TABLE `ex_menu_sucai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `buycount` int(10) DEFAULT '0',
  `isBuy` int(4) DEFAULT '0',
  `isFinish` varchar(20) COLLATE utf8_unicode_ci DEFAULT '1',
  `type` varchar(4) COLLATE utf8_unicode_ci DEFAULT '3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu_sucai
#
LOCK TABLES `ex_menu_sucai` WRITE;
/*!40000 ALTER TABLE `ex_menu_sucai` DISABLE KEYS */;

INSERT INTO `ex_menu_sucai` VALUES (1,'狮子头','17',4,5,'sucai1.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (2,'清炖蟹粉狮子头','18',2,5,'sucai2.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (3,'清蒸鲥鱼','19',3,5,'sucai3.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (4,'双皮刀鱼','20',4,5,'sucai4.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (5,'盐水鸭','21',4,5,'sucai5.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (6,'镇江肴蹄','22',2,5,'sucai6.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (7,'松鼠鳜鱼','23',3,5,'sucai7.jpg',0,0,'1','3');
INSERT INTO `ex_menu_sucai` VALUES (8,'清汤银耳','24',4,5,'sucai8.jpg',0,0,'1','3');
/*!40000 ALTER TABLE `ex_menu_sucai` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_menu_yuecai
#

CREATE TABLE `ex_menu_yuecai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productId` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `isBuy` int(4) DEFAULT '0',
  `buycount` int(10) DEFAULT '0',
  `isFinish` varchar(20) COLLATE utf8_unicode_ci DEFAULT '1',
  `type` varchar(4) COLLATE utf8_unicode_ci DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_menu_yuecai
#
LOCK TABLES `ex_menu_yuecai` WRITE;
/*!40000 ALTER TABLE `ex_menu_yuecai` DISABLE KEYS */;

INSERT INTO `ex_menu_yuecai` VALUES (1,'烟筒白菜','25',4,5,'yuecai1.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (2,'鱼头豆腐汤','26',2,5,'yuecai2.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (3,'盐焗鸡','27',3,5,'yuecai3.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (4,'香煎芙蓉蛋','28',4,5,'yuecai4.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (5,'煲仔饭','29',4,5,'yuecai5.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (6,'梅菜扣肉','30',2,5,'yuecai6.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (7,'广州文昌鸡','31',3,5,'yuecai7.jpg',0,0,'1','2');
INSERT INTO `ex_menu_yuecai` VALUES (8,'南乳粗斋煲','32',4,5,'yuecai8.jpg',0,0,'1','2');
/*!40000 ALTER TABLE `ex_menu_yuecai` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_order
#

CREATE TABLE `ex_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `orderState` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `totalCount` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT '0.00',
  `orderDeskNumber` int(11) DEFAULT '1',
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '无',
  `orderConsignee` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `isAcept` int(4) DEFAULT '0',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '0',
  `isFinish` int(4) DEFAULT '0',
  `createOrderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_order
#
LOCK TABLES `ex_order` WRITE;
/*!40000 ALTER TABLE `ex_order` DISABLE KEYS */;

INSERT INTO `ex_order` VALUES (1,'D2019070400345725477779453834080','未付款','4',64,1,'无','.',0,'0',0,'2019-07-04 00:35:04');
INSERT INTO `ex_order` VALUES (2,'D2019070400361949977779573347875','已付款','10',147,1,'无','.',0,'无',0,'2019-07-04 00:36:31');
INSERT INTO `ex_order` VALUES (3,'D2019070400413554677779529189791','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 00:41:41');
INSERT INTO `ex_order` VALUES (4,'D2019070400420637177779808553592','未付款','1',22,1,'无','.',0,'0',0,'2019-07-04 00:42:11');
INSERT INTO `ex_order` VALUES (5,'D2019070400425780777779311467538','未付款','5',101,1,'无','.',0,'0',0,'2019-07-04 00:43:03');
INSERT INTO `ex_order` VALUES (6,'D2019070414272641977779244477241','已付款','6',137.5,1,'胖子  1234567  重庆市重庆市渝中区重庆理工大学','.',0,'超级辣',0,'2019-07-04 14:27:49');
INSERT INTO `ex_order` VALUES (7,'D2019070414283478177779135804375','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:28:58');
INSERT INTO `ex_order` VALUES (8,'D2019070414314019877779411672897','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:31:44');
INSERT INTO `ex_order` VALUES (9,'D2019070414321694177779364877502','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:32:20');
INSERT INTO `ex_order` VALUES (10,'D2019070414324666777779526555384','未付款','7',156,1,'无','.',0,'0',0,'2019-07-04 14:33:10');
INSERT INTO `ex_order` VALUES (11,'D2019070414371147977779304728188','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:37:15');
INSERT INTO `ex_order` VALUES (12,'D2019070414411386477779192090800','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:41:17');
INSERT INTO `ex_order` VALUES (13,'D2019070414415005377779237904834','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:41:55');
INSERT INTO `ex_order` VALUES (14,'D2019070414445215677779246237293','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:44:55');
INSERT INTO `ex_order` VALUES (15,'D2019070414451833677779862755701','未付款','0',0,1,'无','.',0,'0',0,'2019-07-04 14:45:28');
INSERT INTO `ex_order` VALUES (16,'D2019070414454998577779403731362','已付款','8',73.5,1,'胖子  1234567  重庆市重庆市渝中区重庆理工大学','.',0,'超级辣',0,'2019-07-04 14:45:56');
INSERT INTO `ex_order` VALUES (17,'D2019070612304749277779644961158','未付款','2',43.5,1,'无','.',0,'0',0,'2019-07-06 12:34:01');
INSERT INTO `ex_order` VALUES (18,'D2019070615015050677779379186970','已付款','5',80,1,'胖子  1234567  重庆市重庆市渝中区重庆理工大学','.',0,'超级辣',0,'2019-07-06 15:02:05');
INSERT INTO `ex_order` VALUES (19,'D2019071001225160677779290281111','已付款','16',180,1,'undefined  undefined  undefinedundefinedundefinedundefined','.',0,'无',0,'2019-07-10 01:23:15');
INSERT INTO `ex_order` VALUES (20,'D2019071001253247977779495465925','已付款','5',15,1,'无','.',0,'无',0,'2019-07-10 01:25:43');
INSERT INTO `ex_order` VALUES (21,'D2019071001255869377779567925649','已付款','5',20,1,'胖子  1234567  重庆市重庆市渝中区重庆理工大学','.',0,'0',0,'2019-07-10 01:28:07');
INSERT INTO `ex_order` VALUES (22,'D2019071001282685477779180230902','未付款','1',21,1,'无','.',0,'0',0,'2019-07-10 01:28:34');
INSERT INTO `ex_order` VALUES (23,'D2019071001295909277779550159874','未付款','2',40,1,'无','.',0,'0',0,'2019-07-10 01:38:36');
INSERT INTO `ex_order` VALUES (24,'D2019071517035277677779621095056','未付款','2',8,1,'无','.',0,'0',0,'2019-07-15 17:04:00');
INSERT INTO `ex_order` VALUES (25,'D2019071613544635377779154050259','已付款','11',70,1,'无','.',0,'超级辣',0,'2019-07-16 13:55:02');
INSERT INTO `ex_order` VALUES (26,'D2019071613552494477779300179481','已付款','2',45,1,'张维泽  123456789  北京市北京市东城区医药学院','.',0,'无',0,'2019-07-16 13:55:51');
INSERT INTO `ex_order` VALUES (27,'D2019072116165523477779199862564','未付款','6',41,1,'无','.',0,'0',0,'2019-07-21 16:25:44');
INSERT INTO `ex_order` VALUES (28,'D2019072116165523477779199862564','未付款','6',41,1,'无','.',0,'0',0,'2019-07-21 16:25:44');
INSERT INTO `ex_order` VALUES (29,'D2019090312250789477779237992818','已付款','4',14,1,'胖子  1234567  重庆市重庆市渝中区重庆理工大学','.',0,'无',0,'2019-09-03 12:25:28');
INSERT INTO `ex_order` VALUES (30,'D2019090410215853377779555796085','已付款','1',3,1,'张维泽  123456789  北京市北京市东城区医药学院','.',0,'无',0,'2019-09-04 10:22:30');
INSERT INTO `ex_order` VALUES (31,'D2019090410241266377779791939788','未付款','2',45,1,'无','.',0,'0',0,'2019-09-04 10:24:15');
INSERT INTO `ex_order` VALUES (32,'D2019090410262708377779747149561','已付款','1',31,1,'张维泽  123456789  北京市北京市东城区医药学院','.',0,'0',0,'2019-09-04 10:27:15');
INSERT INTO `ex_order` VALUES (33,'D2019090410272583777779486392102','未付款','0',0,1,'无','.',0,'0',0,'2019-09-04 10:30:56');
/*!40000 ALTER TABLE `ex_order` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_order_detail
#

CREATE TABLE `ex_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `productName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `productPrice` decimal(10,2) NOT NULL,
  `productCount` int(4) DEFAULT '1',
  `productPic` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `productDiscount` int(11) DEFAULT NULL,
  `TotalPrice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table ex_order_detail
#
LOCK TABLES `ex_order_detail` WRITE;
/*!40000 ALTER TABLE `ex_order_detail` DISABLE KEYS */;

INSERT INTO `ex_order_detail` VALUES (1,'D2019070400345725477779453834080',1,4,'鱼香肉丝',16,4,'chuancai3.jpg',0,64);
INSERT INTO `ex_order_detail` VALUES (5,'D2019070400361949977779573347875',2,5,'麻婆豆腐',24,2,'chuancai4.jpg',0,48);
INSERT INTO `ex_order_detail` VALUES (6,'D2019070400361949977779573347875',2,7,'夫妻肺片',22.5,2,'chuancai6.jpg',0,45);
INSERT INTO `ex_order_detail` VALUES (7,'D2019070400361949977779573347875',2,6,'回锅肉',21,2,'chuancai5.jpg',0,42);
INSERT INTO `ex_order_detail` VALUES (8,'D2019070400361949977779573347875',2,29,'煲仔饭',4,2,'yuecai5.jpg',0,8);
INSERT INTO `ex_order_detail` VALUES (9,'D2019070400361949977779573347875',2,30,'梅菜扣肉',2,2,'yuecai6.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (12,'D2019070400420637177779808553592',4,3,'宫爆鸡丁',22,1,'chuancai2.jpg',0,22);
INSERT INTO `ex_order_detail` VALUES (13,'D2019070400425780777779311467538',5,5,'麻婆豆腐',24,2,'chuancai4.jpg',0,48);
INSERT INTO `ex_order_detail` VALUES (14,'D2019070400425780777779311467538',5,4,'鱼香肉丝',16,2,'chuancai3.jpg',0,32);
INSERT INTO `ex_order_detail` VALUES (16,'D2019070400425780777779311467538',5,6,'回锅肉',21,1,'chuancai5.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (17,'D2019070414272641977779244477241',6,7,'夫妻肺片',22.5,1,'chuancai6.jpg',0,22.5);
INSERT INTO `ex_order_detail` VALUES (18,'D2019070414272641977779244477241',6,8,'辣子鸡丁',31,1,'chuancai7.jpg',0,31);
INSERT INTO `ex_order_detail` VALUES (19,'D2019070414272641977779244477241',6,6,'回锅肉',21,4,'chuancai5.jpg',0,84);
INSERT INTO `ex_order_detail` VALUES (24,'D2019070414324666777779526555384',10,6,'回锅肉',21,4,'chuancai5.jpg',0,84);
INSERT INTO `ex_order_detail` VALUES (25,'D2019070414324666777779526555384',10,5,'麻婆豆腐',24,3,'chuancai4.jpg',0,72);
INSERT INTO `ex_order_detail` VALUES (34,'D2019070414454998577779403731362',16,7,'夫妻肺片',22.5,1,'chuancai6.jpg',0,22.5);
INSERT INTO `ex_order_detail` VALUES (35,'D2019070414454998577779403731362',16,8,'辣子鸡丁',31,1,'chuancai7.jpg',0,31);
INSERT INTO `ex_order_detail` VALUES (36,'D2019070414454998577779403731362',16,21,'盐水鸭',4,1,'sucai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (37,'D2019070414454998577779403731362',16,20,'双皮刀鱼',4,1,'sucai4.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (38,'D2019070414454998577779403731362',16,19,'清蒸鲥鱼',3,4,'sucai3.jpg',0,12);
INSERT INTO `ex_order_detail` VALUES (39,'D2019070612304749277779644961158',17,1,'鸭血毛肚血旺',21.5,1,'chuancai1.jpg',0,21.5);
INSERT INTO `ex_order_detail` VALUES (40,'D2019070612304749277779644961158',17,3,'宫爆鸡丁',22,1,'chuancai2.jpg',0,22);
INSERT INTO `ex_order_detail` VALUES (41,'D2019070615015050677779379186970',18,29,'煲仔饭',4,1,'yuecai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (42,'D2019070615015050677779379186970',18,28,'香煎芙蓉蛋',4,1,'yuecai4.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (43,'D2019070615015050677779379186970',18,5,'麻婆豆腐',24,3,'chuancai4.jpg',0,72);
INSERT INTO `ex_order_detail` VALUES (44,'D2019071001225160677779290281111',19,5,'麻婆豆腐',24,1,'chuancai4.jpg',0,24);
INSERT INTO `ex_order_detail` VALUES (45,'D2019071001225160677779290281111',19,6,'回锅肉',21,1,'chuancai5.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (46,'D2019071001225160677779290281111',19,3,'宫爆鸡丁',22,1,'chuancai2.jpg',0,22);
INSERT INTO `ex_order_detail` VALUES (47,'D2019071001225160677779290281111',19,8,'辣子鸡丁',31,1,'chuancai7.jpg',0,31);
INSERT INTO `ex_order_detail` VALUES (48,'D2019071001225160677779290281111',19,2,'水煮肉片',30,1,'chuancai8.jpg',0,30);
INSERT INTO `ex_order_detail` VALUES (49,'D2019071001225160677779290281111',19,19,'清蒸鲥鱼',3,1,'sucai3.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (50,'D2019071001225160677779290281111',19,18,'清炖蟹粉狮子头',2,1,'sucai2.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (51,'D2019071001225160677779290281111',19,17,'狮子头',4,1,'sucai1.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (52,'D2019071001225160677779290281111',19,11,'蟹黄鱼翅',3,1,'lucai3.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (53,'D2019071001225160677779290281111',19,13,'奶汤核桃肉',4,1,'lucai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (54,'D2019071001225160677779290281111',19,14,'九转大肠',2,1,'lucai6.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (55,'D2019071001225160677779290281111',19,9,'烩乌鱼蛋汤',21,1,'lucai1.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (56,'D2019071001225160677779290281111',19,26,'鱼头豆腐汤',2,1,'yuecai2.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (57,'D2019071001225160677779290281111',19,25,'烟筒白菜',4,1,'yuecai1.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (58,'D2019071001225160677779290281111',19,29,'煲仔饭',4,1,'yuecai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (59,'D2019071001225160677779290281111',19,31,'广州文昌鸡',3,1,'yuecai7.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (60,'D2019071001253247977779495465925',20,25,'烟筒白菜',4,1,'yuecai1.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (61,'D2019071001253247977779495465925',20,26,'鱼头豆腐汤',2,1,'yuecai2.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (62,'D2019071001253247977779495465925',20,27,'盐焗鸡',3,1,'yuecai3.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (63,'D2019071001253247977779495465925',20,29,'煲仔饭',4,1,'yuecai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (64,'D2019071001253247977779495465925',20,30,'梅菜扣肉',2,1,'yuecai6.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (65,'D2019071001255869377779567925649',21,28,'香煎芙蓉蛋',4,1,'yuecai4.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (66,'D2019071001255869377779567925649',21,29,'煲仔饭',4,4,'yuecai5.jpg',0,16);
INSERT INTO `ex_order_detail` VALUES (67,'D2019071001282685477779180230902',22,6,'回锅肉',21,1,'chuancai5.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (68,'D2019071001295909277779550159874',23,4,'鱼香肉丝',16,1,'chuancai3.jpg',0,16);
INSERT INTO `ex_order_detail` VALUES (69,'D2019071001295909277779550159874',23,5,'麻婆豆腐',24,1,'chuancai4.jpg',0,24);
INSERT INTO `ex_order_detail` VALUES (70,'D2019071517035277677779621095056',24,28,'香煎芙蓉蛋',4,1,'yuecai4.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (71,'D2019071517035277677779621095056',24,29,'煲仔饭',4,1,'yuecai5.jpg',0,4);
INSERT INTO `ex_order_detail` VALUES (72,'D2019071613544635377779154050259',25,20,'双皮刀鱼',4,5,'sucai4.jpg',0,20);
INSERT INTO `ex_order_detail` VALUES (73,'D2019071613544635377779154050259',25,19,'清蒸鲥鱼',3,4,'sucai3.jpg',0,12);
INSERT INTO `ex_order_detail` VALUES (74,'D2019071613544635377779154050259',25,3,'宫爆鸡丁',22,1,'chuancai2.jpg',0,22);
INSERT INTO `ex_order_detail` VALUES (75,'D2019071613544635377779154050259',25,4,'鱼香肉丝',16,1,'chuancai3.jpg',0,16);
INSERT INTO `ex_order_detail` VALUES (76,'D2019071613552494477779300179481',26,5,'麻婆豆腐',24,1,'chuancai4.jpg',0,24);
INSERT INTO `ex_order_detail` VALUES (77,'D2019071613552494477779300179481',26,6,'回锅肉',21,1,'chuancai5.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (78,'D2019072116165523477779199862564',27,1,'鸭血毛肚血旺',21.5,1,'chuancai1.jpg',0,21.5);
INSERT INTO `ex_order_detail` VALUES (79,'D2019072116165523477779199862564',27,3,'宫爆鸡丁',22,1,'chuancai2.jpg',0,22);
INSERT INTO `ex_order_detail` VALUES (80,'D2019072116165523477779199862564',27,27,'盐焗鸡',3,1,'yuecai3.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (81,'D2019072116165523477779199862564',27,28,'香煎芙蓉蛋',4,4,'yuecai4.jpg',0,16);
INSERT INTO `ex_order_detail` VALUES (82,'D2019090312250789477779237992818',29,30,'梅菜扣肉',2,1,'yuecai6.jpg',0,2);
INSERT INTO `ex_order_detail` VALUES (84,'D2019090312250789477779237992818',29,29,'煲仔饭',4,3,'yuecai5.jpg',0,12);
INSERT INTO `ex_order_detail` VALUES (86,'D2019090410215853377779555796085',30,27,'盐焗鸡',3,1,'yuecai3.jpg',0,3);
INSERT INTO `ex_order_detail` VALUES (87,'D2019090410241266377779791939788',31,5,'麻婆豆腐',24,1,'chuancai4.jpg',0,24);
INSERT INTO `ex_order_detail` VALUES (88,'D2019090410241266377779791939788',31,6,'回锅肉',21,1,'chuancai5.jpg',0,21);
INSERT INTO `ex_order_detail` VALUES (89,'D2019090410262708377779747149561',32,8,'辣子鸡丁',31,1,'chuancai7.jpg',0,31);
/*!40000 ALTER TABLE `ex_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ex_userinfo
#

CREATE TABLE `ex_userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(155) NOT NULL,
  `userpic` varchar(255) DEFAULT NULL,
  `province` varchar(155) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table ex_userinfo
#
LOCK TABLES `ex_userinfo` WRITE;
/*!40000 ALTER TABLE `ex_userinfo` DISABLE KEYS */;

INSERT INTO `ex_userinfo` VALUES (1,'.','https://wx.qlogo.cn/mmopen/vi_32/u5EWKPwCVhLe5RZqfcetZgiacibqGgiafJQibttsVd2TU6q6BB29ibnwLaJtqmO5IHbMICFhpx3pib2ADrc7o29Lr70w/132','重庆');
/*!40000 ALTER TABLE `ex_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table temporder
#

CREATE TABLE `temporder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `orderState` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `totalCount` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT '0.00',
  `orderDeskNumber` int(11) DEFAULT '1',
  `orderConsignee` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `isAcpet` int(4) DEFAULT '0',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '0',
  `createOrderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table temporder
#
LOCK TABLES `temporder` WRITE;
/*!40000 ALTER TABLE `temporder` DISABLE KEYS */;

/*!40000 ALTER TABLE `temporder` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
