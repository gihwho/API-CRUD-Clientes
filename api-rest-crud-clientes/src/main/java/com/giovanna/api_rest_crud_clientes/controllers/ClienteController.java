package com.giovanna.api_rest_crud_clientes.controllers;

import com.giovanna.api_rest_crud_clientes.models.Cliente;
import com.giovanna.api_rest_crud_clientes.repositories.ClienteRepository;
import com.giovanna.api_rest_crud_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//possui todas as rotas para configurar o CRUD
@RestController     //classe responsável por gerenciar todas as requisições de entrada
@RequestMapping("/clientes")    //mapeia URLs a métodos em um controlador
public class ClienteController {
    @Autowired //realiza injeção de dependências
    ClienteRepository clientesRepository;

    @Autowired
    ClienteService clientesService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> clienteID(@PathVariable Long id){
        Optional<Cliente> clientes = clientesService.clienteID(id);
        return clientes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createNewCliente(@RequestBody Cliente cliente){  //lógica para salvar o objeto no bd
        return clientesService.createNewCliente(cliente);               //salva ou atualiza uma entidade Clientes no bd
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente updatedCliente(@RequestBody Cliente cliente){
        return clientesService.updatedCliente(cliente);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente deleteCliente(@PathVariable Long id){
        return clientesService.deleteCliente(id);
    }
}
