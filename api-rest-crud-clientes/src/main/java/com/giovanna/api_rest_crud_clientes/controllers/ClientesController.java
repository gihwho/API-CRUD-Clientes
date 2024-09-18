package com.giovanna.api_rest_crud_clientes.controllers;


import com.giovanna.api_rest_crud_clientes.models.Clientes;
import com.giovanna.api_rest_crud_clientes.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//possui todas as rotas para configurar o CRUD
@RestController     //classe responsável por gerenciar todas as requisições de entrada
@RequestMapping("/clientes")    //mapeia URLs a métodos em um controlador
public class ClientesController {
    @Autowired //realiza injeção de dependências
    ClientesRepository clientesRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

@PostMapping(value = "/createClientes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public Clientes createNewClientes(@RequestBody Clientes clientes){
        Clientes createClientes = new Clientes();   //cria uma nova instância da classe Clientes na variável createClientes

        createClientes.setName(clientes.getName());     //métodos setters para atribuir valores
        createClientes.setCpf(clientes.getCpf());
        createClientes.setAddress(clientes.getAddress());

        return clientesRepository.save(createClientes);
}
}
