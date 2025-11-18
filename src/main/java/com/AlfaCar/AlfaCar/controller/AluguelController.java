//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import com.AlfaCar.AlfaCar.service.interfaces.AluguelService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/alugueis"})
public class AluguelController {
    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping({"/pedido/{idPedido}/locadora/{idLocadora}"})
    public ResponseEntity<?> cadastrarAluguel(@PathVariable Long idPedido, @PathVariable Long idLocadora, @RequestBody Aluguel aluguel) {
        try {
            Aluguel novoAluguel = this.aluguelService.cadastrarAluguel(idPedido, idLocadora, aluguel);
            return ResponseEntity.ok(novoAluguel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        return ResponseEntity.ok(this.aluguelService.listarAlugueis());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> buscarAluguelPorId(@PathVariable Long id) {
        Optional<Aluguel> aluguel = this.aluguelService.buscarAluguelPorId(id);
        return (ResponseEntity)aluguel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"/cliente/{clienteId}"})
    public ResponseEntity<List<Aluguel>> buscarAlugueisPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(this.aluguelService.buscarAlugueisPorClienteId(clienteId));
    }

    @GetMapping({"/veiculo/{veiculoId}"})
    public ResponseEntity<List<Aluguel>> buscarAlugueisPorVeiculo(@PathVariable Long veiculoId) {
        return ResponseEntity.ok(this.aluguelService.buscarAlugueisPorVeiculoId(veiculoId));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> atualizarAluguel(@PathVariable Long id, @RequestBody Aluguel aluguelAtualizado) {
        try {
            Aluguel aluguelAtualizadoDb = this.aluguelService.atualizarAluguel(id, aluguelAtualizado);
            return ResponseEntity.ok(aluguelAtualizadoDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id) {
        try {
            this.aluguelService.deletarAluguel(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException var3) {
            return ResponseEntity.badRequest().build();
        }
    }
}
