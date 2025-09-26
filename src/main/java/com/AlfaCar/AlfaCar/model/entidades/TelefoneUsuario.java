package com.AlfaCar.AlfaCar.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "telefoneCliente") // Garante o nome correto da tabela no banco
public class TelefoneUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefone ")
    private Long idTelefone;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    // Construtores
    public TelefoneUsuario() {}

    public TelefoneUsuario(String telefone, Usuario usuario) {
        this.telefone = telefone;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
