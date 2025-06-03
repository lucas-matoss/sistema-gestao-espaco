package system.gestao.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.gestao.api.espacoFisico.DadosCadastroEspacoFisico;
import system.gestao.api.espacoFisico.EspacoFisico;
import system.gestao.api.espacoFisico.EspacoFisicoRepository;

@RestController
@RequestMapping("espacoFisico")
public class EspacoFisicoController {

    @Autowired
    private EspacoFisicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroEspacoFisico dados) {
        repository.save(new EspacoFisico(dados));
    }
}
