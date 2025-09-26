package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import com.AlfaCar.AlfaCar.service.interfaces.EnderecoLocadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoLocadoraController {

    private final EnderecoLocadoraService enderecoLocadoraService;

    public EnderecoLocadoraController(EnderecoLocadoraService enderecoLocadoraService) {
        this.enderecoLocadoraService = enderecoLocadoraService;
    }


    @PostMapping("/locadora/{idLocadora}")
    public ResponseEntity<?> cadastrarEndereco(
            @PathVariable Long idLocadora,
            @RequestBody EnderecoLocadora enderecoLocadora) {

        try {
            EnderecoLocadora novoEndereco = enderecoLocadoraService.cadastrarEndereco(idLocadora, enderecoLocadora);
            return ResponseEntity.ok(novoEndereco);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<EnderecoLocadora>> listarEnderecos() {
        return ResponseEntity.ok(enderecoLocadoraService.listarEnderecos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EnderecoLocadora> buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoLocadoraService.buscarEnderecoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/locadora/{locadoraId}")
    public ResponseEntity<EnderecoLocadora> buscarEnderecoPorLocadoraId(@PathVariable Long locadoraId) {
        return enderecoLocadoraService.buscarEnderecoPorLocadoraId(locadoraId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    // 📌 Atualizar um endereço existente
//    @PutMapping("/{id}")
//    public ResponseEntity<?> atualizarEndereco(
//            @PathVariable Long id,
//            @RequestBody EnderecoLocadora enderecoAtualizado) {
//
//        try {
//            EnderecoLocadora enderecoAtualizadoDb = enderecoLocadoraService.atualizarEndereco(id, enderecoAtualizado);
//            return ResponseEntity.ok(enderecoAtualizadoDb);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoLocadoraService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
