package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import java.util.List;
import java.util.Optional;

public interface AluguelService {

    Aluguel cadastrarAluguel(Long idPedido, Long idLocadora, Aluguel aluguel);


    List<Aluguel> listarAlugueis();

    Optional<Aluguel> buscarAluguelPorId(Long id);

    List<Aluguel> buscarAlugueisPorClienteId(Long clienteId);

    List<Aluguel> buscarAlugueisPorVeiculoId(Long veiculoId);

    Aluguel atualizarAluguel(Long id, Aluguel aluguelAtualizado);

    void deletarAluguel(Long id);
}
