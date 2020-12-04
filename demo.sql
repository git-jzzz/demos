/*
 Navicat Premium Data Transfer

 Source Server         : JZmysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/12/2020 10:49:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名',
  `gradeId` int NOT NULL COMMENT '年级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '101班', 1);
INSERT INTO `classes` VALUES (2, '102班', 1);
INSERT INTO `classes` VALUES (3, '103班', 1);
INSERT INTO `classes` VALUES (4, '111班', 2);
INSERT INTO `classes` VALUES (5, '112班', 2);
INSERT INTO `classes` VALUES (6, '113班', 2);
INSERT INTO `classes` VALUES (7, '121班', 3);
INSERT INTO `classes` VALUES (8, '122班', 3);
INSERT INTO `classes` VALUES (9, '123班', 3);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '年级id',
  `gradeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年级名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '年级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '初一');
INSERT INTO `grade` VALUES (2, '初二');
INSERT INTO `grade` VALUES (3, '初三');
INSERT INTO `grade` VALUES (4, '高一');
INSERT INTO `grade` VALUES (5, '高二');
INSERT INTO `grade` VALUES (6, '高三');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键\r\n',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生名',
  `sex` int NOT NULL COMMENT '学生性别 1男 0女',
  `age` int NOT NULL COMMENT '年龄',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家庭住址',
  `classId` int NOT NULL COMMENT '班级id',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `beginTime` datetime(0) NOT NULL COMMENT '入学时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '蒋征', 1, 24, '广州花都', 1, '1', '2020-11-26 16:11:48');
INSERT INTO `student` VALUES (2, '蒋小明', 1, 25, '湖南岳阳', 2, '2', '2020-11-26 16:12:39');
INSERT INTO `student` VALUES (3, '蒋大宝', 0, 27, '上海静安', 3, '3', '2020-11-26 16:12:54');

SET FOREIGN_KEY_CHECKS = 1;
