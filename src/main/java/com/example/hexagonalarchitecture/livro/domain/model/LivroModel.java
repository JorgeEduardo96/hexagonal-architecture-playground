package com.example.hexagonalarchitecture.livro.domain.model;

import java.util.UUID;

public record LivroModel(UUID id, String titulo, String autor, String isbn, String editora) {


}
