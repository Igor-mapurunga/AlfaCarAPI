//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Pedido;
import com.AlfaCar.AlfaCar.model.enums.StatusAluguel;
import com.AlfaCar.AlfaCar.repository.AluguelRepository;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.repository.PedidoRepository;
import com.AlfaCar.AlfaCar.service.interfaces.AluguelService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

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

    public Aluguel cadastrarAluguel(Long idPedido, Long idLocadora, Aluguel aluguel) {
        Pedido pedido = (Pedido)this.pedidoRepository.findById(idPedido).orElseThrow(() -> new IllegalArgumentException("Pedido com ID " + idPedido + " não encontrado."));
        Locadora locadora = (Locadora)this.locadoraRepository.findById(idLocadora).orElseThrow(() -> new IllegalArgumentException("Locadora com ID " + idLocadora + " não encontrada."));
        aluguel.setPedido(pedido);
        aluguel.setCliente(pedido.getUsuario());
        aluguel.setVeiculo(pedido.getVeiculo());
        aluguel.setLocadora(locadora);
        aluguel.setStatusAluguel(StatusAluguel.PENDENTE);
        return (Aluguel)this.aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return this.aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscarAluguelPorId(Long id) {
        return this.aluguelRepository.findById(id);
    }

    public List<Aluguel> buscarAlugueisPorClienteId(Long clienteId) {
        return this.aluguelRepository.findByClienteId(clienteId);
    }

    public List<Aluguel> buscarAlugueisPorVeiculoId(Long veiculoId) {
        return this.aluguelRepository.findByVeiculoId(veiculoId);
    }

    public Aluguel atualizarAluguel(Long id, Aluguel aluguelAtualizado) {
        return (Aluguel)this.aluguelRepository.findById(id).map((aluguel) -> {
            aluguel.setDataAluguel(aluguelAtualizado.getDataAluguel());
            aluguel.setDataDevolucao(aluguelAtualizado.getDataDevolucao());
            aluguel.setStatusAluguel(aluguelAtualizado.getStatusAluguel());
            return (Aluguel)this.aluguelRepository.save(aluguel);
        }).orElseThrow(() -> new IllegalArgumentException("Aluguel com ID " + id + " não encontrado."));
    }

    public void deletarAluguel(Long id) {
        if (!this.aluguelRepository.existsById(id)) {
            throw new IllegalArgumentException("Aluguel com ID " + id + " não encontrado.");
        } else {
            this.aluguelRepository.deleteById(id);
        }
    }
}
