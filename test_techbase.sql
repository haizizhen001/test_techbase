
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isceo` bit(1) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;





DROP TABLE IF EXISTS `employee_team_ref`;
CREATE TABLE `employee_team_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_employee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `employee_id` int(11) NULL DEFAULT NULL,
  `team_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKmqprom3k4yknnhtscfm3uavde`(`employee_id`) USING BTREE,
  INDEX `FK13px3vysam0kvsixalsj4eu84`(`team_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKcitsl0ygrf7nbmydhlcqorb3p`(`department_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


INSERT INTO `department` VALUES (1, 'IT');
INSERT INTO `department` VALUES (2, 'HR');


INSERT INTO `team` VALUES (1, 'BE', 1);
INSERT INTO `team` VALUES (2, 'FE', 1);
INSERT INTO `team` VALUES (3, 'Human', 2);

INSERT INTO `employee` VALUES (1, b'1', 'Hai-CEO');
INSERT INTO `employee` VALUES (2, b'0', 'Hai-Staff');
INSERT INTO `employee` VALUES (3, b'0', 'Hai-Manager');
INSERT INTO `employee` VALUES (4, b'0', 'Hai-IT-Manager');

INSERT INTO `employee_team_ref` VALUES (1, 'STAFF', 2, 1);
INSERT INTO `employee_team_ref` VALUES (2, 'MANAGER', 3, 2);
INSERT INTO `employee_team_ref` VALUES (3, 'MANAGER', 4, 1);
INSERT INTO `employee_team_ref` VALUES (4, 'MANAGER', 4, 2);


CREATE PROCEDURE dump_database(Id INT(11))
BEGIN

while (Id >=10 and Id <= 2000)
Do
	INSERT INTO `employee` VALUES (Id , b'0', CONCAT('Hai-Staff', Id));
	INSERT INTO `employee_team_ref` VALUES (Id, 'STAFF', Id , 1);
	SET Id  = Id  + 1;
end while;
End

call dump_database(10)



SET FOREIGN_KEY_CHECKS = 1;
