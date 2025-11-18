//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "telefoneCliente"
)
public class TelefoneUsuario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idTelefone"
    )
    private Long idTelefone;
    @Column(
            name = "telefone",
            nullable = false,
            length = 15
    )
    private String telefone;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "usuario_id",
            nullable = false
    )
    @JsonIgnore
    private Usuario usuario;

    public TelefoneUsuario() {
    }

    public TelefoneUsuario(String telefone, Usuario usuario) {
        this.telefone = telefone;
        this.usuario = usuario;
    }

    public Long getIdTelefone() {
        return this.idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
