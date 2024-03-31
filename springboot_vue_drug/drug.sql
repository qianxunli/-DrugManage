/*
 Navicat Premium Data Transfer

 Source Server         : root2
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 22/03/2024 15:38:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `drugId` int NOT NULL AUTO_INCREMENT COMMENT '药品id',
  `drugName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品名称',
  `drugAction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品功效',
  `drugContraindications` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品禁忌',
  `drugBeforePrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '药品原件',
  `drugNowPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '药品现价',
  `drugBirthday` date NULL DEFAULT NULL COMMENT '药品生产日期',
  `drugShelfLife` int NULL DEFAULT NULL COMMENT '药品保质期',
  PRIMARY KEY (`drugId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123123 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES (1, '布洛芬', '缓解疼痛，退烧', '孕妇、哺乳期妇女禁用', 15.00, 12.00, '2023-01-01', 24);
INSERT INTO `drug` VALUES (2, '尼美舒', '缓解疼痛，镇痛', '过敏体质者禁用', 20.00, 18.00, '2023-02-01', 12);
INSERT INTO `drug` VALUES (3, '维c银翘片', '抗感冒，增强免疫力', '无', 25.00, 22.00, '2023-03-01', 36);
INSERT INTO `drug` VALUES (4, '感冒灵颗粒', '缓解感冒症状', '无', 30.00, 28.00, '2022-01-01', 24);
INSERT INTO `drug` VALUES (5, '羚羊清肺颗粒', '清热解毒，润肺止咳', '孕妇禁用', 18.00, 15.00, '2022-05-05', 12);
INSERT INTO `drug` VALUES (12, '12', '123', NULL, 123.00, 123.00, '2023-12-16', 123);
INSERT INTO `drug` VALUES (111, '1111', '12', NULL, 12.00, 12.00, '2023-12-12', 123);
INSERT INTO `drug` VALUES (122, '123', '123', NULL, 123.00, 123.00, '2023-12-18', 123);
INSERT INTO `drug` VALUES (123, '12', '123', NULL, 123.00, 12323.00, '2023-12-16', 12);
INSERT INTO `drug` VALUES (124, '123', '123', NULL, 123.00, 123.00, '2023-12-16', 123);

-- ----------------------------
-- Table structure for drugrepertory
-- ----------------------------
DROP TABLE IF EXISTS `drugrepertory`;
CREATE TABLE `drugrepertory`  (
  `drugRepertoryId` int NOT NULL AUTO_INCREMENT COMMENT '药品库存id',
  `drugId` int NULL DEFAULT NULL COMMENT '药品id',
  `drugNum` int NULL DEFAULT NULL COMMENT '药品数量',
  `drugTimeRemain` date NULL DEFAULT NULL COMMENT '药品入库日期',
  PRIMARY KEY (`drugRepertoryId`) USING BTREE,
  INDEX `drugId`(`drugId`) USING BTREE,
  CONSTRAINT `drugrepertory_ibfk_1` FOREIGN KEY (`drugId`) REFERENCES `drug` (`drugId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of drugrepertory
-- ----------------------------
INSERT INTO `drugrepertory` VALUES (1, 1, 40, '2022-06-01');
INSERT INTO `drugrepertory` VALUES (2, 2, 0, '2023-07-01');
INSERT INTO `drugrepertory` VALUES (3, 3, 20, '2023-08-01');
INSERT INTO `drugrepertory` VALUES (4, 4, 20, '2023-09-01');
INSERT INTO `drugrepertory` VALUES (5, 5, 25, '2023-10-01');
INSERT INTO `drugrepertory` VALUES (11, 111, 11, '2023-12-11');
INSERT INTO `drugrepertory` VALUES (123, 123, 123, '2023-12-11');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuId` int NOT NULL,
  `menuCode` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `menuName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `menuLevel` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单级别',
  `menuParentCode` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单的父code',
  `menuclick` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '点击触发的函数',
  `menuRight` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限 0管理员，1表示员工 2表示用户',
  `menuComponent` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `menuIcon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '001', '药品管理', '1', '', 'DrugManage', '0,1', 'Drug/DrugManage.vue', 'Menu');
INSERT INTO `menu` VALUES (2, '002', '用户管理', '1', '', 'UserManage', '0', 'User/UserManage.vue', 'Setting');
INSERT INTO `menu` VALUES (3, '003', '药品库存管理', '1', NULL, 'DrugRepertoryManage', '0', 'DrugRePertory/DrugRepertoryManage.vue', 'House');
INSERT INTO `menu` VALUES (4, '004', '药品信息', '1', NULL, 'DrugInfo', '0,1,2', 'DrugInfo/DrugInfoManage.vue', 'FirstAidKit');
INSERT INTO `menu` VALUES (5, '005', '购物车', '1', NULL, 'Shop', '0,1,2', 'Shop/ShopManage.vue', 'Shop');
INSERT INTO `menu` VALUES (6, '006', '订单管理', '1', NULL, 'OrderForm', '0,1,2', 'OrderForm/OrderFormManage.vue', 'Memo');

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform`  (
  `orderFormId` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `orderNumber` int NULL DEFAULT NULL COMMENT '订单编号',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `acceptAddress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货地址',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `orderFormCreateTime` date NULL DEFAULT NULL COMMENT '订单创建日期',
  `orderFormDeliverGoodTime` date NULL DEFAULT NULL COMMENT '订单发货日期',
  `orderFormState` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`orderFormId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `orderform_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES (1, 1, 1, 'qwe123', '13345670000', '2023-12-19', '2023-12-19', '已支付');
INSERT INTO `orderform` VALUES (2, 2, 9, '123', '13312342134', '2023-12-19', '2023-12-19', '已支付');
INSERT INTO `orderform` VALUES (3, 3, 1, 'qwe123', '13345670000', '2023-12-20', '2023-12-20', '已支付');
INSERT INTO `orderform` VALUES (4, 4, 19, '123', '13312312333', '2023-12-21', '2023-12-21', '已支付');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `orderItemId` int NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `drugNum` int NULL DEFAULT NULL COMMENT '药品名',
  `drugPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '药品现价',
  `drugId` int NULL DEFAULT NULL COMMENT '药品id',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `orderFormId` int NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`orderItemId`) USING BTREE,
  INDEX `drugId`(`drugId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `orderFormId`(`orderFormId`) USING BTREE,
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`drugId`) REFERENCES `drug` (`drugId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`orderFormId`) REFERENCES `orderform` (`orderFormId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (1, 5, 18.00, 2, 1, 1);
INSERT INTO `orderitem` VALUES (2, 10, 12.00, 1, 1, 1);
INSERT INTO `orderitem` VALUES (3, 5, 22.00, 3, 1, 1);
INSERT INTO `orderitem` VALUES (4, 5, 28.00, 4, 1, 1);
INSERT INTO `orderitem` VALUES (5, 20, 12.00, 1, 9, 2);
INSERT INTO `orderitem` VALUES (6, 10, 12.00, 1, 1, 3);
INSERT INTO `orderitem` VALUES (7, 5, 22.00, 3, 1, 3);
INSERT INTO `orderitem` VALUES (8, 5, 18.00, 2, 1, 3);
INSERT INTO `orderitem` VALUES (9, 10, 18.00, 2, 19, 4);
INSERT INTO `orderitem` VALUES (10, 10, 12.00, 1, 19, 4);
INSERT INTO `orderitem` VALUES (11, 10, 15.00, 5, 19, 4);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleId` int NOT NULL COMMENT '角色id',
  `roleName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, '管理员');
INSERT INTO `role` VALUES (1, '员工');
INSERT INTO `role` VALUES (2, '用户');

-- ----------------------------
-- Table structure for shoptrolley
-- ----------------------------
DROP TABLE IF EXISTS `shoptrolley`;
CREATE TABLE `shoptrolley`  (
  `shopTrolleyId` int NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `drugId` int NULL DEFAULT NULL COMMENT '药品id',
  `drugNum` int NULL DEFAULT NULL COMMENT '药品数量',
  `drugPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '药品现价',
  `drugName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品名称',
  `drugRepertoryId` int NULL DEFAULT NULL COMMENT '药品库存id',
  PRIMARY KEY (`shopTrolleyId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `drugId`(`drugId`) USING BTREE,
  CONSTRAINT `shoptrolley_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shoptrolley_ibfk_2` FOREIGN KEY (`drugId`) REFERENCES `drug` (`drugId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shoptrolley
-- ----------------------------
INSERT INTO `shoptrolley` VALUES (5, 2, 1, 10, 12.00, '布洛芬', 1);
INSERT INTO `shoptrolley` VALUES (20, 1, 1, 10, 12.00, '布洛芬', 1);
INSERT INTO `shoptrolley` VALUES (21, 1, 2, 10, 18.00, '尼美舒', 2);
INSERT INTO `shoptrolley` VALUES (22, 1, 3, 10, 22.00, '维c银翘片', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qwe', 'qwe', '张三', '2023-12-16', '13345670000', 'qwe123');
INSERT INTO `user` VALUES (2, 'asd', '123', '张大', '2023-12-09', '456', 'fgh');
INSERT INTO `user` VALUES (3, 'ghl', '456', '王五', '2023-12-09', '4596', 'fghwq');
INSERT INTO `user` VALUES (4, 'zxc', '678', '王二', '2023-12-11', '567', '阿斯顿');
INSERT INTO `user` VALUES (5, 'fgh', '567', '宋大', '2023-12-11', '678', '鸡西');
INSERT INTO `user` VALUES (6, '1', '1', '1', '2023-12-13', '1', '1');
INSERT INTO `user` VALUES (9, '123', '123', '123', '2023-12-06', '13312342134', '123');
INSERT INTO `user` VALUES (10, '1234', '123', '123', '2023-12-19', '13345670000', '123000');
INSERT INTO `user` VALUES (11, 'qwe1', '123', '123', '2023-12-13', '13345671234', '123');
INSERT INTO `user` VALUES (12, '123q', '123', 'asd', '2023-12-14', '13312312231', '66633');
INSERT INTO `user` VALUES (13, '234', '234', '234', '2023-12-05', '13334521235', '123');
INSERT INTO `user` VALUES (14, '1235', '123', '312', '2023-12-11', '13312341234', '123');
INSERT INTO `user` VALUES (15, '123qwe', '123', 'qwe', '2023-12-02', '13345671234', 'qwe');
INSERT INTO `user` VALUES (16, 'qweqwe', '123', 'qwe', '2023-12-07', '13312341234', 'qwe');
INSERT INTO `user` VALUES (17, 'zxc123', 'zxc', 'zxc', '2023-12-06', '13312341234', '123');
INSERT INTO `user` VALUES (18, '111', '123', '123', '2023-12-05', '13312341234', '123');
INSERT INTO `user` VALUES (19, '123123', '123', '123', '2023-12-19', '13312312333', '123');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `userRoleId` int NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `roleId` int NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`userRoleId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES (1, 1, 0);
INSERT INTO `userrole` VALUES (2, 2, 1);
INSERT INTO `userrole` VALUES (3, 3, 2);
INSERT INTO `userrole` VALUES (4, 4, 2);
INSERT INTO `userrole` VALUES (5, 5, 2);
INSERT INTO `userrole` VALUES (6, 6, 1);
INSERT INTO `userrole` VALUES (9, 9, 2);
INSERT INTO `userrole` VALUES (10, 10, 1);
INSERT INTO `userrole` VALUES (11, 11, 2);
INSERT INTO `userrole` VALUES (12, 12, 2);
INSERT INTO `userrole` VALUES (13, 13, 2);
INSERT INTO `userrole` VALUES (14, 14, 2);
INSERT INTO `userrole` VALUES (15, 15, 2);
INSERT INTO `userrole` VALUES (16, 16, 2);
INSERT INTO `userrole` VALUES (17, 17, 2);
INSERT INTO `userrole` VALUES (18, 18, 2);
INSERT INTO `userrole` VALUES (19, 19, 2);

SET FOREIGN_KEY_CHECKS = 1;
