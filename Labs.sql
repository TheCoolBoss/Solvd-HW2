-- MySQL Script generated by MySQL Workbench
-- Thu Jun  1 09:10:53 2023
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
  `institutionId` INT NOT NULL AUTO_INCREMENT,
  `institutionName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`institutionId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`locations` (
  `locationId` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`locationId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`labs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`labs` (
  `labId` INT NOT NULL AUTO_INCREMENT,
  `labName` VARCHAR(45) NOT NULL,
  `institutionId` INT NULL,
  `locationId` INT NULL,
  PRIMARY KEY (`labId`),
  CONSTRAINT `institutionId`
    FOREIGN KEY (`institutionId`)
    REFERENCES `SolvdDBHW`.`institutions` (`institutionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locationId`
    FOREIGN KEY (`locationId`)
    REFERENCES `SolvdDBHW`.`locations` (`locationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`degrees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`degrees` (
  `degreeId` INT NOT NULL AUTO_INCREMENT,
  `degreeName` VARCHAR(45) NULL DEFAULT NULL,
  `numOfYears` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`degreeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`scientists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`scientists` (
  `scientistId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `degreeId` INT NULL,
  PRIMARY KEY (`scientistId`),
  CONSTRAINT `degreeId`
    FOREIGN KEY (`degreeId`)
    REFERENCES `SolvdDBHW`.`degrees` (`degreeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`assistants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`assistants` (
  `assistantId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `assisteeId` INT NULL,
  PRIMARY KEY (`assistantId`),
  CONSTRAINT `assisteeId`
    FOREIGN KEY (`assisteeId`)
    REFERENCES `SolvdDBHW`.`scientists` (`scientistId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experimentTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experimentTypes` (
  `expTypeId` INT NOT NULL AUTO_INCREMENT,
  `expTypeName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`expTypeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`reports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`reports` (
  `reportId` INT NOT NULL AUTO_INCREMENT,
  `reportName` VARCHAR(45) NULL DEFAULT NULL,
  `link` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`reportId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`clientTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`clientTypes` (
  `clientTypeId` INT NOT NULL AUTO_INCREMENT,
  `clientTypeName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`clientTypeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`clients` (
  `clientId` INT NOT NULL AUTO_INCREMENT,
  `clientName` VARCHAR(45) NULL DEFAULT NULL,
  `clientTypeId` INT NULL,
  PRIMARY KEY (`clientId`),
  CONSTRAINT `clientTypeId`
    FOREIGN KEY (`clientTypeId`)
    REFERENCES `SolvdDBHW`.`clientTypes` (`clientTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`investments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`investments` (
  `investmentId` INT NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL NULL DEFAULT NULL,
  `bank` VARCHAR(45) NULL DEFAULT NULL,
  `clientId` INT NULL,
  PRIMARY KEY (`investmentId`),
  CONSTRAINT `clientId`
    FOREIGN KEY (`clientId`)
    REFERENCES `SolvdDBHW`.`clients` (`clientId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experiments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experiments` (
  `experimentId` INT NOT NULL AUTO_INCREMENT,
  `experimentName` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `startDate` DATE NULL DEFAULT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  `experimentTypeId` INT NULL,
  `investmentId` INT NULL,
  `reportId` INT NULL,
  `labId` INT NULL,
  PRIMARY KEY (`experimentId`),
  CONSTRAINT `experimentTypeId`
    FOREIGN KEY (`experimentTypeId`)
    REFERENCES `SolvdDBHW`.`experimentTypes` (`expTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reportId`
    FOREIGN KEY (`reportId`)
    REFERENCES `SolvdDBHW`.`reports` (`reportId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `investmentId`
    FOREIGN KEY (`investmentId`)
    REFERENCES `SolvdDBHW`.`investments` (`investmentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `labId`
    FOREIGN KEY (`labId`)
    REFERENCES `SolvdDBHW`.`labs` (`labId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SolvdDBHW`.`experimentGroups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SolvdDBHW`.`experimentGroups` (
  `groupId` INT NOT NULL AUTO_INCREMENT,
  `experimentId` INT NULL,
  `scientistId` INT NULL,
  INDEX `experimentId_idx` (`experimentId` ASC) VISIBLE,
  PRIMARY KEY (`groupId`),
  CONSTRAINT `experimentId`
    FOREIGN KEY (`experimentId`)
    REFERENCES `SolvdDBHW`.`experiments` (`experimentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `scientistId`
    FOREIGN KEY (`scientistId`)
    REFERENCES `SolvdDBHW`.`scientists` (`scientistId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
