//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
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

@Entity
@Table(
        name = "chamadoSuporte"
)
public class ChamadoSuporte {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idChamadoSuporte"
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "statusSuporte",
            nullable = false
    )
    private StatusSuporte statusSuporte;
    @Column(
            name = "descricaoSuporte",
            length = 200,
            nullable = false
    )
    private String descricaoSuporte;
    @ManyToOne
    @JoinColumn(
            name = "usuario",
            nullable = false
    )
    private Usuario usuario;

    public ChamadoSuporte() {
    }

    public ChamadoSuporte(StatusSuporte statusSuporte, String descricaoSuporte, Usuario usuario) {
        this.statusSuporte = statusSuporte;
        this.descricaoSuporte = descricaoSuporte;
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusSuporte getStatusSuporte() {
        return this.statusSuporte;
    }

    public void setStatusSuporte(StatusSuporte statusSuporte) {
        this.statusSuporte = statusSuporte;
    }

    public String getDescricaoSuporte() {
        return this.descricaoSuporte;
    }

    public void setDescricaoSuporte(String descricaoSuporte) {
        this.descricaoSuporte = descricaoSuporte;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
