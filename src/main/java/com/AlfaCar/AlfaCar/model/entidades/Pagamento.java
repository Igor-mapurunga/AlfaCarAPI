//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusPagamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
        name = "pagamento"
)
public class Pagamento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idPagamento"
    )
    private Long id;
    @Column(
            name = "valor",
            nullable = false,
            precision = 12,
            scale = 2
    )
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "statusPagamento",
            nullable = false
    )
    private StatusPagamento statusPagamento;
    @OneToOne
    @JoinColumn(
            name = "pedido",
            nullable = false
    )
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(BigDecimal valor, StatusPagamento statusPagamento, Pedido pedido) {
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.pedido = pedido;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatusPagamento() {
        return this.statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
