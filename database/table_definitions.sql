CREATE TABLE administrador (
	id integer,
	nome varchar(50),
	senha varchar(50),
	CONSTRAINT administrador_pkey
	PRIMARY KEY (id)
);

INSERT INTO administrador(id, nome, senha) VALUES
(1, 'abilio', 'maicao1234'),
(2, 'leandro', 'pegador1234'),
(3, 'douglas', 'quixera1234')

SELECT * FROM administrador

CREATE TABLE produto (
	id serial,
	nome varchar(100),
	preco real,
	quantidade integer,
	loja varchar(100),
	CONSTRAINT produto_pkey
	PRIMARY KEY (id)
);