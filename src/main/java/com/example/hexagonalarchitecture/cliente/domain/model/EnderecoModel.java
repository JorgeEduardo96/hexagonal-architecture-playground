package com.example.hexagonalarchitecture.cliente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoModel {

    private UUID clienteId;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;

}
