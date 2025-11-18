//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Pagamento;
import com.AlfaCar.AlfaCar.model.entidades.Pedido;
import com.AlfaCar.AlfaCar.service.impl.StripeService;
import com.AlfaCar.AlfaCar.service.interfaces.PagamentoService;
import com.AlfaCar.AlfaCar.service.interfaces.PedidoService;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pagamentos"})
public class PagamentoController {
    private final StripeService stripeService;
    private final PagamentoService pagamentoService;
    private final PedidoService pedidoService;

    public PagamentoController(StripeService stripeService, PagamentoService pagamentoService, PedidoService pedidoService) {
        this.stripeService = stripeService;
        this.pagamentoService = pagamentoService;
        this.pedidoService = pedidoService;
    }

    @PostMapping({"/checkout"})
    public ResponseEntity<String> iniciarPagamento(@RequestParam BigDecimal valor) {
        try {
            String urlPagamento = this.stripeService.criarSessaoDePagamento(valor, "Aluguel de Veículo");
            return ResponseEntity.ok(urlPagamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar pagamento: " + e.getMessage());
        }
    }

    @PostMapping({"/pedido/{idPedido}"})
    public ResponseEntity<Pagamento> criarPagamentoParaPedido(@PathVariable Long idPedido, @RequestBody Pagamento pagamentoRequest) {
        Optional<Pedido> pedidoOpt = this.pedidoService.buscarPedidoPorId(idPedido);
        if (pedidoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Pedido pedido = (Pedido)pedidoOpt.get();
            Pagamento pagamento = new Pagamento();
            pagamento.setStatusPagamento(pagamentoRequest.getStatusPagamento());
            pagamento.setValor(pagamentoRequest.getValor());
            pagamento.setPedido(pedido);
            Pagamento novoPagamento = this.pagamentoService.cadastrarPagamento(pagamento);
            return ResponseEntity.ok(novoPagamento);
        }
    }

    @GetMapping({"/sucesso"})
    public ResponseEntity<String> pagamentoSucesso() {
        return ResponseEntity.ok("Pagamento concluído com sucesso! Obrigado pela sua compra.");
    }

    @GetMapping({"/cancelado"})
    public ResponseEntity<String> pagamentoCancelado() {
        return ResponseEntity.ok("O pagamento foi cancelado. Se precisar de ajuda, entre em contato.");
    }
}
