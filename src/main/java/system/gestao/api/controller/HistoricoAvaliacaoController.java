package system.gestao.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.gestao.api.historicoAvaliacao.*;
import system.gestao.api.solicitacao.Solicitacao;
import system.gestao.api.solicitacao.Status;
import system.gestao.api.solicitacao.SolicitacaoRepository;
import system.gestao.api.usuario.Usuario;
import system.gestao.api.usuario.UsuarioRepository;
import system.gestao.api.usuario.TipoUsuario;
import system.gestao.api.auditoria.Auditoria;
import system.gestao.api.auditoria.AuditoriaRepository;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("historicoAvaliacao")
public class HistoricoAvaliacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private HistoricoAvaliacaoRepository historicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroHistoricoAvaliacao dados) {
        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + dados.usuarioId()));

        if (usuario.getTipoUsuario() != TipoUsuario.GESTOR) {
            throw new RuntimeException("Apenas gestores podem aprovar ou rejeitar solicitações.");
        }

        Solicitacao solicitacao = solicitacaoRepository.findById(dados.solicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada."));

        if (dados.status() == StatusHistorico.APROVADA) {
            boolean duplicada = solicitacaoRepository.existsByEspacoFisicoAndDataReservaAndHoraReservaAndStatus(
                    solicitacao.getEspacoFisico(), solicitacao.getDataReserva(), solicitacao.getHoraReserva(), Status.APROVADA
            );

            if (duplicada) {
                throw new RuntimeException("Já existe uma solicitação aprovada para esse espaço, data e hora.");
            }

            solicitacao.setStatus(Status.APROVADA);
        } else {
            solicitacao.setStatus(Status.REJEITADA);
            solicitacao.setJustificativaRejeicao(dados.justificativa());
        }

        historicoRepository.save(new HistoricoAvaliacao(dados, solicitacao, usuario));

        solicitacaoRepository.save(solicitacao);

        Auditoria auditoria = new Auditoria(
                usuario.getId(),
                dados.status().toAcao(),
                LocalDateTime.now()
        );
        auditoriaRepository.save(auditoria);
    }



    @GetMapping
    public List<HistoricoAvaliacaoResponse> listar(@RequestParam(required = false) Long solicitacaoId,
                                                   @RequestParam(required = false) Long usuarioId) {
        List<HistoricoAvaliacao> historicos;

        if (solicitacaoId != null) {
            historicos = historicoRepository.findBySolicitacaoId(solicitacaoId);
        } else if (usuarioId != null) {
            historicos = historicoRepository.findByUsuarioId(usuarioId);
        } else {
            historicos = historicoRepository.findAll();
        }

        return historicos.stream().map(HistoricoAvaliacaoResponse::new).toList();
    }

}