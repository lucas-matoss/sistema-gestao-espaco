package system.gestao.api.solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;
import system.gestao.api.espacoFisico.EspacoFisico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    boolean existsByEspacoFisicoAndDataReservaAndHoraReservaAndStatus(EspacoFisico espacoFisico, LocalDate dataReserva, LocalTime horaReserva, Status status);

    List<Solicitacao> findByUsuarioIdAndStatus(Long usuarioId, Status status);

    List<Solicitacao> findByUsuarioId(Long usuarioId);

    List<Solicitacao> findByStatus(Status status);

    LocalTime espacoFisico(EspacoFisico espacoFisico);
}
