DROP TABLE IF EXISTS `MAIN_USER`;

CREATE TABLE `MAIN_USER` (
	`MU_ID` 	VARCHAR(36) NOT NULL,
    `MU_USERNAME` VARCHAR(100) DEFAULT NULL, 
    `MU_PASSWORD` CHAR(100) DEFAULT NULL, 
    `MU_TOKEN` VARCHAR(100) DEFAULT NULL,
    `MU_ROLE` VARCHAR(200) DEFAULT NULL,
    `MU_ACTIVE` VARCHAR(1) DEFAULT NULL, 
    `MU_INSERT_DATE` DATETIME DEFAULT NULL,
    PRIMARY KEY (`MU_ID`)
)



// Sample password 
{bcrypt}$2a$10$RqIAnyrcdhkT3qLDOEKWHeDojInCV4QIL67Ghw1fIcDUhKlgo4g6W

insert into main_user (mu_id, mu_username, mu_password, mu_token, mu_role, mu_active, mu_insert_date) 
values ( UUID(), 'syahir2', '{bcrypt}$2a$10$RqIAnyrcdhkT3qLDOEKWHeDojInCV4QIL67Ghw1fIcDUhKlgo4g6W', null, 'MASTER', 'A', NOW());