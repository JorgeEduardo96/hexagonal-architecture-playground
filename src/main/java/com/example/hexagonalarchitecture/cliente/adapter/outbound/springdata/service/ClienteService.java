package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.service;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ClienteRepositoryPort;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ViaCepRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;
    private final ViaCepRepositoryPort viaCepRepositoryPort;

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
        EnderecoModel enderecoModel = viaCepRepositoryPort.getEndereco(clienteInputDto.cep());
        return clienteRepositoryPort.save(convertInputDtoToModel(clienteInputDto, enderecoModel));
    }

    private ClienteModel convertInputDtoToModel(ClienteInputDto clienteInputDto, EnderecoModel enderecoModel) {
        return ClienteModel.builder()
                .id(null)
                .nome(clienteInputDto.nome())
                .cpf(clienteInputDto.cpf())
                .email(clienteInputDto.email())
                .telefone(clienteInputDto.telefone())
                .endereco(enderecoModel)
                .build();
    }

    @Override
    public void excluirCliente(UUID id) {
        clienteRepositoryPort.deleteById(id);
    }
}
