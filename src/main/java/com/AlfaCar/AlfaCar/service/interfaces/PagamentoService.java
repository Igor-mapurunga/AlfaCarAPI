//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Pagamento;
import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    Pagamento cadastrarPagamento(Pagamento pagamento);

    List<Pagamento> listarPagamentos();

    Optional<Pagamento> buscarPagamentoPorId(Long id);

    void deletarPagamento(Long id);
}
