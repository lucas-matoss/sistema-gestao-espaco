package system.gestao.api.solicitacao;

import system.gestao.api.espacoFisico.EspacoFisico;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroSolicitacao(Long usuarioId, Long espacoFisicoId, LocalDate dataSolicitacao, LocalDate dataReserva, LocalTime horaReserva, Status status, String justificativaRejeicao) {

}
