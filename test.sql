/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-04-26 20:54:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for absence
-- ----------------------------
DROP TABLE IF EXISTS `absence`;
CREATE TABLE `absence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dormNumber` int(11) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of absence
-- ----------------------------

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `maxNumber` int(11) DEFAULT NULL,
  `currentNumber` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of building
-- ----------------------------

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dormNumber` int(11) DEFAULT NULL,
  `maxNumber` int(11) DEFAULT NULL,
  `currentNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dorm
-- ----------------------------

-- ----------------------------
-- Table structure for dormadmin
-- ----------------------------
DROP TABLE IF EXISTS `dormadmin`;
CREATE TABLE `dormadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dormadmin
-- ----------------------------

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `getDate` date DEFAULT NULL,
  `studentNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of express
-- ----------------------------

-- ----------------------------
-- Table structure for flats
-- ----------------------------
DROP TABLE IF EXISTS `flats`;
CREATE TABLE `flats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of flats
-- ----------------------------

-- ----------------------------
-- Table structure for hygienism
-- ----------------------------
DROP TABLE IF EXISTS `hygienism`;
CREATE TABLE `hygienism` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dormNumber` int(11) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hygienism
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dormNumber` int(11) DEFAULT NULL,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `goodsNumber` int(11) DEFAULT NULL,
  `cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `submitDate` date DEFAULT NULL,
  `doneDate` date DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of repair
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `studentNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `flatsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dormNumber` int(11) DEFAULT NULL,
  `inDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', 'xiaoming', '小明', '1', '18', 'A1001', '1237981236', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `identify` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'xiaoming', '333', 'student');
INSERT INTO `user` VALUES ('5', 'tom', '666', 'student');
