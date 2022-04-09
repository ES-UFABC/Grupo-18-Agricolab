CREATE TABLE produtores (
    id_produtor INT NOT NULL AUTO_INCREMENT,
    tipo_produtor VARCHAR(2) NULL,
    nome_produtor VARCHAR(200) NULL,
    email_produtor VARCHAR(100) NULL UNIQUE,
    cnpj_produtor VARCHAR(14) NULL,
    cpf_produtor VARCHAR(11) NULL,
    senha_produtor VARCHAR(100) NULL,
    telefone_produtor VARCHAR(20) NULL,
    endereco_produtor VARCHAR(100) NULL,
    compl_end_produtor VARCHAR(40) NULL,
    lat_produtor VARCHAR(10) NULL,
    long_produtor VARCHAR(10) NULL,
    PRIMARY KEY (id_produtor));


CREATE TABLE consumidores (
      id_consumidor INT NOT NULL AUTO_INCREMENT,
      tipo_consumidor VARCHAR(2) NULL, -- PF ou Pj
      segmento_consumidorPJ VARCHAR(200) NULL, -- Segmento caso PJ
      nome_consumidor VARCHAR(200) NULL,
      email_consumidor VARCHAR(100) NULL,
      cnpj_consumidor VARCHAR(14) NULL,
      cpf_consumidor VARCHAR(11) NULL,
      telefone_consumidor VARCHAR(20) NULL,
      endereco_consumidor VARCHAR(100) NULL,
      compl_end_consumidor VARCHAR(40) NULL, -- Complemento endereço
      lat_consumidor VARCHAR(10) NULL,
      long_consumidor VARCHAR(10) NULL,
      PRIMARY KEY (id_consumidor));


CREATE TABLE produtos(
    id_produtos INT NOT NULL AUTO_INCREMENT,
    nome_produtos VARCHAR(200),
    quantidade_produtos INT,
	id_produtor INT,
    valor_produtos DECIMAL(12,2),
	PRIMARY KEY (id_produtos),
	CONSTRAINT id_produtor FOREIGN KEY (id_produtor) REFERENCES  produtores(id_produtor));
