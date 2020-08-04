/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : db_fengmi

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-06-21 14:55:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '1a6f289c7062e373f28c7afe6a5132e6', '0');

-- ----------------------------
-- Table structure for `t_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('3', '4', '2', '1', '1');
INSERT INTO `t_cart` VALUES ('4', '5', '2', '1', '1');
INSERT INTO `t_cart` VALUES ('5', '4', '2', '2', '1');
INSERT INTO `t_cart` VALUES ('6', '4', '2', '1', '0');

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `score` int(11) DEFAULT '0',
  `deployDate` date DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('4', '小米pro222', '1998', '95', '2018-11-19', 'https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1542746180,3783070933&fm=179&app=42&f=JPEG?w=121&h=140', 'eeeee', '3');
INSERT INTO `t_goods` VALUES ('21', '小米9疯狂购物节特价机', '3545', '0', '2019-04-29', 'http://www.baidu.com', '小米9疯狂购物节特价机,好用', '8');
INSERT INTO `t_goods` VALUES ('28', '小米9疯狂购物节特价机', '6', '0', '2019-04-29', null, null, '4');
INSERT INTO `t_goods` VALUES ('29', '小米9疯狂购物节特价机', '7', '0', '2019-04-29', '0c008c22bcef457fabd5ff6f5529e984.jpg', 'sfdsfdsfds', '4');
INSERT INTO `t_goods` VALUES ('31', '小米9疯狂购物节特价机', '8', '0', '2019-04-29', null, null, '4');
INSERT INTO `t_goods` VALUES ('32', '小米9疯狂购物节特价机', '9', '0', '2019-04-29', null, null, '4');
INSERT INTO `t_goods` VALUES ('33', '小米9疯狂购物节特价机', '9', '0', '2019-04-29', null, null, '4');
INSERT INTO `t_goods` VALUES ('34', '小米9疯狂购物节特价机', '9', '0', '2019-04-29', null, null, '2');
INSERT INTO `t_goods` VALUES ('37', '小米9疯狂购物节特价机', '12', '0', '2019-04-29', null, null, '2');
INSERT INTO `t_goods` VALUES ('38', '小米9疯狂购物节特价机', '11', '0', '2019-04-29', null, null, '2');
INSERT INTO `t_goods` VALUES ('39', '小米9疯狂购物节特价机', '12', '0', '2019-04-29', null, null, '2');
INSERT INTO `t_goods` VALUES ('40', '灏忕背Pro', '123', '0', '2019-05-06', null, '312312312', '0');
INSERT INTO `t_goods` VALUES ('41', '浣犲ソ', '133', '0', '2019-05-06', null, '鍝堝搱鍝�', '0');
INSERT INTO `t_goods` VALUES ('42', '柯基犬', '666', '0', '2019-05-06', 'https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1542746180,3783070933&fm=179&app=42&f=JPEG?w=121&h=140', '腿长8cm', '2');
INSERT INTO `t_goods` VALUES ('43', '小米', '333', '0', '2019-05-06', 'http://www.baidu.com', 'r6y6y6', '1');
INSERT INTO `t_goods` VALUES ('44', '小米', '333', '0', '2019-05-06', 'http://www.baidu.com', 'r6y6y6', '0');
INSERT INTO `t_goods` VALUES ('45', 'pro', '444', '0', '2019-05-06', 'http://www.baidu.com', '健康洛杉矶开始大家', '2');
INSERT INTO `t_goods` VALUES ('46', '原阳大米', '10', '0', '2019-05-07', 'http://www.baidu.com', '342323423', '2');
INSERT INTO `t_goods` VALUES ('47', '小米9疯狂购物节特价机', '32423', '0', '2019-05-08', 'cfd668f8a74c4ca4b5873e0f836383c0.jpg', '渍渍�?', '2');
INSERT INTO `t_goods` VALUES ('48', '小米', '2000', '0', '2019-05-08', null, '234234234', '1');
INSERT INTO `t_goods` VALUES ('49', '小米', '233', '0', '2019-05-08', null, '惹我热无', '1');
INSERT INTO `t_goods` VALUES ('50', '佳能（Canon）EOS M6（15-45镜头）白色微单套机（2420万像素 触控翻转LCD 全像素双核对焦）Vlog视频拍摄', '2000', '0', '2019-05-31', '1a099adbbf3c4c42b28c0cd3cb08fd16.jpg', '是的发生的水电费水电费是的发生的胜多负少', '1');

-- ----------------------------
-- Table structure for `t_goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `t_goodstype`;
CREATE TABLE `t_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(10) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goodstype
-- ----------------------------
INSERT INTO `t_goodstype` VALUES ('1', '手机', '1', '0');
INSERT INTO `t_goodstype` VALUES ('2', '相机', '1', '0');
INSERT INTO `t_goodstype` VALUES ('3', '平板电脑', '1', '0');
INSERT INTO `t_goodstype` VALUES ('4', '小米手机', '2', '2');
INSERT INTO `t_goodstype` VALUES ('5', '小米平板', '2', '3');
INSERT INTO `t_goodstype` VALUES ('8', '尼康相机', '1', '2');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(60) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '9554a3a12d234b39bdaf4136f2be3a1620181123112035', '3999', '2018-11-23 11:20:35', '2', '1');
INSERT INTO `t_order` VALUES ('2', '91e3ccfb057442f4aee671e7ef2e372720181123112215', '3999', '2018-11-23 11:22:15', '2', '1');
INSERT INTO `t_order` VALUES ('3', '82ffa276fd3849979253d6abc6f3cc5420190110151754', '7998', '2019-01-10 15:17:54', '2', '1');
INSERT INTO `t_order` VALUES ('4', '00919c237d1c48e9a9c63de24b01a3cd20190110153608', '7998', '2019-01-10 15:36:08', '2', '1');
INSERT INTO `t_order` VALUES ('5', '628ea7e11f014458b1d610a09127f19820190110153626', '7998', '2019-01-10 15:36:26', '2', '1');
INSERT INTO `t_order` VALUES ('6', '6aab0c05e2ef40f5a8a88c1308457c7220190110155037', '7998', '2019-01-10 15:50:37', '2', '1');
INSERT INTO `t_order` VALUES ('7', '0fec874b88ab40fea7b2fe2130b0c02a20190111102114', '3999', '2019-01-11 10:21:14', '2', '1');
INSERT INTO `t_order` VALUES ('8', 'a8d6be34a46b40f3bea8278191385a6320190111102329', '3999', '2019-01-11 10:23:29', '2', '1');
INSERT INTO `t_order` VALUES ('9', '01155ec9557142fcb3ea0b10e84651ab20190111103036', '2999', '2019-01-11 10:30:36', '2', '1');
INSERT INTO `t_order` VALUES ('10', '3fe1db68eafb45039a72e6c1d547fe5a20190111105125', '3999', '2019-01-11 10:51:25', '2', '1');
INSERT INTO `t_order` VALUES ('11', 'ade88b4d47dc4c37ab43a5bc08619a3f20190115163624', '3999', '2019-01-15 16:36:24', '2', '1');

-- ----------------------------
-- Table structure for `t_orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderdetail`;
CREATE TABLE `t_orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderdetail
-- ----------------------------
INSERT INTO `t_orderdetail` VALUES ('1', '4', '1', '1');
INSERT INTO `t_orderdetail` VALUES ('2', '4', '1', '3');
INSERT INTO `t_orderdetail` VALUES ('3', '4', '1', '3');
INSERT INTO `t_orderdetail` VALUES ('4', '4', '1', '4');
INSERT INTO `t_orderdetail` VALUES ('5', '4', '1', '4');
INSERT INTO `t_orderdetail` VALUES ('6', '4', '1', '5');
INSERT INTO `t_orderdetail` VALUES ('7', '5', '1', '5');
INSERT INTO `t_orderdetail` VALUES ('8', '4', '1', '6');
INSERT INTO `t_orderdetail` VALUES ('9', '5', '1', '6');
INSERT INTO `t_orderdetail` VALUES ('10', '4', '1', '7');
INSERT INTO `t_orderdetail` VALUES ('11', '4', '1', '8');
INSERT INTO `t_orderdetail` VALUES ('12', '6', '1', '9');
INSERT INTO `t_orderdetail` VALUES ('13', '4', '1', '10');
INSERT INTO `t_orderdetail` VALUES ('14', '4', '1', '11');

-- ----------------------------
-- Table structure for `t_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_status`;
CREATE TABLE `t_status` (
  `id` int(11) NOT NULL DEFAULT '0',
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_status
-- ----------------------------
INSERT INTO `t_status` VALUES ('1', '未付款');
INSERT INTO `t_status` VALUES ('2', '已付款');
INSERT INTO `t_status` VALUES ('3', '已发货');
INSERT INTO `t_status` VALUES ('4', '已签收');
INSERT INTO `t_status` VALUES ('5', '退货中');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `mailstatus` varchar(5) DEFAULT 'N' COMMENT '邮箱状态Y，是激活，N是未激活',
  `validatecode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '123456789', '1', '男', null, 'N', null);
INSERT INTO `t_user` VALUES ('2', 'haha', '202cb962ac59075b964b07152d234b70', '12345', '2', '女', null, 'N', null);
INSERT INTO `t_user` VALUES ('3', 'zhangsan', '123456', '18137884444', null, null, '838700991@qq.com', 'N', null);
INSERT INTO `t_user` VALUES ('4', 'zhangsan', '111', '12312', null, null, '838700991@qq.com', 'N', null);
INSERT INTO `t_user` VALUES ('6', 'yange', '111', '112312321', null, null, '838700991@qq.com', 'N', null);
INSERT INTO `t_user` VALUES ('7', 'laoyan', '123456', '18137884444', null, null, '838700991@qq.com', 'N', null);
