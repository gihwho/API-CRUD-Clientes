package com.giovanna.api_rest_crud_clientes.repositories;

import com.giovanna.api_rest_crud_clientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//métodos que vão facilitar o CRUD no bd
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
