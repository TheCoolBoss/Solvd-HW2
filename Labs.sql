-- MySQL Script generated by MySQL Workbench
-- Mon May 29 16:09:33 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SolvdDBHW
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SolvdDBHW
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SolvdDBHW` DEFAULT CHARACTER SET utf8 ;
USE `SolvdDBHW` ;

-- -----------------------------------------------------
-- Table `SolvdDBHW`.`institutions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`institutions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`clientTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`clientTypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`locations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`labs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`labs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `institutionId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`institutions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `clientId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`clientTypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locationId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`locations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`degrees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`degrees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `numOfYears` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`scientists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`scientists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `labId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`labs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `degreeId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`degrees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`assistants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`assistants` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `labId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`labs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `scientistId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`scientists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experimentTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experimentTypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`reports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`reports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `link` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experiments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experiments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `typeId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`experimentTypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reportId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`reports` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `typeId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`clientTypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`investments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`investments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL NULL,
  `bank` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `clientId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experimentGroups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experimentGroups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `experimentId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`experiments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `scientistId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`scientists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `labId`
    FOREIGN KEY (`id`)
    REFERENCES `SolvdDBHW`.`labs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;