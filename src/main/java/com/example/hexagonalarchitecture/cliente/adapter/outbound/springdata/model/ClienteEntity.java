package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EnderecoEntity endereco;

}
