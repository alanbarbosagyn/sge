-- MySQL Script generated by MySQL Workbench
-- Fri Jun 21 10:50:37 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema public
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `public` ;

-- -----------------------------------------------------
-- Schema public
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `public` DEFAULT CHARACTER SET utf8 ;
USE `public` ;

-- -----------------------------------------------------
-- Table `public`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`endereco` ;

CREATE TABLE IF NOT EXISTS `public`.`endereco` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` INT NULL,
  `complemento` VARCHAR(100) NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `cidade` VARCHAR(80) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`estabelecimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`estabelecimento` ;

CREATE TABLE IF NOT EXISTS `public`.`estabelecimento` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `cnpj` VARCHAR(14) NULL,
  `endereco_id` BIGINT(14) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE,
  CONSTRAINT `fk_estabelecimento_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `public`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`produto` ;

CREATE TABLE IF NOT EXISTS `public`.`produto` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `estabelecimento_id` BIGINT(14) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `valor` DECIMAL(12,2) NOT NULL,
  `observacao` VARCHAR(300) NULL,
  `situacao` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_produto_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `public`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`usuario` ;

CREATE TABLE IF NOT EXISTS `public`.`usuario` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(35) NOT NULL,
  `telefone` VARCHAR(11) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`garcom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`garcom` ;

CREATE TABLE IF NOT EXISTS `public`.`garcom` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `estabelecimento_id` BIGINT(14) NOT NULL,
  `usuario_id` BIGINT(14) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_garcom_estabelecimento`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `public`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_garcom_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `public`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`mesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`mesa` ;

CREATE TABLE IF NOT EXISTS `public`.`mesa` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `estabelecimento_id` BIGINT(14) NOT NULL,
  `numero` INT NOT NULL,
  `qrcode` VARCHAR(100) NULL,
  `capacidade` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_mesa_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `public`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`comanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`comanda` ;

CREATE TABLE IF NOT EXISTS `public`.`comanda` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `estabelecimento_id` BIGINT(14) NOT NULL,
  `garcom_id` BIGINT(14) NOT NULL,
  `mesa_id` BIGINT(14) NOT NULL,
  `dataAbertura` DATE NOT NULL,
  `dataEncerramento` DATE NULL,
  `situacao` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comanda_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `public`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_garcom1`
    FOREIGN KEY (`garcom_id`)
    REFERENCES `public`.`garcom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_mesa1`
    FOREIGN KEY (`mesa_id`)
    REFERENCES `public`.`mesa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`comanda_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`comanda_item` ;

CREATE TABLE IF NOT EXISTS `public`.`comanda_item` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `comanda_id` BIGINT(14) NOT NULL,
  `produto_id` BIGINT(14) NOT NULL,
  `usuario_id` BIGINT(14) NOT NULL,
  `valor` DECIMAL(12,2) NULL,
  `situacao` INT(1) NOT NULL DEFAULT 1,
  `data_hora_solicitacao` DATE NOT NULL,
  `data_hora_entregra` DATE NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comanda_item_comanda1`
    FOREIGN KEY (`comanda_id`)
    REFERENCES `public`.`comanda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_item_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `public`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_item_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `public`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`avaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`avaliacao` ;

CREATE TABLE IF NOT EXISTS `public`.`avaliacao` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`comanda_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`comanda_usuario` ;

CREATE TABLE IF NOT EXISTS `public`.`comanda_usuario` (
  `comanda_id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT(14) NOT NULL,
  `administrador` TINYINT NULL,
  PRIMARY KEY (`comanda_id`, `usuario_id`),
  CONSTRAINT `fk_comanda_usuario_comanda1`
    FOREIGN KEY (`comanda_id`)
    REFERENCES `public`.`comanda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `public`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`avaliacao_motivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`avaliacao_motivo` ;

CREATE TABLE IF NOT EXISTS `public`.`avaliacao_motivo` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `motivo` VARCHAR(100) NULL,
  `tipo` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`avaliacao_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`avaliacao_item` ;

CREATE TABLE IF NOT EXISTS `public`.`avaliacao_item` (
  `id` BIGINT(14) NOT NULL,
  `avaliacao_motivo_id` BIGINT(14) NOT NULL,
  `comanda_item_id` BIGINT(14) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_avaliacao_item_avaliacao_motivo1`
    FOREIGN KEY (`avaliacao_motivo_id`)
    REFERENCES `public`.`avaliacao_motivo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_item_comanda_item1`
    FOREIGN KEY (`comanda_item_id`)
    REFERENCES `public`.`comanda_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`produto_foto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`produto_foto` ;

CREATE TABLE IF NOT EXISTS `public`.`produto_foto` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `produto` BIGINT(14) NOT NULL,
  `foto` BLOB NULL,
  `situacao` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_produto_foto_produto1`
    FOREIGN KEY (`produto`)
    REFERENCES `public`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `public`.`solicitacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `public`.`solicitacao` ;

CREATE TABLE IF NOT EXISTS `public`.`solicitacao` (
  `id` BIGINT(14) NOT NULL AUTO_INCREMENT,
  `tipo_solicitacao` VARCHAR(45) NULL,
  `atendido` TINYINT NULL,
  `usuario_id` BIGINT(14) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comanda_solicitacao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `public`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
