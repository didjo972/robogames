USE `robogames`;

ALTER TABLE RG_INFORMATIONS
			ADD INF_PSEUDO varchar(100) not null,
			ADD INF_PASSWORD varchar(100) not null;
