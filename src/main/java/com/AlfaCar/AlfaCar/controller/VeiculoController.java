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

    @PostMapping("/{idLocadora}")
    public ResponseEntity<Veiculo> cadastrarVeiculo(
            @PathVariable Long idLocadora,
            @RequestBody Veiculo veiculo
    ) {
        Optional<Locadora> locadoraOptional = locadoraService.buscarLocadoraPorId(idLocadora);

        if (locadoraOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Locadora locadora = locadoraOptional.get();
        veiculo.setLocadora(locadora);

        Veiculo novoVeiculo = veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculo();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(
            @PathVariable Long id,
            @RequestBody Veiculo veiculoAtualizado
    ) {
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
            veiculoExistente.setImagemUrl(veiculoAtualizado.getImagemUrl()); // 🚀 CAMPO NOVO

            Veiculo veiculoSalvo = veiculoService.cadastrarVeiculo(veiculoExistente);
            return ResponseEntity.ok(veiculoSalvo);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);

        if (veiculo.isPresent()) {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
