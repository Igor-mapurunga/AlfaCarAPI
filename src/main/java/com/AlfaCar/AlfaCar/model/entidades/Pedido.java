//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "pedido"
)
public class Pedido {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idPedido "
    )
    private Long id;
    @Column(
            name = "dataPedido",
            nullable = false
    )
    private LocalDateTime dataPedido;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "statusPedido",
            nullable = false
    )
    private StatusPedido statusPedido;
    @ManyToOne
    @JoinColumn(
            name = "usuario",
            nullable = false
    )
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(
            name = "veiculo",
            nullable = false
    )
    private Veiculo veiculo;
    @OneToOne(
            mappedBy = "pedido",
            cascade = {CascadeType.ALL}
    )
    private Pagamento pagamento;
    @ManyToOne
    @JoinColumn(
            name = "idLocadora",
            nullable = false
    )
    private Locadora locadora;

    public Locadora getLocadora() {
        return this.locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return this.statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
