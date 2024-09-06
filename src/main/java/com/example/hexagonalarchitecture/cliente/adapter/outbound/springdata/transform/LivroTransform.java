package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.transform;

import com.example.hexagonalarchitecture.cliente.domain.model.LivroModel;
import com.example.hexagonalarchitecture.livro.adapter.outbound.springdata.model.LivroEntity;

public class LivroTransform {

    public static LivroModel from(com.example.hexagonalarchitecture.livro.domain.model.LivroModel livroModel) {
        return LivroModel.builder()
                .id(livroModel.id())
                .autor(livroModel.autor())
                .titulo(livroModel.titulo())
                .isbn(livroModel.isbn())
                .editora(livroModel.editora())
                .build();
    }

    public static LivroModel fromEntityToModel(LivroEntity livroEntity) {
        return LivroModel.builder()
                .id(livroEntity.getId())
                .autor(livroEntity.getAutor())
                .titulo(livroEntity.getTitulo())
                .isbn(livroEntity.getIsbn())
                .editora(livroEntity.getEditora())
                .build();
    }


}
