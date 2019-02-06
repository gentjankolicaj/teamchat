-- MySQL Script generated by MySQL Workbench
-- Wed Feb  6 12:24:10 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema teamchat
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teamchat` ;

-- -----------------------------------------------------
-- Schema teamchat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teamchat` DEFAULT CHARACTER SET utf8 ;
USE `teamchat` ;

-- -----------------------------------------------------
-- Table `teamchat`.`authentication_attempt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`authentication_attempt` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`authentication_attempt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `email_or_username` VARCHAR(80) NULL,
  `password` VARCHAR(100) NULL,
  `status` VARCHAR(45) NOT NULL,
  `platform` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_attempt_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_attempt_user1_idx` ON `teamchat`.`authentication_attempt` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`country` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(80) NOT NULL,
  `iso_codes` VARCHAR(45) NULL,
  `phone_prefix` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teamchat`.`country_currency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`country_currency` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`country_currency` (
  `country_id` INT NOT NULL,
  `currency_id` INT NOT NULL,
  PRIMARY KEY (`country_id`, `currency_id`),
  CONSTRAINT `fk_country_has_currency_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `teamchat`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_country_has_currency_currency1`
    FOREIGN KEY (`currency_id`)
    REFERENCES `teamchat`.`currency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_country_has_currency_currency1_idx` ON `teamchat`.`country_currency` (`currency_id` ASC) VISIBLE;

CREATE INDEX `fk_country_has_currency_country1_idx` ON `teamchat`.`country_currency` (`country_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`country_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`country_language` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`country_language` (
  `country_id` INT NOT NULL,
  `language_id` INT NOT NULL,
  PRIMARY KEY (`country_id`, `language_id`),
  CONSTRAINT `fk_country_has_language_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `teamchat`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_country_has_language_language1`
    FOREIGN KEY (`language_id`)
    REFERENCES `teamchat`.`language` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_country_has_language_language1_idx` ON `teamchat`.`country_language` (`language_id` ASC) VISIBLE;

CREATE INDEX `fk_country_has_language_country1_idx` ON `teamchat`.`country_language` (`country_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`credential`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`credential` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`credential` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `hash_function` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_authentication_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_authentication_user1_idx` ON `teamchat`.`credential` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`currency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`currency` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`currency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency_name` VARCHAR(45) NOT NULL,
  `currency_code` VARCHAR(45) NULL,
  `currency_symbol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teamchat`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`department` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `organization_id` INT NOT NULL,
  `creator_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  `creation_date` DATETIME NOT NULL,
  `deletion_date` DATETIME NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_department_organization1`
    FOREIGN KEY (`organization_id`)
    REFERENCES `teamchat`.`organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_user1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_department_organization1_idx` ON `teamchat`.`department` (`organization_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `name_UNIQUE` ON `teamchat`.`department` (`name` ASC) VISIBLE;

CREATE INDEX `fk_department_user1_idx` ON `teamchat`.`department` (`creator_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`group` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `teamchat`.`group` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`group_members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`group_members` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`group_members` (
  `group_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  CONSTRAINT `fk_group_members_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `teamchat`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_members_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_group_members_group1_idx` ON `teamchat`.`group_members` (`group_id` ASC) VISIBLE;

CREATE INDEX `fk_group_members_user1_idx` ON `teamchat`.`group_members` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`group_privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`group_privilege` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`group_privilege` (
  `group_id` INT NOT NULL,
  `privilege_id` INT NOT NULL,
  CONSTRAINT `fk_group_privilege_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `teamchat`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_privilege_privilege1`
    FOREIGN KEY (`privilege_id`)
    REFERENCES `teamchat`.`privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_group_privilege_group1_idx` ON `teamchat`.`group_privilege` (`group_id` ASC) VISIBLE;

CREATE INDEX `fk_group_privilege_privilege1_idx` ON `teamchat`.`group_privilege` (`privilege_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`industry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`industry` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`industry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `type_UNIQUE` ON `teamchat`.`industry` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`language` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`language` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `language` VARCHAR(100) NOT NULL,
  `code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `languagel_UNIQUE` ON `teamchat`.`language` (`language` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`message` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`message` (
  `id` INT NOT NULL,
  `team_id` INT NULL,
  `sender` INT NOT NULL,
  `receiver` INT NULL,
  `message` VARCHAR(300) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `deletion_date` DATETIME NULL,
  `modification_date` DATETIME NULL,
  `modified_by` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_chat_user1`
    FOREIGN KEY (`sender`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chat_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `teamchat`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chat_user2`
    FOREIGN KEY (`receiver`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_chat_user1_idx` ON `teamchat`.`message` (`sender` ASC) VISIBLE;

CREATE INDEX `fk_chat_team1_idx` ON `teamchat`.`message` (`team_id` ASC) VISIBLE;

CREATE INDEX `fk_chat_user2_idx` ON `teamchat`.`message` (`receiver` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`organization` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `industry_id` INT NULL,
  `creator_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `adress` VARCHAR(100) NOT NULL,
  `country_id` INT NOT NULL,
  `url` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `creation_date` DATETIME NOT NULL,
  `deletion_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_organization_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `teamchat`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_industry1`
    FOREIGN KEY (`industry_id`)
    REFERENCES `teamchat`.`industry` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_user1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `teamchat`.`organization` (`name` ASC) VISIBLE;

CREATE INDEX `fk_organization_country1_idx` ON `teamchat`.`organization` (`country_id` ASC) VISIBLE;

CREATE INDEX `fk_organization_industry1_idx` ON `teamchat`.`organization` (`industry_id` ASC) VISIBLE;

CREATE INDEX `fk_organization_user1_idx` ON `teamchat`.`organization` (`creator_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`privilege` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`privilege` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identifier` VARCHAR(80) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teamchat`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`team` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `department_id` INT NOT NULL,
  `creator_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  `creation_date` DATETIME NOT NULL,
  `deletion_date` DATETIME NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_team_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `teamchat`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_team_user1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `teamchat`.`team` (`name` ASC) VISIBLE;

CREATE INDEX `fk_team_department1_idx` ON `teamchat`.`team` (`department_id` ASC) VISIBLE;

CREATE INDEX `fk_team_user1_idx` ON `teamchat`.`team` (`creator_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`user` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(80) NOT NULL,
  `first_name` VARCHAR(80) NOT NULL,
  `last_name` VARCHAR(80) NOT NULL,
  `sex` VARCHAR(45) NULL,
  `creation_date` DATETIME NOT NULL,
  `deletion_date` DATETIME NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teamchat`.`user_adress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`user_adress` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`user_adress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_adress_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_adress_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `teamchat`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_adress_user1_idx` ON `teamchat`.`user_adress` (`user_id` ASC) VISIBLE;

CREATE INDEX `fk_user_adress_country1_idx` ON `teamchat`.`user_adress` (`country_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`user_contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`user_contact` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`user_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `telephone` INT NULL,
  `mobile` INT NULL,
  `postal_code` VARCHAR(45) NULL,
  `creation_date` DATETIME NOT NULL,
  `modification_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_contact_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_contact_user_idx` ON `teamchat`.`user_contact` (`user_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `email_UNIQUE` ON `teamchat`.`user_contact` (`email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `teamchat`.`user_teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teamchat`.`user_teams` ;

CREATE TABLE IF NOT EXISTS `teamchat`.`user_teams` (
  `user_id` INT NOT NULL,
  `team_id` INT NOT NULL,
  CONSTRAINT `fk_user_has_team_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `teamchat`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_team_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `teamchat`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_has_team_team1_idx` ON `teamchat`.`user_teams` (`team_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_team_user1_idx` ON `teamchat`.`user_teams` (`user_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
