package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    // 📌 Buscar todos os aluguéis de um cliente específico
    List<Aluguel> findByClienteId(Long clienteId);

    // 📌 Buscar todos os aluguéis de um veículo específico
    List<Aluguel> findByVeiculoId(Long veiculoId);

    // 📌 Buscar todos os aluguéis por status
    List<Aluguel> findByStatusAluguel(String statusAluguel);
}
