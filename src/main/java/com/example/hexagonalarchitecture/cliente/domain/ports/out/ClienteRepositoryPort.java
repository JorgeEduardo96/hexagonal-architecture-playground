package com.example.hexagonalarchitecture.cliente.domain.ports.out;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteRepositoryPort {

    List<ClienteModel> findAll();

    ClienteModel findById(UUID id);

    ClienteModel save(ClienteModel clienteModel);

    void deleteById(UUID id);

}
