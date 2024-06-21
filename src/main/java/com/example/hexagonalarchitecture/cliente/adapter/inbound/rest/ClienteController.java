package com.example.hexagonalarchitecture.cliente.adapter.inbound.rest;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteApi;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {

    private final ClienteUseCase clienteUseCase;
    
    @Override
    @GetMapping
    public List<ClienteModel> buscarClientes() {
        return clienteUseCase.buscarClientes();
    }

    @Override
    @GetMapping("/{id}")
    public ClienteModel buscarClientePorId(@PathVariable UUID id) {
        return clienteUseCase.buscarClientePorId(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteInputDto clienteInputDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteUseCase.salvarCliente(clienteInputDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable UUID id) {
        clienteUseCase.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
