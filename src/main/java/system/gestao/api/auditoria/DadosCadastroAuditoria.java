package system.gestao.api.auditoria;

import java.time.LocalDateTime;

public record DadosCadastroAuditoria(Long usuarioId, Acao acao, LocalDateTime dataHora) {
}
