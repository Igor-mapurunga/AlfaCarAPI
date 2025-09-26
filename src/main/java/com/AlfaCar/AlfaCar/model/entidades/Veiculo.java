package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusVeiculo;
import com.AlfaCar.AlfaCar.model.enums.TipoCombustivel;
import com.AlfaCar.AlfaCar.model.enums.TipoVeiculo;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeiculo ")
    private Long id;

    @Column(name = "placa", nullable = false, length = 100)
    private String placa;

    @Column(name = "marca", nullable = false, length = 180)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 180)
    private String modelo; //adicionado diferente do script do drive

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoVeiculo", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCombustivel", nullable = false)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "kilometragem", nullable = false, precision = 8, scale = 2)
    private BigDecimal kilometragem;

    @Column(name = "precoDiario", nullable = false, precision = 7, scale = 2)
    private BigDecimal precoDiario;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusVeiculo", nullable = false)
    private StatusVeiculo statusVeiculo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(BigDecimal kilometragem) {
        this.kilometragem = kilometragem;
    }

    public BigDecimal getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(BigDecimal precoDiario) {
        this.precoDiario = precoDiario;
    }

    public StatusVeiculo getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
