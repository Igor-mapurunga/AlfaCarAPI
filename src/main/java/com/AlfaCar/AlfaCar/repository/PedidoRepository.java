package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
