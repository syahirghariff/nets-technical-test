CREATE TABLE `VISIT`(
	`ID` VARCHAR(36) NOT NULL,
	`VISIT_DATE` DATETIME DEFAULT NULL,
	`PHYSICIAN_ID` VARCHAR(36) DEFAULT NULL, 
	`REASON` VARCHAR(100) DEFAULT NULL,
	`CREATED_DATE` DATETIME DEFAULT NULL, 
	`MODIFIED_DATE` DATETIME DEFAULT NULL, 
	`CREATED_BY` VARCHAR(100) DEFAULT NULL, 
	`MODIFIED_BY` VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY(`PHYSICIAN_ID`) REFERENCES `PHYSICIAN`(`ID`)
)