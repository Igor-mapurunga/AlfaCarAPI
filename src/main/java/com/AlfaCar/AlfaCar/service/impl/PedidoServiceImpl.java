package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Pedido;
import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.model.enums.StatusPedido;
import com.AlfaCar.AlfaCar.model.enums.StatusVeiculo;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.repository.PedidoRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.repository.VeiculoRepository;
import com.AlfaCar.AlfaCar.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UserRepository usuarioRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private LocadoraRepository locadoraRepository;


    @Override
    public Pedido cadastrarPedido(Pedido pedido) {
        // Atualiza o status do veículo para LOCADO
        Veiculo veiculo = pedido.getVeiculo();
        veiculo.setStatusVeiculo(StatusVeiculo.LOCADO);
        veiculoRepository.save(veiculo);

        // Define status padrão do pedido, se ainda não tiver vindo com ele
        if (pedido.getStatusPedido() == null) {
            pedido.setStatusPedido(StatusPedido.APROVADO);
        }

        return pedidoRepository.save(pedido);
    }


    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setDataPedido(pedidoAtualizado.getDataPedido());
            pedido.setStatusPedido(pedidoAtualizado.getStatusPedido());
            pedido.setUsuario(pedidoAtualizado.getUsuario());
            pedido.setVeiculo(pedidoAtualizado.getVeiculo());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }

    @Override
    public void deletarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido não encontrado com id: " + id);
        }
    }
}