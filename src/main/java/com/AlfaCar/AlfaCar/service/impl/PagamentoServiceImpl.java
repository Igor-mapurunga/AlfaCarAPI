//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Pagamento;
import com.AlfaCar.AlfaCar.repository.PagamentoRepository;
import com.AlfaCar.AlfaCar.service.interfaces.PagamentoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        return (Pagamento)this.pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return this.pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPagamentoPorId(Long id) {
        return this.pagamentoRepository.findById(id);
    }

    public void deletarPagamento(Long id) {
        this.pagamentoRepository.deleteById(id);
    }
}
