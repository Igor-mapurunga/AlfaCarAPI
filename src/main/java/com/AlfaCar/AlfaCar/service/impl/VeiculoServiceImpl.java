//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.repository.VeiculoRepository;
import com.AlfaCar.AlfaCar.service.interfaces.VeiculoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return (Veiculo)this.veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarVeiculo() {
        return this.veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarVeiculoPorId(Long id) {
        return this.veiculoRepository.findById(id);
    }

    public void deletarVeiculo(Long id) {
        this.veiculoRepository.deleteById(id);
    }
}
