package com.example.hexagonalarchitecture.cliente.adapter.inbound.graphql;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteApiUseCase;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ClienteControllerGraphQL implements ClienteApiUseCase {

    private final ClienteUseCase clienteUseCase;

    @Override
    @QueryMapping
    public List<ClienteModel> buscarClientes() {
        return clienteUseCase.buscarClientes();
    }

    @QueryMapping
    @Override
    public ClienteModel buscarClientePorId(@Argument UUID id) {
        return clienteUseCase.buscarClientePorId(id);
    }

    @MutationMapping
    @Override
    public ClienteModel salvarCliente(@Argument("payload") ClienteInputDto clienteInputDto) {
        return clienteUseCase.salvarCliente(clienteInputDto);
    }

    @MutationMapping
    @Override
    public void excluirCliente(@Argument UUID id) {
        clienteUseCase.excluirCliente(id);
    }


}
