package com.giovanna.api_rest_crud_clientes.repositories;

import com.giovanna.api_rest_crud_clientes.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
//métodos que vão facilitar o CRUD no bd
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
