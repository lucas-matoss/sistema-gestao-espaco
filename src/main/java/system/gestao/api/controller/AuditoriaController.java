package system.gestao.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.gestao.api.auditoria.DadosCadastroAuditoria;
import system.gestao.api.auditoria.Auditoria;
import system.gestao.api.auditoria.AuditoriaRepository;

import java.util.List;

@RestController
@RequestMapping("auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAuditoria dados) {
        auditoriaRepository.save(new Auditoria(dados));
    }

    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaRepository.findAll();
    }

}
