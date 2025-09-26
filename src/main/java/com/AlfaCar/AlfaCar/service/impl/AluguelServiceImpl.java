package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.*;
import com.AlfaCar.AlfaCar.model.enums.StatusAluguel;
import com.AlfaCar.AlfaCar.repository.AluguelRepository;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.repository.PedidoRepository;
import com.AlfaCar.AlfaCar.service.interfaces.AluguelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final PedidoRepository pedidoRepository;
    private final LocadoraRepository locadoraRepository;

    public AluguelServiceImpl(AluguelRepository aluguelRepository, PedidoRepository pedidoRepository, LocadoraRepository locadoraRepository) {
        this.aluguelRepository = aluguelRepository;
        this.pedidoRepository = pedidoRepository;
        this.locadoraRepository = locadoraRepository;
    }

    @Override
    public Aluguel cadastrarAluguel(Long idPedido, Long idLocadora, Aluguel aluguel) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido com ID " + idPedido + " não encontrado."));

        Locadora locadora = locadoraRepository.findById(idLocadora)
                .orElseThrow(() -> new IllegalArgumentException("Locadora com ID " + idLocadora + " não encontrada."));

        aluguel.setPedido(pedido);
        aluguel.setCliente(pedido.getUsuario());
        aluguel.setVeiculo(pedido.getVeiculo());
        aluguel.setLocadora(locadora);
        aluguel.setStatusAluguel(StatusAluguel.PENDENTE);

        return aluguelRepository.save(aluguel);
    }

    @Override
    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.findAll();
    }

    @Override
    public Optional<Aluguel> buscarAluguelPorId(Long id) {
        return aluguelRepository.findById(id);
    }

    @Override
    public List<Aluguel> buscarAlugueisPorClienteId(Long clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Aluguel> buscarAlugueisPorVeiculoId(Long veiculoId) {
        return aluguelRepository.findByVeiculoId(veiculoId);
    }

    @Override
    public Aluguel atualizarAluguel(Long id, Aluguel aluguelAtualizado) {
        return aluguelRepository.findById(id).map(aluguel -> {
            aluguel.setDataAluguel(aluguelAtualizado.getDataAluguel());
            aluguel.setDataDevolucao(aluguelAtualizado.getDataDevolucao());
            aluguel.setStatusAluguel(aluguelAtualizado.getStatusAluguel());
            return aluguelRepository.save(aluguel);
        }).orElseThrow(() -> new IllegalArgumentException("Aluguel com ID " + id + " não encontrado."));
    }

    @Override
    public void deletarAluguel(Long id) {
        if (!aluguelRepository.existsById(id)) {
            throw new IllegalArgumentException("Aluguel com ID " + id + " não encontrado.");
        }
        aluguelRepository.deleteById(id);
    }
}
