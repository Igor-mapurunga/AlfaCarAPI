//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Pedido;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.model.entidades.Veiculo;
import com.AlfaCar.AlfaCar.service.interfaces.LocadoraService;
import com.AlfaCar.AlfaCar.service.interfaces.PedidoService;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import com.AlfaCar.AlfaCar.service.interfaces.VeiculoService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pedidos"})
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

    @PostMapping({"/usuario/{usuarioId}/veiculo/{veiculoId}/locadora/{locadoraId}"})
    public ResponseEntity<Pedido> cadastrarPedido(@PathVariable Long usuarioId, @PathVariable Long veiculoId, @PathVariable Long locadoraId, @RequestBody Pedido pedidoRequest) {
        Optional<Usuario> usuarioOpt = this.usuarioService.buscarUsuarioPorId(usuarioId);
        Optional<Veiculo> veiculoOpt = this.veiculoService.buscarVeiculoPorId(veiculoId);
        Optional<Locadora> locadoraOpt = this.locadoraService.buscarLocadoraPorId(locadoraId);
        if (usuarioOpt.isPresent() && veiculoOpt.isPresent() && locadoraOpt.isPresent()) {
            Usuario usuario = (Usuario)usuarioOpt.get();
            Veiculo veiculo = (Veiculo)veiculoOpt.get();
            Locadora locadora = (Locadora)locadoraOpt.get();
            Pedido pedido = new Pedido();
            pedido.setDataPedido(pedidoRequest.getDataPedido());
            pedido.setStatusPedido(pedidoRequest.getStatusPedido());
            pedido.setUsuario(usuario);
            pedido.setVeiculo(veiculo);
            pedido.setLocadora(locadora);
            Pedido novoPedido = this.pedidoService.cadastrarPedido(pedido);
            return ResponseEntity.ok(novoPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = this.pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = this.pedidoService.buscarPedidoPorId(id);
        return (ResponseEntity)pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
