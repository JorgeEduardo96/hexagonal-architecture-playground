package com.example.hexagonalarchitecture.cliente.domain.ports.out;

import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;

public interface ViaCepRepository {

    EnderecoModel getEndereco(String cep);

}
