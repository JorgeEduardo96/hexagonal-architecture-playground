package com.example.hexagonalarchitecture.cliente.domain.ports.in;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteApi {

    List<ClienteModel> buscarClientes();

    ClienteModel buscarClientePorId(UUID id);

    ResponseEntity<ClienteModel> salvarCliente(ClienteInputDto clienteInputDto);

    ResponseEntity<Void> excluirCliente(UUID id);

}
