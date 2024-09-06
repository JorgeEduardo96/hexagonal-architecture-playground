package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.transform;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.model.dto.ClienteInputDto;

import java.util.stream.Collectors;

public class ClienteTransform {

    public static ClienteModel fromDtoToModel(ClienteInputDto clienteInputDto, EnderecoModel enderecoModel) {
        return ClienteModel.builder()
                .id(null)
                .nome(clienteInputDto.nome())
                .cpf(clienteInputDto.cpf())
                .email(clienteInputDto.email())
                .telefone(clienteInputDto.telefone())
                .endereco(enderecoModel)
                .build();
    }

    public static ClienteEntity fromModelToEntity(ClienteModel clienteModel) {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(clienteModel.id())
                .nome(clienteModel.nome())
                .cpf(clienteModel.cpf())
                .email(clienteModel.email())
                .telefone(clienteModel.telefone())
                .build();
        clienteEntity
                .setEndereco(EnderecoTransform.fromModelToEntity(clienteModel.endereco(), clienteEntity));
        return clienteEntity;
    }

    public static ClienteModel fromEntityToModel(ClienteEntity clienteEntity) {
        return ClienteModel.builder()
                .id(clienteEntity.getId())
                .nome(clienteEntity.getNome())
                .cpf(clienteEntity.getCpf())
                .email(clienteEntity.getEmail())
                .telefone(clienteEntity.getTelefone())
                .endereco(EnderecoTransform.fromEntityToModel(clienteEntity.getEndereco()))
                .livro(clienteEntity.getLivros().stream().map(LivroTransform::fromEntityToModel).collect(Collectors.toSet()))
                .build();
    }

}
