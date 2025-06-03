package system.gestao.api.espacoFisico;

import java.math.BigDecimal;

public record DadosCadastroEspacoFisico(String nome, TipoEspaco tipoEspaco, BigDecimal metragem, String equipamentos, String descricao) {
}
