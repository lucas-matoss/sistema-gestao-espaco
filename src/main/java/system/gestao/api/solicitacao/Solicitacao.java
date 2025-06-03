package system.gestao.api.solicitacao;

import jakarta.persistence.*;
import lombok.*;
import system.gestao.api.usuario.Usuario;
import system.gestao.api.espacoFisico.EspacoFisico;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "solicitacao")
@Entity(name = "Solicitacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitacao_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "espaco_fisico_id", nullable = false)
    private EspacoFisico espacoFisico;

    private LocalDate dataSolicitacao;
    private LocalDate dataReserva;
    private LocalTime horaReserva;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    private String justificativaRejeicao;

    public Solicitacao(DadosCadastroSolicitacao dados, Usuario usuario, EspacoFisico espacoFisico) {
        this.usuario = usuario;
        this.espacoFisico = espacoFisico;
        this.dataSolicitacao = dados.dataSolicitacao();
        this.dataReserva = dados.dataReserva();
        this.horaReserva = dados.horaReserva();
        this.status = dados.status() != null ? dados.status() : Status.PENDENTE;
        this.justificativaRejeicao = dados.justificativaRejeicao();
    }


}
