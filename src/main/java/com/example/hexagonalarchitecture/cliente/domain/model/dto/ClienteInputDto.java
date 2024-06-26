package com.example.hexagonalarchitecture.cliente.domain.model.dto;


import static com.example.hexagonalarchitecture.cliente.domain.util.EmailUtil.validateEmail;

public record ClienteInputDto(String nome, String cpf, String email, String telefone, String cep) {

    public ClienteInputDto(String nome, String cpf, String email, String telefone, String cep) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException("O campo nome deve ser preenchido.");
        if (!cpf.isBlank()) {
            this.cpf = cpf;
        } else throw new IllegalArgumentException("O campo cpf deve ser preenchido.");
        if (!email.isBlank() && validateEmail(email)) {
            this.email = email;
        } else throw new IllegalArgumentException("O campo email deve ser preenchido.");
        if (!telefone.isBlank()) {
            this.telefone = telefone;
        } else throw new IllegalArgumentException("O campo telefone deve ser preenchido.");
        if (!cep.isBlank()) {
            this.cep = cep;
        } else throw new IllegalArgumentException("O campo cep deve ser preenchido.");
    }
}
