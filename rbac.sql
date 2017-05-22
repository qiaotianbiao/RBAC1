/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50545
Source Host           : 127.0.0.1:3306
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2017-05-16 13:00:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for limitt
-- ----------------------------
DROP TABLE IF EXISTS `limitt`;
CREATE TABLE `limitt` (
  `id` int(11) NOT NULL,
  `action` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of limitt
-- ----------------------------
INSERT INTO `limitt` VALUES ('1', '1');
INSERT INTO `limitt` VALUES ('2', '2');
INSERT INTO `limitt` VALUES ('3', '3');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1');
INSERT INTO `role` VALUES ('2', '2');
INSERT INTO `role` VALUES ('3', '3');

-- ----------------------------
-- Table structure for role_limit
-- ----------------------------
DROP TABLE IF EXISTS `role_limit`;
CREATE TABLE `role_limit` (
  `id` int(11) NOT NULL,
  `roleid` int(11) DEFAULT NULL,
  `limitid` int(11) DEFAULT NULL,
  KEY `roleid` (`roleid`),
  KEY `limitid` (`limitid`),
  CONSTRAINT `role_limit_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_limit_ibfk_2` FOREIGN KEY (`limitid`) REFERENCES `limitt` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_limit
-- ----------------------------
INSERT INTO `role_limit` VALUES ('1', '1', '1');
INSERT INTO `role_limit` VALUES ('2', '2', '2');
INSERT INTO `role_limit` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'qtb', 'qtb');
INSERT INTO `user` VALUES ('2', 'yjw', 'yjw');
INSERT INTO `user` VALUES ('3', 'lfy', 'lfy');
INSERT INTO `user` VALUES ('4', 'wps', 'wps');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `userid` (`userid`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '3');
INSERT INTO `user_role` VALUES ('2', '2', '3');
INSERT INTO `user_role` VALUES ('3', '3', '2');
INSERT INTO `user_role` VALUES ('4', '4', '1');
