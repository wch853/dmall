-- MySQL dump 10.13  Distrib 5.5.50, for Linux (x86_64)
--
-- Host: localhost    Database: dmall
-- ------------------------------------------------------
-- Server version	5.5.50

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
-- Current Database: `dmall`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `dmall` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dmall`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'adm853','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='客户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'wch853','123456'),(2,'aaaaaa','aaaaaa'),(8,'yyljmsoul','visualsoul'),(9,'123456','123456'),(11,'1234561','1234561'),(12,'zhangwen99','ZWsh2014'),(13,'z1a2q3','z1a2q3');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_`
--

DROP TABLE IF EXISTS `order_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `client_id` int(11) NOT NULL COMMENT '客户id',
  `order_price` int(11) NOT NULL COMMENT '订单总额',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_state` int(1) NOT NULL DEFAULT '1' COMMENT '订单状态',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_`
--

LOCK TABLES `order_` WRITE;
/*!40000 ALTER TABLE `order_` DISABLE KEYS */;
INSERT INTO `order_` VALUES (32,1,39561,'2017-06-12 11:09:31',2),(33,1,51600,'2017-06-12 13:00:15',2),(34,1,9396,'2017-06-13 09:13:58',2),(35,2,71712,'2017-06-14 08:14:44',2),(36,1,2988,'2017-06-15 03:21:01',2),(37,1,2988,'2017-06-15 03:21:32',2),(38,1,22796,'2017-06-15 08:09:59',2),(39,1,51596,'2017-06-20 02:33:22',2),(40,1,159236,'2017-06-20 10:35:11',2),(41,1,14663,'2017-06-26 06:45:19',2),(42,1,3659,'2017-06-26 07:18:45',2),(43,1,17097,'2017-06-26 09:25:50',2),(44,1,12899,'2017-07-25 06:08:51',1),(45,8,2988,'2017-08-10 03:47:00',1),(46,9,22343,'2017-08-29 00:27:40',1),(47,9,7047,'2017-08-29 00:32:22',1),(48,7,2988,'2017-08-30 00:15:28',1),(49,7,67483,'2017-08-30 01:21:55',1),(50,7,4896,'2017-08-30 01:49:33',1),(51,11,2988,'2017-09-15 02:09:40',1),(52,11,2988,'2017-09-15 02:10:11',1),(53,12,2988,'2017-09-15 02:36:01',1),(54,12,4819,'2017-09-15 02:41:41',1),(55,11,2988,'2017-09-15 03:53:16',1);
/*!40000 ALTER TABLE `order_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `order_id` int(11) DEFAULT NULL COMMENT '所属订单id',
  `client_id` int(11) NOT NULL COMMENT '订单项所属客户id',
  `product_id` int(11) NOT NULL COMMENT '所属商品id',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `order_item_price` int(11) DEFAULT '0' COMMENT '订单项价格',
  `pack_state` int(1) NOT NULL DEFAULT '1' COMMENT '订单项状态',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='订单项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (59,32,1,2,3,17097,2),(60,32,1,7,1,4819,2),(61,32,1,9,5,17645,2),(62,33,1,5,3,14688,2),(63,33,1,9,4,14116,2),(64,33,1,2,4,22796,2),(65,34,1,4,4,9396,2),(66,35,2,1,24,71712,2),(67,36,1,1,1,2988,2),(68,37,1,1,1,2988,2),(69,38,1,2,4,22796,2),(70,39,1,3,4,51596,2),(71,40,1,8,5,36345,2),(72,40,1,2,9,51291,2),(73,40,1,1,7,20916,2),(74,40,1,6,10,36590,2),(75,40,1,4,6,14094,2),(76,41,1,1,3,8964,2),(77,41,1,2,1,5699,2),(78,42,1,6,1,3659,2),(79,43,1,2,3,17097,2),(80,44,1,3,1,12899,2),(81,45,8,1,1,2988,2),(82,46,9,4,2,4698,2),(83,46,9,9,5,17645,2),(84,47,9,4,3,7047,2),(85,48,7,1,1,2988,2),(86,49,7,3,5,64495,2),(87,49,7,1,1,2988,2),(88,50,7,5,1,4896,2),(89,51,11,1,1,2988,2),(90,52,11,1,1,2988,2),(91,53,12,1,1,2988,2),(92,54,12,7,1,4819,2),(93,55,11,1,1,2988,2),(94,NULL,11,1,2,5976,1),(95,NULL,13,1,1,2988,1);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `product_price` int(11) NOT NULL COMMENT '商品价格',
  `storage` int(11) NOT NULL DEFAULT '0' COMMENT '商品库存数量',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'《锋利的jQuery》',2988,0),(2,'《管理信息系统》',5699,12),(3,'《Spring揭秘》',12899,0),(4,'《Bootstrap速查手册》',2349,0),(5,'《MyBtais从入门到精通》',4896,0),(6,'《Spring源码深度解析》',3659,0),(7,'《JavaScript权威指南》',4819,0),(8,'《UML系统分析与设计》',7269,0),(9,'《MySQL必知必会》',3529,0),(10,'《客户关系管理》',1288,0),(11,'《计算机网络》',4899,0),(12,'《操作系统》',9866,0),(13,'《深入了解计算机系统》',14899,0),(14,'《算法导论》',29866,0),(15,'《Java web入门指南》',4236,0),(16,'《数据结构与算法分析》',6899,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provider` (
  `provider_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
  `provider_name` varchar(255) NOT NULL COMMENT '供应商名称',
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT INTO `provider` VALUES (1,'南京万能百货有限公司'),(2,'江苏鹏程科技有限公司'),(3,'南京鼎捷教育有限公司');
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购订单编号',
  `provider_id` int(11) NOT NULL COMMENT '供应商编号',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `purchase_state` int(1) NOT NULL COMMENT '采购订单状态',
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='采购订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (16,2,'2017-06-12 10:59:00',2),(17,1,'2017-06-12 11:13:00',2),(18,2,'2017-06-12 13:05:56',2),(19,1,'2017-06-13 11:43:51',2),(20,3,'2017-06-13 11:46:04',2),(21,1,'2017-06-15 08:10:45',2),(22,1,'2017-06-15 12:31:57',2),(23,2,'2017-06-20 02:34:02',2),(24,2,'2017-06-20 10:52:32',2),(25,1,'2017-06-26 07:19:49',2),(26,2,'2017-06-26 09:26:33',2);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_item`
--

DROP TABLE IF EXISTS `purchase_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_item` (
  `purchase_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购订单项编号',
  `product_id` int(11) NOT NULL COMMENT '商品编号',
  `purchase_num` int(11) NOT NULL COMMENT '商品数量',
  `purchase_id` int(11) NOT NULL COMMENT '所属采购订单编号',
  `receive_num` int(11) NOT NULL DEFAULT '0' COMMENT '入库数量',
  PRIMARY KEY (`purchase_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='采购订单项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_item`
--

LOCK TABLES `purchase_item` WRITE;
/*!40000 ALTER TABLE `purchase_item` DISABLE KEYS */;
INSERT INTO `purchase_item` VALUES (39,1,20,16,20),(40,3,40,16,40),(41,4,60,16,60),(42,2,20,17,20),(43,7,40,17,40),(44,9,20,17,20),(45,2,20,18,20),(46,5,20,18,20),(47,9,20,18,20),(48,4,40,19,0),(49,4,20,20,20),(50,1,20,21,20),(51,1,20,22,19),(52,3,20,23,10),(53,2,20,24,18),(54,6,40,24,39),(55,8,60,24,45),(56,6,20,25,15),(57,2,20,26,15);
/*!40000 ALTER TABLE `purchase_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-06 22:46:33
