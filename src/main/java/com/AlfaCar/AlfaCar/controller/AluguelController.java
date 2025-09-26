package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import com.AlfaCar.AlfaCar.service.interfaces.AluguelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }


    @PostMapping("/pedido/{idPedido}/locadora/{idLocadora}")
    public ResponseEntity<?> cadastrarAluguel(
            @PathVariable Long idPedido,
            @PathVariable Long idLocadora,
            @RequestBody Aluguel aluguel) {

        try {
            Aluguel novoAluguel = aluguelService.cadastrarAluguel(idPedido, idLocadora, aluguel);
            return ResponseEntity.ok(novoAluguel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        return ResponseEntity.ok(aluguelService.listarAlugueis());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAluguelPorId(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelService.buscarAluguelPorId(id);
        return aluguel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Aluguel>> buscarAlugueisPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(aluguelService.buscarAlugueisPorClienteId(clienteId));
    }


    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<Aluguel>> buscarAlugueisPorVeiculo(@PathVariable Long veiculoId) {
        return ResponseEntity.ok(aluguelService.buscarAlugueisPorVeiculoId(veiculoId));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluguel(@PathVariable Long id, @RequestBody Aluguel aluguelAtualizado) {
        try {
            Aluguel aluguelAtualizadoDb = aluguelService.atualizarAluguel(id, aluguelAtualizado);
            return ResponseEntity.ok(aluguelAtualizadoDb);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id) {
        try {
            aluguelService.deletarAluguel(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
