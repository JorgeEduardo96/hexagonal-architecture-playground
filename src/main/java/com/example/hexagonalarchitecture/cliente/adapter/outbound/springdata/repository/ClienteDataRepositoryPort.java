package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.repository;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.crud.ClienteCrudRepository;
import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.EnderecoEntity;
import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ClienteRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClienteDataRepositoryPort implements ClienteRepositoryPort {


    private final ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<ClienteModel> findAll() {
        return clienteCrudRepository.findAll().stream().map(this::entityToModel).toList();
    }

    @Override
    public ClienteModel findById(UUID id) {
        return clienteCrudRepository.findById(id).map(this::entityToModel).orElse(null);
    }

    @Override
    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        log.info("Cliente save : {}", clienteModel);
        ClienteEntity clienteEntity = modelToEntity(clienteModel);
        clienteEntity = clienteCrudRepository.save(clienteEntity);
        return entityToModel(clienteEntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        log.info("Cliente delete : {}", id);
        clienteCrudRepository.deleteById(id);
    }

    private ClienteEntity modelToEntity(ClienteModel clienteModel) {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(clienteModel.id())
                .nome(clienteModel.nome())
                .cpf(clienteModel.cpf())
                .email(clienteModel.email())
                .telefone(clienteModel.telefone())
                .build();
        clienteEntity.setEndereco(modelToEntity(clienteModel.endereco(), clienteEntity));
        return clienteEntity;
    }

    private ClienteModel entityToModel(ClienteEntity clienteEntity) {
        return ClienteModel.builder()
                .id(clienteEntity.getId())
                .nome(clienteEntity.getNome())
                .cpf(clienteEntity.getCpf())
                .email(clienteEntity.getEmail())
                .telefone(clienteEntity.getTelefone())
                .endereco(entityToModel(clienteEntity.getEndereco()))
                .build();
    }

    private EnderecoEntity modelToEntity(EnderecoModel enderecoModel, ClienteEntity clienteEntity) {
        return EnderecoEntity.builder()
                .cep(enderecoModel.cep())
                .logradouro(enderecoModel.logradouro())
                .uf(enderecoModel.uf())
                .localidade(enderecoModel.localidade())
                .bairro(enderecoModel.bairro())
                .cliente(clienteEntity)
                .build();
    }

    private EnderecoModel entityToModel(EnderecoEntity enderecoEntity) {
        return EnderecoModel.builder()
                .clienteId(enderecoEntity.getClienteId())
                .logradouro(enderecoEntity.getLogradouro())
                .uf(enderecoEntity.getUf())
                .localidade(enderecoEntity.getLocalidade())
                .bairro(enderecoEntity.getBairro())
                .cep(enderecoEntity.getCep())
                .build();
    }
}
