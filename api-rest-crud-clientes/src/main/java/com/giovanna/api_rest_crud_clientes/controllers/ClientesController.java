package com.giovanna.api_rest_crud_clientes.controllers;


import com.giovanna.api_rest_crud_clientes.models.Clientes;
import com.giovanna.api_rest_crud_clientes.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

//possui todas as rotas para configurar o CRUD
@RestController     //classe resposável por gerenciar todas as requisições de entrada
@RequestMapping("/clientes")    //mapeia URLs a métodos em um controlador
public class ClientesController {
    @Autowired //realiza injeção de dependências
    ClientesRepository clientesRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

@PostMapping(value = "/createClientes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public Clientes createNewClientes(@ResquestBody Clientes clientes){
        Clientes createClientes = new Clientes();

        createClientes.setName(clientes.getName());
        createClientes.setcpf(clientes.getCpf());
        createClientes.setAddress(clientes.getAddress());

        return clientesRepository.save(createClientes);
}
}
