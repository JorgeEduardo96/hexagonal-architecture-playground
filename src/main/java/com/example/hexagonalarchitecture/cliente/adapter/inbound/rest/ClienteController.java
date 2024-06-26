package com.example.hexagonalarchitecture.cliente.adapter.inbound.rest;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteApiUseCase;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteController implements ClienteApiUseCase {

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
    public ClienteModel salvarCliente(@RequestBody ClienteInputDto clienteInputDto) {
        return clienteUseCase.salvarCliente(clienteInputDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable UUID id) {
        clienteUseCase.excluirCliente(id);
    }
}
