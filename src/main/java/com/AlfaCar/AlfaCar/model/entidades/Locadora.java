package com.AlfaCar.AlfaCar.model.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "locadora")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocadora")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    

    // Construtores
    public Locadora() {}

    public Locadora(String nome) {
        this.nome = nome;
    }



    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
