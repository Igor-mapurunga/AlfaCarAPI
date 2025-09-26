package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import com.AlfaCar.AlfaCar.service.interfaces.ChamadoSuporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chamados")
public class ChamadoSuporteController {

    private final ChamadoSuporteService chamadoSuporteService;

    public ChamadoSuporteController(ChamadoSuporteService chamadoSuporteService) {
        this.chamadoSuporteService = chamadoSuporteService;
    }

    // 📌 Criar um chamado de suporte para um usuário
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<ChamadoSuporte> abrirChamado(@PathVariable Long usuarioId, @RequestBody ChamadoSuporte chamadoSuporte) {
        ChamadoSuporte novoChamado = chamadoSuporteService.criarChamado(chamadoSuporte, usuarioId);
        return ResponseEntity.ok(novoChamado);
    }

    // 📌 Listar todos os chamados
    @GetMapping
    public ResponseEntity<List<ChamadoSuporte>> listarChamados() {
        return ResponseEntity.ok(chamadoSuporteService.buscarChamados());
    }

    // 📌 Buscar um chamado pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarChamadoPorId(@PathVariable Long id) {
        Optional<ChamadoSuporte> chamado = chamadoSuporteService.buscarChamadoPorId(id);
        return chamado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 📌 Buscar chamados por usuário
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ChamadoSuporte>> buscarChamadosPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(chamadoSuporteService.buscarChamadosPorUsuario(usuarioId));
    }

    // 📌 Buscar chamados por status
    @GetMapping("/status/{statusSuporte}")
    public ResponseEntity<List<ChamadoSuporte>> buscarChamadosPorStatus(@PathVariable StatusSuporte statusSuporte) {
        return ResponseEntity.ok(chamadoSuporteService.buscarChamadosPorStatus(statusSuporte));
    }

    // 📌 Atualizar um chamado de suporte
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarChamado(@PathVariable Long id, @RequestBody ChamadoSuporte chamadoAtualizado) {
        try {
            ChamadoSuporte chamadoAtualizadoDb = chamadoSuporteService.atualizarChamado(id, chamadoAtualizado);
            return ResponseEntity.ok(chamadoAtualizadoDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    // 📌 Deletar um chamado de suporte
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarChamado(@PathVariable Long id) {
//        try {
//            chamadoSuporteService.deletarChamado(id);
//            return ResponseEntity.noContent().build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
