USE `robogames`;

DROP TABLE IF EXISTS RG_USER;

DROP TABLE IF EXISTS RG_INFORMATIONS;

DROP TABLE IF EXISTS RG_HABILITATION;

DROP TABLE IF EXISTS RG_ROLE;

DROP TABLE IF EXISTS RG_LIVE;

DROP TABLE IF EXISTS RG_EVENEMENT;

DROP TABLE IF EXISTS RG_DEBRIEFING;

DROP TABLE IF EXISTS RG_BILLET;

CREATE TABLE RG_USER (
    USER_ID bigint not null auto_increment,
    primary key (USER_ID)
);

CREATE TABLE RG_INFORMATIONS (
	INF_ID bigint not null auto_increment,
	INF_NOM varchar(100) not null,
	INF_PRENOM varchar(100) not null,
	INF_USER_ID bigint not null,
	primary key (INF_ID)
);

CREATE TABLE RG_HABILITATION (
	HAB_ID bigint not null auto_increment,
	HAB_DATE_DEBUT date not null,
	HAB_DATE_FIN date,
	HAB_ETAT boolean not null,
	HAB_USER_ID bigint not null,
	HAB_ROL_ID bigint not null,
	primary key (HAB_ID)
);

CREATE TABLE RG_ROLE (
	ROL_ID bigint not null auto_increment,
	ROL_LIBELLE varchar(100) not null,
	primary key (ROL_ID)
);

CREATE TABLE RG_LIVE (
	LIV_ID bigint not null auto_increment,
	LIV_URL LONGTEXT not null,
	primary key (LIV_ID)
);

CREATE TABLE RG_BILLET (
	BILL_ID bigint not null auto_increment,
	BILL_USER_ID bigint not null,
	BILL_EVE_ID bigint not null,
	primary key (BILL_ID)
);

CREATE TABLE RG_DEBRIEFING (
	DEB_ID bigint not null auto_increment,
	DEB_DEBRIEF LONGTEXT not null,
	DEB_EVE_ID bigint not null,
	primary key (DEB_ID)
);

CREATE TABLE RG_EVENEMENT (
	EVE_ID bigint not null auto_increment,
	EVE_DATE_DEBUT DATE not null,
	EVE_DATE_FINT DATE not null,
	EVE_ADRESSE varchar(100) not null,
	EVE_CODE_POSTAL int not null,
	EVE_VILLE varchar(100) not null,
	EVE_NB_PLACE int not null,
	EVE_PRIX int not null,
	EVE_USER_ID bigint not null,
	EVE_ETAT boolean not null,
	EVE_INFOS LONGTEXT,
	EVE_VALIDE boolean not null,
	primary key (EVE_ID)
);

alter table RG_HABILITATION
        add index fk_rg_habilitation_rg_role (HAB_ROL_ID), 
        add constraint fk_rg_habilitation_rg_role
        foreign key (HAB_ROL_ID) 
        references RG_ROLE (ROL_ID);
        
alter table RG_HABILITATION
        add index fk_rg_habilitation_rg_user (HAB_USER_ID), 
        add constraint fk_rg_habilitation_rg_user
        foreign key (HAB_USER_ID) 
        references RG_USER (USER_ID);
        
alter table RG_INFORMATIONS
        add index fk_rg_informations_rg_user (INF_USER_ID), 
        add constraint fk_rg_informations_rg_user
        foreign key (INF_USER_ID)
        references RG_USER (USER_ID);
        
alter table RG_DEBRIEFING
        add index fk_rg_debriefing_rg_evenement (DEB_EVE_ID), 
        add constraint fk_rg_debriefing_rg_evenement
        foreign key (DEB_EVE_ID)
        references RG_EVENEMENT (EVE_ID);
        
alter table RG_BILLET
        add index fk_rg_billet_rg_evenement (BILL_EVE_ID), 
        add constraint fk_rg_billet_rg_evenement
        foreign key (BILL_EVE_ID)
        references RG_EVENEMENT (EVE_ID);
        
alter table RG_BILLET
        add index fk_rg_billet_rg_user (BILL_USER_ID), 
        add constraint fk_rg_billet_rg_user
        foreign key (BILL_USER_ID)
        references RG_USER (USER_ID);
        
alter table RG_EVENEMENT
        add index fk_rg_evenement_rg_user (EVE_USER_ID), 
        add constraint fk_rg_evenement_rg_user
        foreign key (EVE_USER_ID)
        references RG_USER (USER_ID);

INSERT INTO RG_ROLE(ROL_ID,ROL_LIBELLE) VALUES (1,'Administrateur');
INSERT INTO RG_ROLE(ROL_ID,ROL_LIBELLE) VALUES (2,'Utilisateur');