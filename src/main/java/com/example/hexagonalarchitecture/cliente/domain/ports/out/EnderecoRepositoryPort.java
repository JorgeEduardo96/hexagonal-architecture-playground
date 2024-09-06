package com.example.hexagonalarchitecture.cliente.domain.ports.out;

import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;

public interface EnderecoRepositoryPort {

    EnderecoModel getEndereco(String cep);

}
