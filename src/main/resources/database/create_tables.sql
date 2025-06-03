CREATE TABLE usuario (
	usuario_id serial PRIMARY KEY,
	nome varchar (200),
	email varchar (100),
	tipo_usuario varchar (100)
);

CREATE TABLE espaco_fisico (
	espaco_fisico_id serial PRIMARY KEY,
	nome_espaco varchar (200),
	tipo_espaco varchar (100),
	metragem decimal,
	equipamentos varchar (100),
	descricao varchar (100)
);

CREATE TABLE solicitacao (
	solicitacao_id serial PRIMARY KEY,
	usuario_id int,
	espaco_fisico_id int,
	data_solicitacao date,
	data_reserva date,
	hora_reserva time,
	status varchar(100),
	justificativa_rejeicao varchar(100),
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id),
	FOREIGN KEY (espaco_fisico_id) REFERENCES espaco_fisico(espaco_fisico_id)
);

CREATE TABLE historico_avaliacao (
	historico_avaliacao_id serial PRIMARY KEY,
	solicitacao_id int,
	usuario_id int,
	data_avaliacao date,
	status varchar(100),
	justificativa varchar(100),
	FOREIGN KEY (solicitacao_id) REFERENCES solicitacao(solicitacao_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE auditoria (
	auditoria_id serial PRIMARY KEY,
	usuario_id int,
	acao varchar(100),
	data_hora timestamp,
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);
