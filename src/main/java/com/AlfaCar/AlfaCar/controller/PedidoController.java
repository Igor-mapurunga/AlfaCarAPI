package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Pedido;

import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.service.interfaces.LocadoraService;
import com.AlfaCar.AlfaCar.service.interfaces.PedidoService;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import com.AlfaCar.AlfaCar.service.interfaces.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final UserService usuarioService;
    private final VeiculoService veiculoService;
    private final LocadoraService locadoraService;

    public PedidoController(PedidoService pedidoService, UserService usuarioService, VeiculoService veiculoService, LocadoraService locadoraService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
        this.veiculoService = veiculoService;
        this.locadoraService = locadoraService;
    }

    // Criar um novo pedido com IDs na URL
    @PostMapping("/usuario/{usuarioId}/veiculo/{veiculoId}/locadora/{locadoraId}")
    public ResponseEntity<Pedido> cadastrarPedido(
            @PathVariable Long usuarioId,
            @PathVariable Long veiculoId,
            @PathVariable Long locadoraId,
            @RequestBody Pedido pedidoRequest) {

        Optional<Usuario> usuarioOpt = usuarioService.buscarUsuarioPorId(usuarioId);
        Optional<Veiculo> veiculoOpt = veiculoService.buscarVeiculoPorId(veiculoId);
        Optional<Locadora> locadoraOpt = locadoraService.buscarLocadoraPorId(locadoraId);

        if (usuarioOpt.isPresent() && veiculoOpt.isPresent() && locadoraOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Veiculo veiculo = veiculoOpt.get();
            Locadora locadora = locadoraOpt.get();

            Pedido pedido = new Pedido();
            pedido.setDataPedido(pedidoRequest.getDataPedido());
            pedido.setStatusPedido(pedidoRequest.getStatusPedido());
            pedido.setUsuario(usuario);
            pedido.setVeiculo(veiculo);
            pedido.setLocadora(locadora);

            Pedido novoPedido = pedidoService.cadastrarPedido(pedido);
            return ResponseEntity.ok(novoPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    // Buscar um pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
