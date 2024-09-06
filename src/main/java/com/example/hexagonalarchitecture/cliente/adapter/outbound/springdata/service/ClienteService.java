package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.service;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ClienteRepositoryPort;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.EnderecoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.transform.ClienteTransform.fromDtoToModel;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;
    private final EnderecoRepositoryPort enderecoRepositoryPort;

    @Override
    public List<ClienteModel> buscarClientes() {
        return clienteRepositoryPort.findAll();
    }

    @Override
    public ClienteModel buscarClientePorId(UUID id) {
        return clienteRepositoryPort.findById(id);
    }

    @Override
    public ClienteModel salvarCliente(ClienteInputDto clienteInputDto) {
        EnderecoModel enderecoModel = enderecoRepositoryPort.getEndereco(clienteInputDto.cep());
        return clienteRepositoryPort.save(fromDtoToModel(clienteInputDto, enderecoModel));
    }

    @Override
    public void excluirCliente(UUID id) {
        clienteRepositoryPort.deleteById(id);
    }
}
