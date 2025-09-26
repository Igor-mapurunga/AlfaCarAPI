package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.service.interfaces.LocadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

    private final LocadoraService locadoraService;

    public LocadoraController(LocadoraService locadoraService) {
        this.locadoraService = locadoraService;
    }

    @PostMapping("/cadastrar/{idUsuario}")
    public ResponseEntity<Locadora> cadastrarLocadora(@RequestBody Locadora locadora) {

        Locadora novaLocadora = locadoraService.cadastrarLocadora(locadora);
        return ResponseEntity.ok(novaLocadora);
    }

    @GetMapping
    public ResponseEntity<List<Locadora>> listarLocadoras() {
        return ResponseEntity.ok(locadoraService.listarLocadoras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locadora> buscarLocadoraPorId(@PathVariable Long id) {
        Optional<Locadora> locadora = locadoraService.buscarLocadoraPorId(id);
        return locadora.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocadora(@PathVariable Long id) {
        locadoraService.deletarLocadora(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locadora> atualizarLocadora(@PathVariable Long id, @RequestBody Locadora locadoraAtualizada) {
        return locadoraService.atualizarLocadora(id, locadoraAtualizada)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
