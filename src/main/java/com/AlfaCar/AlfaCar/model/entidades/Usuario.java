//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.model.entidades;

import com.AlfaCar.AlfaCar.model.enums.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "usuario"
)
public class Usuario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idCliente"
    )
    private Long id;
    @Column(
            name = "nome",
            nullable = false,
            length = 100
    )
    private String nome;
    @Column(
            name = "email",
            unique = true,
            nullable = false,
            length = 100
    )
    private String email;
    @Column(
            name = "cpf",
            unique = true,
            nullable = false,
            length = 14
    )
    private String cpf;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    @Column(
            name = "senha",
            nullable = false
    )
    private String senha;
    @Column(
            name = "dataNascimento",
            nullable = false
    )
    private LocalDate dataNascimento;
    @OneToMany(
            mappedBy = "usuario",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<TelefoneUsuario> telefones = new ArrayList();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<TelefoneUsuario> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<TelefoneUsuario> telefones) {
        this.telefones = telefones;
    }

    public String toString() {
        return "Usuario{id=" + this.id + ", nome='" + this.nome + "', email='" + this.email + "', cpf='" + this.cpf + "', tipo=" + this.tipo + ", senha='" + this.senha + "', dataNascimento=" + this.dataNascimento + ", telefones=" + this.telefones + "}";
    }
}
