package com.giovanna.api_rest_crud_clientes.service;

import com.giovanna.api_rest_crud_clientes.models.Cliente;
import com.giovanna.api_rest_crud_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clientesRepository;

    public Optional<Cliente> clienteID(Long id){
        return clientesRepository.findById(id);
    }
}
