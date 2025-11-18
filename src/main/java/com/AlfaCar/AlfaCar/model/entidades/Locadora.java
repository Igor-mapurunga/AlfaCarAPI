//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(
        name = "locadora"
)
public class Locadora {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idLocadora"
    )
    private Long id;
    @Column(
            name = "nome",
            nullable = false,
            length = 100
    )
    private String nome;
    @OneToOne
    @JoinColumn(
            name = "idCliente",
            referencedColumnName = "idCliente",
            nullable = false
    )
    private Usuario usuario;
    @OneToMany(
            mappedBy = "locadora",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Veiculo> veiculos;

    public Locadora() {
    }

    public Locadora(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
