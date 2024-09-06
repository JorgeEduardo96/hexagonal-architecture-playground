package com.example.hexagonalarchitecture.livro.domain.ports.out;

import com.example.hexagonalarchitecture.livro.domain.model.LivroModel;

import java.util.UUID;

public interface LivroRepositoryPort {

    LivroModel findById(UUID id);

    LivroModel findByClienteId(UUID clienteId);

    LivroModel save(LivroModel livroModel);

    void deleteById(UUID id);

}
