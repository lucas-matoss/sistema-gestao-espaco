package system.gestao.api.historicoAvaliacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import system.gestao.api.solicitacao.Solicitacao;
import system.gestao.api.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "historico_avaliacao")
@Entity(name = "HistoricoAvaliacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoAvaliacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_avaliacao_id")
    private Long id;

    @Column(name = "solicitacao_id")
    private Long solicitacaoId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id", insertable = false, updatable = false)
    private Solicitacao solicitacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusHistorico status;

    private String justificativa;
    public HistoricoAvaliacao(DadosCadastroHistoricoAvaliacao dados) {
        this.solicitacaoId = dados.solicitacaoId();
        this.usuarioId = dados.usuarioId();
        this.dataAvaliacao = dados.dataAvaliacao();
        this.status = dados.status();
        this.justificativa = dados.justificativa();

    }

    public HistoricoAvaliacao(DadosCadastroHistoricoAvaliacao dados, Solicitacao solicitacao, Usuario usuario) {
        this.solicitacaoId = solicitacao.getId();
        this.usuarioId = usuario.getId();
        this.dataAvaliacao = dados.dataAvaliacao();
        this.status = dados.status();
        this.justificativa = dados.justificativa();
    }

}
