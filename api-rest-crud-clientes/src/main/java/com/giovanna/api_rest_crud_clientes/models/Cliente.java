package com.giovanna.api_rest_crud_clientes.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;    //java pode converter a classe em objeto

@Getter
@Setter
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(of = "id")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //valor será incrementado automaticamente
    private Long id;

    @Column(nullable = false)   //não pode ter valor nulo
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String address;

    public Cliente() {}
}
