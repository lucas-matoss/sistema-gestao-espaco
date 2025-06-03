package system.gestao.api.auditoria;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Table(name = "auditoria")
@Entity(name = "Auditoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Auditoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditoria_id")
    private Long id;
    private Long usuarioId;

    @Enumerated(EnumType.STRING)
    @Column(name = "acao")
    private Acao acao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;


    public Auditoria(DadosCadastroAuditoria dados) {
        this.usuarioId = dados.usuarioId();
        this.acao = dados.acao();
        this.dataHora = dados.dataHora();

    }

    public Auditoria(Long usuarioId, Acao acao, LocalDateTime dataHora) {
        this.usuarioId = usuarioId;
        this.acao = acao;
        this.dataHora = dataHora;
    }

}
