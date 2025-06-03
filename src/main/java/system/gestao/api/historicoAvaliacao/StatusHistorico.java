package system.gestao.api.historicoAvaliacao;

import system.gestao.api.auditoria.Acao;

public enum StatusHistorico {
    APROVADA,
    REJEITADA;

    public Acao toAcao() {
        return switch (this) {
            case APROVADA -> Acao.APROVADA;
            case REJEITADA -> Acao.REJEITADA;
        };
    }
}
