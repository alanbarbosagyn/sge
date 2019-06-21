-- -----------------------------------------------------
-- Table public.endereco
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.endereco ;

CREATE SEQUENCE public.endereco_seq;

CREATE TABLE IF NOT EXISTS public.endereco (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.endereco_seq'),
  logradouro VARCHAR(100) NOT NULL,
  numero INT NULL,
  complemento VARCHAR(100) NULL,
  bairro VARCHAR(50) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  cidade VARCHAR(80) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table public.estabelecimento
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.estabelecimento ;

CREATE SEQUENCE public.estabelecimento_seq;

CREATE TABLE IF NOT EXISTS public.estabelecimento (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.estabelecimento_seq'),
  nome VARCHAR(100) NULL,
  cnpj VARCHAR(14) NULL,
  endereco_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT cnpj_UNIQUE UNIQUE  (cnpj),
  CONSTRAINT fk_estabelecimento_endereco1
    FOREIGN KEY (endereco_id)
    REFERENCES public.endereco (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.produto
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.produto ;

CREATE SEQUENCE public.produto_seq;

CREATE TABLE IF NOT EXISTS public.produto (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.produto_seq'),
  estabelecimento_id BIGINT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(12,2) NOT NULL,
  observacao VARCHAR(300) NULL,
  situacao INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  CONSTRAINT fk_produto_estabelecimento1
    FOREIGN KEY (estabelecimento_id)
    REFERENCES public.estabelecimento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.usuario
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.usuario ;

CREATE SEQUENCE public.usuario_seq;

CREATE TABLE IF NOT EXISTS public.usuario (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.usuario_seq'),
  usuario VARCHAR(20) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(20) NOT NULL,
  senha VARCHAR(35) NOT NULL,
  telefone VARCHAR(11) NULL,
  PRIMARY KEY (id),
  CONSTRAINT usuario_UNIQUE UNIQUE  (usuario))
;


-- -----------------------------------------------------
-- Table public.garcom
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.garcom ;

CREATE SEQUENCE public.garcom_seq;

CREATE TABLE IF NOT EXISTS public.garcom (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.garcom_seq'),
  estabelecimento_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_garcom_estabelecimento
    FOREIGN KEY (estabelecimento_id)
    REFERENCES public.estabelecimento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_garcom_usuario1
    FOREIGN KEY (usuario_id)
    REFERENCES public.usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.mesa
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.mesa ;

CREATE SEQUENCE public.mesa_seq;

CREATE TABLE IF NOT EXISTS public.mesa (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.mesa_seq'),
  estabelecimento_id BIGINT NOT NULL,
  numero INT NOT NULL,
  qrcode VARCHAR(100) NULL,
  capacidade INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_mesa_estabelecimento1
    FOREIGN KEY (estabelecimento_id)
    REFERENCES public.estabelecimento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.comanda
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.comanda ;

CREATE SEQUENCE public.comanda_seq;

CREATE TABLE IF NOT EXISTS public.comanda (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.comanda_seq'),
  estabelecimento_id BIGINT NOT NULL,
  garcom_id BIGINT NOT NULL,
  mesa_id BIGINT NOT NULL,
  dataAbertura DATE NOT NULL,
  dataEncerramento DATE NULL,
  situacao INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  CONSTRAINT fk_comanda_estabelecimento1
    FOREIGN KEY (estabelecimento_id)
    REFERENCES public.estabelecimento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comanda_garcom1
    FOREIGN KEY (garcom_id)
    REFERENCES public.garcom (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comanda_mesa1
    FOREIGN KEY (mesa_id)
    REFERENCES public.mesa (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.comanda_item
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.comanda_item ;

CREATE SEQUENCE public.comanda_item_seq;

CREATE TABLE IF NOT EXISTS public.comanda_item (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.comanda_item_seq'),
  comanda_id BIGINT NOT NULL,
  produto_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  valor DECIMAL(12,2) NULL,
  situacao INT NOT NULL DEFAULT 1,
  data_hora_solicitacao DATE NOT NULL,
  data_hora_entregra DATE NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_comanda_item_comanda1
    FOREIGN KEY (comanda_id)
    REFERENCES public.comanda (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comanda_item_produto1
    FOREIGN KEY (produto_id)
    REFERENCES public.produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comanda_item_usuario1
    FOREIGN KEY (usuario_id)
    REFERENCES public.usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.comanda_usuario
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.comanda_usuario ;

CREATE SEQUENCE public.comanda_usuario_seq;

CREATE TABLE IF NOT EXISTS public.comanda_usuario (
  comanda_id BIGINT NOT NULL DEFAULT NEXTVAL ('public.comanda_usuario_seq'),
  usuario_id BIGINT NOT NULL,
  administrador SMALLINT NULL,
  PRIMARY KEY (comanda_id, usuario_id),
  CONSTRAINT fk_comanda_usuario_comanda1
    FOREIGN KEY (comanda_id)
    REFERENCES public.comanda (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comanda_usuario_usuario1
    FOREIGN KEY (usuario_id)
    REFERENCES public.usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.avaliacao_motivo
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.avaliacao_motivo ;

CREATE SEQUENCE public.avaliacao_motivo_seq;

CREATE TABLE IF NOT EXISTS public.avaliacao_motivo (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.avaliacao_motivo_seq'),
  motivo VARCHAR(100) NULL,
  tipo VARCHAR(10) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table public.avaliacao_item
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.avaliacao_item ;

CREATE SEQUENCE public.avaliacao_item_seq;

CREATE TABLE IF NOT EXISTS public.avaliacao_item (
  id BIGINT NOT NULL,
  avaliacao_motivo_id BIGINT NOT NULL,
  comanda_item_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_avaliacao_item_avaliacao_motivo1
    FOREIGN KEY (avaliacao_motivo_id)
    REFERENCES public.avaliacao_motivo (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_avaliacao_item_comanda_item1
    FOREIGN KEY (comanda_item_id)
    REFERENCES public.comanda_item (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.produto_foto
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.produto_foto ;

CREATE SEQUENCE public.produto_foto_seq;

CREATE TABLE IF NOT EXISTS public.produto_foto (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.produto_foto_seq'),
  produto BIGINT NOT NULL,
  foto BYTEA NULL,
  situacao INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_produto_foto_produto1
    FOREIGN KEY (produto)
    REFERENCES public.produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table public.solicitacao
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.solicitacao ;

CREATE SEQUENCE public.solicitacao_seq;

CREATE TABLE IF NOT EXISTS public.solicitacao (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.solicitacao_seq'),
  tipo_solicitacao VARCHAR(45) NULL,
  atendido SMALLINT NULL,
  usuario_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_comanda_solicitacao_usuario1
    FOREIGN KEY (usuario_id)
    REFERENCES public.usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;
