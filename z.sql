/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : z

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 07/10/2023 22:02:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_adopt
-- ----------------------------
DROP TABLE IF EXISTS `t_adopt`;
CREATE TABLE `t_adopt`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pet_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宠物名',
  `pet_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品种类型',
  `vaccine` int(0) NOT NULL COMMENT '疫苗情况 1,已打;0,未打',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '主人ID',
  `imageURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宠物照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_adopt
-- ----------------------------
INSERT INTO `t_adopt` VALUES (1, '泰迪', '宠物狗', 1, 4, 'https://ts2.cn.mm.bing.net/th?id=OIP-C.-IcPwy1Gt7xNWFnjC8Bn0gHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2');
INSERT INTO `t_adopt` VALUES (2, '喵喵', '宠物猫', 1, 3, 'https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_640.jpg');

-- ----------------------------
-- Table structure for t_foster
-- ----------------------------
DROP TABLE IF EXISTS `t_foster`;
CREATE TABLE `t_foster`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `foster_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '寄养时间',
  `pet_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宠物名',
  `pet_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宠物品种',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系方式',
  `vaccine` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_foster
-- ----------------------------
INSERT INTO `t_foster` VALUES (1, 'admin', '7/8', '咪咪', '宠物猫', '12312341234', 1);
INSERT INTO `t_foster` VALUES (2, 'admin', '7/20', '旺财', '宠物狗', '12341234123', 1);
INSERT INTO `t_foster` VALUES (3, '789789', '7/11', '123', '宠物狗', '12312313', 1);
INSERT INTO `t_foster` VALUES (4, 'admin', '7/17', '123', '宠物狗', '1231', 1);
INSERT INTO `t_foster` VALUES (5, 'admin', '7/17', '佩奇', '宠物猫', '12323453245', 1);
INSERT INTO `t_foster` VALUES (6, 'admin', '8/5', '旺财', '宠物狗', '123123123123', 0);
INSERT INTO `t_foster` VALUES (7, 'admin', '8/5', '旺财', '宠物狗', '123123', 0);
INSERT INTO `t_foster` VALUES (8, 'admin', '10/5', '123', '宠物狗', '123123', 0);

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES (1, 'admin', 'http://127.0.0.1:8080/image/IMG_20210423_185906.jpg', '去山上玩了111');
INSERT INTO `t_log` VALUES (2, 'list', 'http://127.0.0.1:8080/image/IMG_20210423_185906.jpg', '去山上玩了123');
INSERT INTO `t_log` VALUES (10, 'admin', 'http://127.0.0.1:8080\\image\\1.jpeg', '去山上玩了');

-- ----------------------------
-- Table structure for t_manage
-- ----------------------------
DROP TABLE IF EXISTS `t_manage`;
CREATE TABLE `t_manage`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '被举报名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '举报描述',
  `is_handle` int(0) NULL DEFAULT NULL COMMENT '1，以处理；0，未处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_manage
-- ----------------------------
INSERT INTO `t_manage` VALUES (1, 'zhangsan', '虐待小动物', 1);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `credit` int(0) NOT NULL COMMENT '信用分',
  `permissions` tinyint(0) NOT NULL COMMENT '权限1超级管理员；2普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (3, 'admin', '$2a$10$pwJ0kmC2Z3tqQvKbDTgQZO6QexdZ8XPodwLOf8hCwW2gLUXv2k/Vq', 100, 1);
INSERT INTO `t_user` VALUES (4, 'list', '$2a$10$g31K3Idb3axH.Vlek9hb5u.5TUV8HpAsXe9IwujRnnn1CPx7OlEca', 100, 2);
INSERT INTO `t_user` VALUES (10, '789789', '$2a$10$RU4GZYWKadyOzoKKsckuFOwdk9y7lk4Ygd.3Llkhdsvnth66Q0udi', 100, 2);

SET FOREIGN_KEY_CHECKS = 1;
