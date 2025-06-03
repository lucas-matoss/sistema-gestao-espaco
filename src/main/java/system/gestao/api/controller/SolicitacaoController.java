package system.gestao.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.gestao.api.espacoFisico.EspacoFisico;
import system.gestao.api.espacoFisico.EspacoFisicoRepository;
import system.gestao.api.solicitacao.DadosCadastroSolicitacao;
import system.gestao.api.solicitacao.Solicitacao;
import system.gestao.api.solicitacao.SolicitacaoRepository;
import system.gestao.api.solicitacao.Status;
import system.gestao.api.usuario.TipoUsuario;
import system.gestao.api.usuario.Usuario;
import system.gestao.api.usuario.UsuarioRepository;

import java.util.List;


@RestController
@RequestMapping("solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EspacoFisicoRepository espacoFisicoRepository;

    @GetMapping
    public List<Solicitacao> listar(@RequestParam(required = false) Long usuarioId,
                                    @RequestParam(required = false) Status status) {
        if (usuarioId != null && status != null) {
            return solicitacaoRepository.findByUsuarioIdAndStatus(usuarioId, status);
        } else if (usuarioId != null) {
            return solicitacaoRepository.findByUsuarioId(usuarioId);
        } else if (status != null) {
            return solicitacaoRepository.findByStatus(status);
        }
        return solicitacaoRepository.findAll();
    }


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroSolicitacao dados) {
        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + dados.usuarioId()));

        if(usuario.getTipoUsuario() != TipoUsuario.SOLICITANTE) {
            throw new RuntimeException("Apenas solicitantes podem criar solicitações");
        }

        EspacoFisico espaco = espacoFisicoRepository.findById(dados.espacoFisicoId())
                .orElseThrow(() -> new RuntimeException("Espaço físico não encontrado com ID: " + dados.espacoFisicoId()));

        boolean duplicada = solicitacaoRepository.existsByEspacoFisicoAndDataReservaAndHoraReservaAndStatus(
                espaco, dados.dataReserva(), dados.horaReserva(), Status.APROVADA
        );
        if (duplicada) {
            throw new RuntimeException("Já existe uma solicitação aprovada para esse espaço, data e hora.");
        }

        Solicitacao solicitacao = new Solicitacao(dados, usuario, espaco);
        solicitacaoRepository.save(solicitacao);
    }
}
