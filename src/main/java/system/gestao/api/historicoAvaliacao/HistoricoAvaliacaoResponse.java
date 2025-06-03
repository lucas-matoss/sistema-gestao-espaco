package system.gestao.api.historicoAvaliacao;

import java.time.format.DateTimeFormatter;

public record HistoricoAvaliacaoResponse(
        Long id,
        Long solicitacaoId,
        Long usuarioId,
        String nomeUsuario,
        String dataAvaliacao,
        String status,
        String justificativa
) {
    public HistoricoAvaliacaoResponse(HistoricoAvaliacao historico) {
        this(
                historico.getId(),
                historico.getSolicitacao().getId(),
                historico.getUsuario().getId(),
                historico.getUsuario().getNome(),
                historico.getDataAvaliacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                historico.getStatus().name(),
                historico.getJustificativa()
        );
    }
}
