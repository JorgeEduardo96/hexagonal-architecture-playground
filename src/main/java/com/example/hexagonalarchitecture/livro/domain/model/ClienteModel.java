package com.example.hexagonalarchitecture.livro.domain.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClienteModel(UUID id, String nome) {
}
