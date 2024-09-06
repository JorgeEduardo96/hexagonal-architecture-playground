package com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.repository;

import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.crud.ClienteCrudRepository;
import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.model.ClienteEntity;
import com.example.hexagonalarchitecture.cliente.adapter.outbound.springdata.transform.ClienteTransform;
import com.example.hexagonalarchitecture.cliente.domain.model.ClienteModel;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ClienteRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClienteDataRepositoryPort implements ClienteRepositoryPort {
    
    private final ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<ClienteModel> findAll() {
        return clienteCrudRepository.findAll().stream().map(ClienteTransform::fromEntityToModel).toList();
    }

    @Override
    public ClienteModel findById(UUID id) {
        return clienteCrudRepository.findById(id).map(ClienteTransform::fromEntityToModel).orElse(null);
    }

    @Override
    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        log.info("Cliente save : {}", clienteModel);
        ClienteEntity clienteEntity = ClienteTransform.fromModelToEntity(clienteModel);
        clienteEntity = clienteCrudRepository.save(clienteEntity);
        return ClienteTransform.fromEntityToModel(clienteEntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        log.info("Cliente delete : {}", id);
        clienteCrudRepository.deleteById(id);
    }

}
