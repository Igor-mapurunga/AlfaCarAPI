package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.service.interfaces.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    // Cadastrar um novo veículo
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    // Listar todos os veículos
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculo();
        return ResponseEntity.ok(veiculos);
    }

    // Buscar um veículo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um veículo
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOptional = veiculoService.buscarVeiculoPorId(id);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculoExistente = veiculoOptional.get();
            veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
            veiculoExistente.setMarca(veiculoAtualizado.getMarca());
            veiculoExistente.setModelo(veiculoAtualizado.getModelo());
            veiculoExistente.setTipoVeiculo(veiculoAtualizado.getTipoVeiculo());
            veiculoExistente.setTipoCombustivel(veiculoAtualizado.getTipoCombustivel());
            veiculoExistente.setKilometragem(veiculoAtualizado.getKilometragem());
            veiculoExistente.setPrecoDiario(veiculoAtualizado.getPrecoDiario());
            veiculoExistente.setStatusVeiculo(veiculoAtualizado.getStatusVeiculo());

            Veiculo veiculoSalvo = veiculoService.cadastrarVeiculo(veiculoExistente);
            return ResponseEntity.ok(veiculoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar um veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        if (veiculo.isPresent()) {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
