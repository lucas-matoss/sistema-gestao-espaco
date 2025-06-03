package system.gestao.api.historicoAvaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoAvaliacaoRepository extends JpaRepository<HistoricoAvaliacao, Long> {
    List<HistoricoAvaliacao> findBySolicitacaoId(Long solicitacaoId);

    List<HistoricoAvaliacao> findByUsuarioId(Long usuarioId);
}
