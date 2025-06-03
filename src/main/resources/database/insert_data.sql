INSERT INTO usuario (nome, email, tipo_usuario) VALUES 
('Lucas Matos', 'lucas.matos@gestao.system', 'SOLICITANTE'),
('Matheus Peltier', 'matheus.peltier@gestao.system', 'SOLICITANTE'),
('Fernanda Lima', 'fernanda.lima@gestao.system', 'SOLICITANTE'),
('Fernando Cesar', 'fernando.cesar@gestao.system', 'GESTOR');

INSERT INTO espaco_fisico (nome_espaco, tipo_espaco, metragem, equipamentos, descricao) VALUES
('Auditório Central', 'AUDITORIO', 200.0, 'Projetor, Microfone, Cadeiras', 'Espaço amplo para eventos e palestras'),
('Sala de Reuniões 1', 'SALA', 30.0, 'TV, Mesa de reunião, Ar-condicionado', 'Sala ideal para reuniões pequenas'),
('Ginásio Poliesportivo', 'GINASIO', 500.0, 'Quadra, Arquibancadas, Iluminação', 'Espaço esportivo para diversas atividades');
