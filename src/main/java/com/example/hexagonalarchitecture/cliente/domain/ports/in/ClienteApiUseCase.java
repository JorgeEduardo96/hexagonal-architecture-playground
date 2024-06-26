package com.example.hexagonalarchitecture.cliente.domain.ports.in;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;

import java.util.List;
import java.util.UUID;

public interface ClienteApiUseCase {

    List<ClienteModel> buscarClientes();

    ClienteModel buscarClientePorId(UUID id);

    ClienteModel salvarCliente(ClienteInputDto clienteInputDto);

    void excluirCliente(UUID id);

}
