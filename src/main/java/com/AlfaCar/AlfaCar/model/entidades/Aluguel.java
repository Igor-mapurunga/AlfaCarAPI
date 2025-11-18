//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusAluguel;
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
        name = "aluguel"
)
public class Aluguel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idAluguel"
    )
    private Long id;
    @Column(
            name = "dataDoPedido",
            nullable = false
    )
    private LocalDateTime dataDoPedido;
    @Column(
            name = "dataAluguel",
            nullable = false
    )
    private LocalDateTime dataAluguel;
    @Column(
            name = "dataDevolucao",
            nullable = false
    )
    private LocalDateTime dataDevolucao;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "statusAluguel",
            nullable = false
    )
    private StatusAluguel statusAluguel;
    @ManyToOne
    @JoinColumn(
            name = "cliente"
    )
    private Usuario cliente;
    @ManyToOne
    @JoinColumn(
            name = "veiculo"
    )
    private Veiculo veiculo;
    @OneToOne
    @JoinColumn(
            name = "pedido",
            nullable = false
    )
    private Pedido pedido;
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

    public Aluguel() {
    }

    public Aluguel(LocalDateTime dataDoPedido, LocalDateTime dataAluguel, LocalDateTime dataDevolucao, StatusAluguel statusAluguel, Usuario cliente, Veiculo veiculo, Pedido pedido) {
        this.dataDoPedido = dataDoPedido;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.statusAluguel = statusAluguel;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.pedido = pedido;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataDoPedido() {
        return this.dataDoPedido;
    }

    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public LocalDateTime getDataAluguel() {
        return this.dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusAluguel getStatusAluguel() {
        return this.statusAluguel;
    }

    public void setStatusAluguel(StatusAluguel statusAluguel) {
        this.statusAluguel = statusAluguel;
    }

    public Usuario getCliente() {
        return this.cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
