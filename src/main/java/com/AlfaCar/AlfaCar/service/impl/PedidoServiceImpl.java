//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Pedido cadastrarPedido(Pedido pedido) {
        Veiculo veiculo = pedido.getVeiculo();
        veiculo.setStatusVeiculo(StatusVeiculo.LOCADO);
        this.veiculoRepository.save(veiculo);
        if (pedido.getStatusPedido() == null) {
            pedido.setStatusPedido(StatusPedido.APROVADO);
        }

        return (Pedido)this.pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return this.pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return (Pedido)this.pedidoRepository.findById(id).map((pedido) -> {
            pedido.setDataPedido(pedidoAtualizado.getDataPedido());
            pedido.setStatusPedido(pedidoAtualizado.getStatusPedido());
            pedido.setUsuario(pedidoAtualizado.getUsuario());
            pedido.setVeiculo(pedidoAtualizado.getVeiculo());
            return (Pedido)this.pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }

    public void deletarPedido(Long id) {
        if (this.pedidoRepository.existsById(id)) {
            this.pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido não encontrado com id: " + id);
        }
    }
}
