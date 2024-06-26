package com.example.hexagonalarchitecture.cliente.domain.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record EnderecoModel(UUID clienteId, String logradouro, String bairro, String localidade, String uf,
                            String cep) {


}
