-- Consultar todos os usuários
SELECT * FROM usuario;

-- Consultar todos os espaços físicos
SELECT * FROM espaco_fisico;

-- Consultar todas as solicitações
SELECT * FROM solicitacao;

-- Consultar todo o histórico de avaliações
SELECT * FROM historico_avaliacao;

-- Consultar todos os registros de auditoria
SELECT * FROM auditoria;

-- Consultar solicitações com nome de usuário e nome do espaço
SELECT 
    s.solicitacao_id,
    u.nome AS solicitante,
    e.nome_espaco,
    s.data_solicitacao,
    s.data_reserva,
    s.hora_reserva,
    s.status,
    s.justificativa_rejeicao
FROM solicitacao s
INNER JOIN usuario u ON s.usuario_id = u.usuario_id
INNER JOIN espaco_fisico e ON s.espaco_fisico_id = e.espaco_fisico_id;

-- Consultar histórico de avaliações com nome do avaliador e detalhes da solicitação
SELECT 
    h.historico_avaliacao_id,
    u.nome AS avaliador,
    s.solicitacao_id,
    h.data_avaliacao,
    h.status,
    h.justificativa
FROM historico_avaliacao h
INNER JOIN usuario u ON h.usuario_id = u.usuario_id
INNER JOIN solicitacao s ON h.solicitacao_id = s.solicitacao_id;

-- Consultar auditoria com nome do usuário que realizou a ação
SELECT 
    a.auditoria_id,
    u.nome AS usuario,
    a.acao,
    a.data_hora
FROM auditoria a
INNER JOIN usuario u ON a.usuario_id = u.usuario_id;
