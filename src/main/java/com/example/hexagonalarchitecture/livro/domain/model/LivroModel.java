package com.example.hexagonalarchitecture.livro.domain.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record LivroModel(UUID id, String titulo, String autor, String isbn, String editora) {
}
