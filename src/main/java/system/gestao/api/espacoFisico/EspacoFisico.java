package system.gestao.api.espacoFisico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "espaco_fisico")
@Entity(name = "EspacoFisico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EspacoFisico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "espaco_fisico_id")
    private Long id;
    @Column(name = "nome_espaco")
    private String nome;
    private BigDecimal metragem;
    private String equipamentos;
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_espaco")
    private TipoEspaco tipoEspaco;

    public EspacoFisico(DadosCadastroEspacoFisico dados) {
        this.nome = dados.nome();
        this.metragem = dados.metragem();
        this.equipamentos = dados.equipamentos();
        this.descricao = dados.descricao();
        this.tipoEspaco = dados.tipoEspaco();

    }
}
