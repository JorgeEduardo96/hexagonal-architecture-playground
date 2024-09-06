package com.example.hexagonalarchitecture.livro.adapter.outbound.springdata.model;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "livro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private String autor;
    private String isbn;
    private String editora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
}
