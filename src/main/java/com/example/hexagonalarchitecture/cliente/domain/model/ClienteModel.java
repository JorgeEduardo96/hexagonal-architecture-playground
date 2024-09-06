package com.example.hexagonalarchitecture.cliente.domain.model;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record ClienteModel(UUID id, String nome, String cpf, String email, String telefone, EnderecoModel endereco,
                           Set<LivroModel> livro) {
}
