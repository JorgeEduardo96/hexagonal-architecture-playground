package com.example.hexagonalarchitecture.livro.adapter.outbound.springdata.crud;

import com.example.hexagonalarchitecture.livro.adapter.outbound.springdata.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroCrudRepository extends JpaRepository<LivroEntity, UUID> {
}
