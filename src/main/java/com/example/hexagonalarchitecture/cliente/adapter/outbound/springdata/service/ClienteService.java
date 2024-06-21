package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.service;

import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;
import com.example.hexagonalarchitecture.cliente.domain.ports.in.ClienteUseCase;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ClienteRepository;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ViaCepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final ViaCepRepository viaCepRepository;

    @Override
    public List<ClienteModel> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteModel buscarClientePorId(UUID id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteModel salvarCliente(ClienteInputDto clienteInputDto) {
        EnderecoModel enderecoModel = viaCepRepository.getEndereco(clienteInputDto.getCep());
        return clienteRepository.save(convertInputDtoToModel(clienteInputDto, enderecoModel));
    }

    private ClienteModel convertInputDtoToModel(ClienteInputDto clienteInputDto, EnderecoModel enderecoModel) {
        return ClienteModel.builder()
                .id(null)
                .nome(clienteInputDto.getNome())
                .cpf(clienteInputDto.getCpf())
                .email(clienteInputDto.getEmail())
                .telefone(clienteInputDto.getTelefone())
                .endereco(enderecoModel)
                .build();
    }

    @Override
    public void excluirCliente(UUID id) {
        clienteRepository.deleteById(id);
    }
}
