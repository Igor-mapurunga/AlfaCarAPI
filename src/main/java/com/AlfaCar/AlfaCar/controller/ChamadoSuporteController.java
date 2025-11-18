//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import com.AlfaCar.AlfaCar.service.interfaces.ChamadoSuporteService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/chamados"})
public class ChamadoSuporteController {
    private final ChamadoSuporteService chamadoSuporteService;

    public ChamadoSuporteController(ChamadoSuporteService chamadoSuporteService) {
        this.chamadoSuporteService = chamadoSuporteService;
    }

    @PostMapping({"/usuario/{usuarioId}"})
    public ResponseEntity<ChamadoSuporte> abrirChamado(@PathVariable Long usuarioId, @RequestBody ChamadoSuporte chamadoSuporte) {
        ChamadoSuporte novoChamado = this.chamadoSuporteService.criarChamado(chamadoSuporte, usuarioId);
        return ResponseEntity.ok(novoChamado);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoSuporte>> listarChamados() {
        return ResponseEntity.ok(this.chamadoSuporteService.buscarChamados());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> buscarChamadoPorId(@PathVariable Long id) {
        Optional<ChamadoSuporte> chamado = this.chamadoSuporteService.buscarChamadoPorId(id);
        return (ResponseEntity)chamado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"/usuario/{usuarioId}"})
    public ResponseEntity<List<ChamadoSuporte>> buscarChamadosPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(this.chamadoSuporteService.buscarChamadosPorUsuario(usuarioId));
    }

    @GetMapping({"/status/{statusSuporte}"})
    public ResponseEntity<List<ChamadoSuporte>> buscarChamadosPorStatus(@PathVariable StatusSuporte statusSuporte) {
        return ResponseEntity.ok(this.chamadoSuporteService.buscarChamadosPorStatus(statusSuporte));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> atualizarChamado(@PathVariable Long id, @RequestBody ChamadoSuporte chamadoAtualizado) {
        try {
            ChamadoSuporte chamadoAtualizadoDb = this.chamadoSuporteService.atualizarChamado(id, chamadoAtualizado);
            return ResponseEntity.ok(chamadoAtualizadoDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
