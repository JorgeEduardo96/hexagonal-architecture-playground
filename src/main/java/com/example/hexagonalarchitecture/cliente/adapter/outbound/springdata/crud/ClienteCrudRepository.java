package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.crud;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteCrudRepository extends JpaRepository<ClienteEntity, UUID> {
}
