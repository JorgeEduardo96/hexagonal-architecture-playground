package com.example.hexagonalarchitecture.livro.domain.ports.in;

import com.example.hexagonalarchitecture.livro.domain.model.LivroModel;

import java.util.List;
import java.util.UUID;

public interface LivroApiUseCase {

    List<LivroModel> buscarLivrosPorCliente(UUID clienteId);

}
