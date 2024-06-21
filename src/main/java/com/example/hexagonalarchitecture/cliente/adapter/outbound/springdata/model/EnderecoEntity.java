package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "endereco")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    @Id
    @Column(name = "cliente_id")
    private UUID clienteId;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
}
