/*
Navicat MySQL Data Transfer

Source Server         : Michelle
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : newcdstore

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2015-10-13 19:18:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addrid` bigint(20) NOT NULL AUTO_INCREMENT,
  `addrline1` varchar(255) DEFAULT NULL,
  `addrline2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL DEFAULT 'Canada',
  `phone` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`addrid`),
  KEY `userid` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billid` bigint(20) NOT NULL AUTO_INCREMENT,
  `Addrline1` varchar(255) NOT NULL,
  `Addrline2` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL DEFAULT '',
  `zipcode` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`billid`),
  KEY `customer` (`userid`),
  CONSTRAINT `customer` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cateid` bigint(20) NOT NULL AUTO_INCREMENT,
  `catename` varchar(255) NOT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `cd`
-- ----------------------------
DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `cdid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  `imgurl` varchar(255) NOT NULL,
  `cateid` bigint(20) NOT NULL,
  PRIMARY KEY (`cdid`),
  KEY `cateid` (`cateid`),
  CONSTRAINT `cateid` FOREIGN KEY (`cateid`) REFERENCES `category` (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cd
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '123', 'zhang', 'zhibo', 'zhibo_zhang@yahoo.com', 'female');
INSERT INTO `customer` VALUES ('2', '123', 'wenqian', 'wang', 'wenqianwang@yahoo.com', 'male');

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `itemsid` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  `orderid` bigint(20) NOT NULL,
  `cdid` bigint(20) NOT NULL,
  PRIMARY KEY (`itemsid`),
  KEY `order_item` (`orderid`),
  KEY `cd_item` (`cdid`),
  CONSTRAINT `cd_item` FOREIGN KEY (`cdid`) REFERENCES `cd` (`cdid`),
  CONSTRAINT `order_item` FOREIGN KEY (`orderid`) REFERENCES `order` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `status` char(255) NOT NULL,
  `total` float NOT NULL,
  `userid` bigint(20) NOT NULL,
  `addrid` bigint(20) NOT NULL,
  `shipid` bigint(20) NOT NULL,
  `taxid` bigint(20) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `user_cus` (`userid`),
  KEY `add_cus` (`addrid`),
  KEY `ship_cus` (`shipid`),
  KEY `tax_cus` (`taxid`),
  CONSTRAINT `add_cus` FOREIGN KEY (`addrid`) REFERENCES `address` (`addrid`),
  CONSTRAINT `ship_cus` FOREIGN KEY (`shipid`) REFERENCES `shipping` (`shipid`),
  CONSTRAINT `tax_cus` FOREIGN KEY (`taxid`) REFERENCES `tax` (`taxid`),
  CONSTRAINT `user_cus` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `shipping`
-- ----------------------------
DROP TABLE IF EXISTS `shipping`;
CREATE TABLE `shipping` (
  `shipid` bigint(20) NOT NULL AUTO_INCREMENT,
  `method` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`shipid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipping
-- ----------------------------

-- ----------------------------
-- Table structure for `tax`
-- ----------------------------
DROP TABLE IF EXISTS `tax`;
CREATE TABLE `tax` (
  `taxid` bigint(20) NOT NULL AUTO_INCREMENT,
  `taxname` varchar(255) NOT NULL,
  `taxrate` varchar(255) NOT NULL,
  PRIMARY KEY (`taxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tax
-- ----------------------------
