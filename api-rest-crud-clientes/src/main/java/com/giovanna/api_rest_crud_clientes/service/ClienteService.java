package com.giovanna.api_rest_crud_clientes.service;

import com.giovanna.api_rest_crud_clientes.models.Cliente;
import com.giovanna.api_rest_crud_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clientesRepository;

    public Optional<Cliente> clienteID(Long id){
        return clientesRepository.findById(id);
    }

    public Cliente createNewCliente(@RequestBody Cliente cliente){  //lógica para salvar o objeto no bd
        Cliente createCliente = new Cliente();   //cria uma nova instância da classe Clientes na variável createClientes

        //métodos setters/getters para atribuir valores
        createCliente.setName(cliente.getName());
        createCliente.setCpf(cliente.getCpf());
        createCliente.setAddress(cliente.getAddress());

        return clientesRepository.save(createCliente);     //salva ou atualiza uma entidade Clientes no bd
    }

    public Cliente updatedCliente(@RequestBody Cliente cliente){
        Cliente getCliente = clientesRepository.findById(cliente.getId()).orElseThrow();     //verifica se o cliente existe

        Cliente updatedCliente = new Cliente();

        updatedCliente.setId(cliente.getId());
        updatedCliente.setName(cliente.getName());
        updatedCliente.setCpf(cliente.getCpf());
        updatedCliente.setAddress(cliente.getAddress());

        return clientesRepository.save(updatedCliente);
    }

    public Cliente deleteCliente(@PathVariable Long id){
        Cliente getCliente = clientesRepository.findById(id).orElseThrow();
        clientesRepository.delete(getCliente);
        return getCliente;
    }
}
