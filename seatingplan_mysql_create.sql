CREATE TABLE `Plan` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	`version` INT(3) NOT NULL DEFAULT '1',
	PRIMARY KEY (`id`)
);

CREATE TABLE `Materiel` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	`nombre` INT(7) NOT NULL,
	`id_type` INT(8) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Collaborateur` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`nom` varchar(30) NOT NULL,
	`prenom` varchar(30) NOT NULL,
	`date_arrive` DATE,
	`date_depart` DATE,
	`email` varchar(150) NOT NULL,
	`mdp` varchar(128),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Bureau` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`nombre` INT(7) NOT NULL,
	`id_collab` INT(8),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Contenir` (
	`id_bureau` INT(8) NOT NULL,
	`id_four` INT(8) NOT NULL,
	`num_interne` INT(10),
	`num_externe` INT(10),
	PRIMARY KEY (`id_bureau`,`id_four`)
);

CREATE TABLE `Avoir` (
	`id_plan` INT(8) NOT NULL,
	`id_bureau` INT(8) NOT NULL,
	`abs` INT(4) NOT NULL,
	`ord` INT(4) NOT NULL,
	`sens` BINARY NOT NULL,
	PRIMARY KEY (`id_plan`,`id_bureau`)
);

CREATE TABLE `Type` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Batiment` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Etage` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Partie` (
	`id` INT(8) NOT NULL AUTO_INCREMENT,
	`libelle` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Materiel` ADD CONSTRAINT `Materiel_fk0` FOREIGN KEY (`id_type`) REFERENCES `Type`(`id`);

ALTER TABLE `Bureau` ADD CONSTRAINT `Bureau_fk0` FOREIGN KEY (`id_collab`) REFERENCES `Collaborateur`(`id`);

ALTER TABLE `Contenir` ADD CONSTRAINT `Contenir_fk0` FOREIGN KEY (`id_bureau`) REFERENCES `Bureau`(`id`);

ALTER TABLE `Contenir` ADD CONSTRAINT `Contenir_fk1` FOREIGN KEY (`id_four`) REFERENCES `Materiel`(`id`);

ALTER TABLE `Avoir` ADD CONSTRAINT `Avoir_fk0` FOREIGN KEY (`id_plan`) REFERENCES `Plan`(`id`);

ALTER TABLE `Avoir` ADD CONSTRAINT `Avoir_fk1` FOREIGN KEY (`id_bureau`) REFERENCES `Bureau`(`id`);

