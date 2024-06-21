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
public class ClienteModel {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoModel endereco;
}
