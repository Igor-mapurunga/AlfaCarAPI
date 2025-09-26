package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    Veiculo cadastrarVeiculo(Veiculo veiculo);
    List<Veiculo> listarVeiculo();
    Optional<Veiculo> buscarVeiculoPorId(Long id);
    void deletarVeiculo(Long id);
}
