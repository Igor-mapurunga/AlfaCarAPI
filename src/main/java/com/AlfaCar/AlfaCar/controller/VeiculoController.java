//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.service.impl.LocadoraServiceImpl;
import com.AlfaCar.AlfaCar.service.interfaces.VeiculoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"/veiculos"})
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private LocadoraServiceImpl locadoraService;

    @PostMapping({"/{idLocadora}"})
    public ResponseEntity<Veiculo> cadastrarVeiculo(@PathVariable Long idLocadora, @RequestBody Veiculo veiculo) {
        Optional<Locadora> locadoraOptional = this.locadoraService.buscarLocadoraPorId(idLocadora);
        if (locadoraOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Locadora locadora = (Locadora)locadoraOptional.get();
            veiculo.setLocadora(locadora);
            Veiculo novoVeiculo = this.veiculoService.cadastrarVeiculo(veiculo);
            return ResponseEntity.ok(novoVeiculo);
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = this.veiculoService.listarVeiculo();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = this.veiculoService.buscarVeiculoPorId(id);
        return (ResponseEntity)veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOptional = this.veiculoService.buscarVeiculoPorId(id);
        if (veiculoOptional.isPresent()) {
            Veiculo veiculoExistente = (Veiculo)veiculoOptional.get();
            veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
            veiculoExistente.setMarca(veiculoAtualizado.getMarca());
            veiculoExistente.setModelo(veiculoAtualizado.getModelo());
            veiculoExistente.setTipoVeiculo(veiculoAtualizado.getTipoVeiculo());
            veiculoExistente.setTipoCombustivel(veiculoAtualizado.getTipoCombustivel());
            veiculoExistente.setKilometragem(veiculoAtualizado.getKilometragem());
            veiculoExistente.setPrecoDiario(veiculoAtualizado.getPrecoDiario());
            veiculoExistente.setStatusVeiculo(veiculoAtualizado.getStatusVeiculo());
            Veiculo veiculoSalvo = this.veiculoService.cadastrarVeiculo(veiculoExistente);
            return ResponseEntity.ok(veiculoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        Optional<Veiculo> veiculo = this.veiculoService.buscarVeiculoPorId(id);
        if (veiculo.isPresent()) {
            this.veiculoService.deletarVeiculo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
