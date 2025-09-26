package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusAluguel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAluguel")
    private Long id;

    @Column(name = "dataDoPedido", nullable = false)
    private LocalDateTime dataDoPedido;

    @Column(name = "dataAluguel", nullable = false)
    private LocalDateTime dataAluguel;

    @Column(name = "dataDevolucao", nullable = false)
    private LocalDateTime dataDevolucao;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusAluguel", nullable = false)
    private StatusAluguel statusAluguel;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @OneToOne
    @JoinColumn(name = "pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idLocadora", nullable = false)
    private Locadora locadora;

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Aluguel() {}

    public Aluguel(LocalDateTime dataDoPedido, LocalDateTime dataAluguel, LocalDateTime dataDevolucao,
                   StatusAluguel statusAluguel, Usuario cliente, Veiculo veiculo, Pedido pedido) {
        this.dataDoPedido = dataDoPedido;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.statusAluguel = statusAluguel;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.pedido = pedido;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public void setStatusAluguel(StatusAluguel statusAluguel) {
        this.statusAluguel = statusAluguel;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
