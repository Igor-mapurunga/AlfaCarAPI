//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusVeiculo;
import com.AlfaCar.AlfaCar.model.enums.TipoCombustivel;
import com.AlfaCar.AlfaCar.model.enums.TipoVeiculo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
        name = "veiculo"
)
public class Veiculo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idVeiculo "
    )
    private Long id;
    @Column(
            name = "placa",
            nullable = false,
            length = 100
    )
    private String placa;
    @Column(
            name = "marca",
            nullable = false,
            length = 180
    )
    private String marca;
    @Column(
            name = "modelo",
            nullable = false,
            length = 180
    )
    private String modelo;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "tipoVeiculo",
            nullable = false
    )
    private TipoVeiculo tipoVeiculo;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "tipoCombustivel",
            nullable = false
    )
    private TipoCombustivel tipoCombustivel;
    @Column(
            name = "kilometragem",
            nullable = false,
            precision = 8,
            scale = 2
    )
    private BigDecimal kilometragem;
    @Column(
            name = "precoDiario",
            nullable = false,
            precision = 7,
            scale = 2
    )
    private BigDecimal precoDiario;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "statusVeiculo",
            nullable = false
    )
    private StatusVeiculo statusVeiculo;
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "id_locadora",
            nullable = false
    )
    @JsonBackReference
    private Locadora locadora;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return this.tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return this.tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getKilometragem() {
        return this.kilometragem;
    }

    public void setKilometragem(BigDecimal kilometragem) {
        this.kilometragem = kilometragem;
    }

    public BigDecimal getPrecoDiario() {
        return this.precoDiario;
    }

    public void setPrecoDiario(BigDecimal precoDiario) {
        this.precoDiario = precoDiario;
    }

    public StatusVeiculo getStatusVeiculo() {
        return this.statusVeiculo;
    }

    public Locadora getLocadora() {
        return this.locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
