package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    Pedido cadastrarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    Optional<Pedido> buscarPedidoPorId(Long id);
    Pedido atualizarPedido(Long id, Pedido pedidoAtualizado);
    void deletarPedido(Long id);

}
