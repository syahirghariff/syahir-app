DROP TABLE IF EXISTS `LOGIN_TRX`;

CREATE TABLE `LOGIN_TRX`(
	`LT_ID` 	VARCHAR(36) NOT NULL,
    `LT_USERNAME` VARCHAR(100) DEFAULT NULL, 
    `LT_PASSWORD` CHAR(100) DEFAULT NULL, 
    `LT_INSERT_DATE` DATETIME DEFAULT NULL,
    PRIMARY KEY (`LT_ID`)
)

