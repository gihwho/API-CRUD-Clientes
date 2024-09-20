package com.giovanna.api_rest_crud_clientes.service;

import com.giovanna.api_rest_crud_clientes.models.Clientes;
import com.giovanna.api_rest_crud_clientes.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    ClientesRepository clientesRepository;

    public Optional<Clientes> clientesID(Long id){
        return clientesRepository.findById(id);
    }
}
