package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import jakarta.persistence.*;

@Entity
@Table(name = "chamadoSuporte")
public class ChamadoSuporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChamadoSuporte")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusSuporte", nullable = false)
    private StatusSuporte statusSuporte;

    @Column(name = "descricaoSuporte", length = 200, nullable = false)
    private String descricaoSuporte;

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    // Construtores
    public ChamadoSuporte() {}

    public ChamadoSuporte(StatusSuporte statusSuporte, String descricaoSuporte, Usuario usuario) {
        this.statusSuporte = statusSuporte;
        this.descricaoSuporte = descricaoSuporte;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusSuporte getStatusSuporte() {
        return statusSuporte;
    }

    public void setStatusSuporte(StatusSuporte statusSuporte) {
        this.statusSuporte = statusSuporte;
    }

    public String getDescricaoSuporte() {
        return descricaoSuporte;
    }

    public void setDescricaoSuporte(String descricaoSuporte) {
        this.descricaoSuporte = descricaoSuporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
