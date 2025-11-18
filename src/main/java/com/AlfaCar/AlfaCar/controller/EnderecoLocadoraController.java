//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import com.AlfaCar.AlfaCar.service.interfaces.EnderecoLocadoraService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoLocadoraController {
    private final EnderecoLocadoraService enderecoLocadoraService;

    public EnderecoLocadoraController(EnderecoLocadoraService enderecoLocadoraService) {
        this.enderecoLocadoraService = enderecoLocadoraService;
    }

    @PostMapping({"/locadora/{idLocadora}"})
    public ResponseEntity<?> cadastrarEndereco(@PathVariable Long idLocadora, @RequestBody EnderecoLocadora enderecoLocadora) {
        try {
            EnderecoLocadora novoEndereco = this.enderecoLocadoraService.cadastrarEndereco(idLocadora, enderecoLocadora);
            return ResponseEntity.ok(novoEndereco);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<EnderecoLocadora>> listarEnderecos() {
        return ResponseEntity.ok(this.enderecoLocadoraService.listarEnderecos());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<EnderecoLocadora> buscarEnderecoPorId(@PathVariable Long id) {
        return (ResponseEntity)this.enderecoLocadoraService.buscarEnderecoPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"/locadora/{locadoraId}"})
    public ResponseEntity<EnderecoLocadora> buscarEnderecoPorLocadoraId(@PathVariable Long locadoraId) {
        return (ResponseEntity)this.enderecoLocadoraService.buscarEnderecoPorLocadoraId(locadoraId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        this.enderecoLocadoraService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
