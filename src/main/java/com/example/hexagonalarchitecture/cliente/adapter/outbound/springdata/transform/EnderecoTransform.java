package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.transform;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.EnderecoEntity;
import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;

public class EnderecoTransform {

    public static EnderecoEntity fromModelToEntity(EnderecoModel enderecoModel, ClienteEntity clienteEntity) {
        return EnderecoEntity.builder()
                .cep(enderecoModel.cep())
                .logradouro(enderecoModel.logradouro())
                .uf(enderecoModel.uf())
                .localidade(enderecoModel.localidade())
                .bairro(enderecoModel.bairro())
                .cliente(clienteEntity)
                .build();
    }

    public static EnderecoModel fromEntityToModel(EnderecoEntity enderecoEntity) {
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
