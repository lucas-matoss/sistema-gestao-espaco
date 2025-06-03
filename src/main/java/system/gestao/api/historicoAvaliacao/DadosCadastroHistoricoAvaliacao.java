package system.gestao.api.historicoAvaliacao;

import java.time.LocalDate;

public record DadosCadastroHistoricoAvaliacao(Long solicitacaoId, Long usuarioId, LocalDate dataAvaliacao, StatusHistorico status, String justificativa) {

}
