//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "enderecoLocadora"
)
public class EnderecoLocadora {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idEnderecoLocadora"
    )
    private Long id;
    @Column(
            name = "logradouro",
            nullable = false,
            length = 45
    )
    private String logradouro;
    @Column(
            name = "numero",
            nullable = false,
            length = 10
    )
    private String numero;
    @Column(
            name = "bairro",
            nullable = false,
            length = 45
    )
    private String bairro;
    @Column(
            name = "cep",
            nullable = false,
            length = 8
    )
    private String cep;
    @Column(
            name = "cidade",
            nullable = false,
            length = 45
    )
    private String cidade;
    @Column(
            name = "UF",
            nullable = false,
            length = 2
    )
    private String uf;
    @OneToOne
    @JoinColumn(
            name = "locadora",
            nullable = false
    )
    private Locadora locadora;

    public EnderecoLocadora() {
    }

    public EnderecoLocadora(String logradouro, String numero, String bairro, String cep, String cidade, String uf, Locadora locadora) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.locadora = locadora;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Locadora getLocadora() {
        return this.locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
}
