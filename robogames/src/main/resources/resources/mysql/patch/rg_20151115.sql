USE `robogames`;

ALTER TABLE `RG_HABILITATION` 
ADD COLUMN `HAB_INFOS` VARCHAR(255) NOT NULL AFTER `HAB_ROL_ID`;

ALTER TABLE `RG_EVENEMENT` 
CHANGE COLUMN `EVE_DATE_FINT` `EVE_DATE_FIN` DATE NOT NULL ;

ALTER TABLE `RG_USER` 
DROP COLUMN `USER_EMAIL`,
DROP COLUMN `USER_PASSWORD`,
DROP COLUMN `USER_PSEUDO`,
DROP COLUMN `USER_PRENOM`,
DROP COLUMN `USER_NOM`,
DROP INDEX `USER_EMAIL_UNIQUE` ,
DROP INDEX `USER_PSEUDO_UNIQUE` ;

CREATE TABLE RG_INFORMATIONS (
	INF_ID bigint not null auto_increment,
	INF_NOM varchar(100) not null,
	INF_PRENOM varchar(100) not null,
	INF_USER_ID bigint not null,
    INF_PSEUDO varchar(100) not null,
	INF_PASSWORD varchar(100) not null,
	primary key (INF_ID)
);

alter table RG_INFORMATIONS
        add index fk_rg_informations_rg_user (INF_USER_ID), 
        add constraint fk_rg_informations_rg_user
        foreign key (INF_USER_ID)
        references RG_USER (USER_ID);
        
ALTER TABLE `RG_INFORMATIONS` 
ADD COLUMN `INF_EMAIL` VARCHAR(100) NULL AFTER `INF_PASSWORD`;
