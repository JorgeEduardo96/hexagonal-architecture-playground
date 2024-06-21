package com.example.hexagonalarchitecture.cliente.adapter.outbound.viacep;

import com.example.hexagonalarchitecture.cliente.domain.model.EnderecoModel;
import com.example.hexagonalarchitecture.cliente.domain.ports.out.ViaCepRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class ViaCepService implements ViaCepRepository {


    @Override
    public EnderecoModel getEndereco(String cep) {
        log.info("Endereço do CEP: {}", cep);
        WebClient webClient = WebClient.create();
        String uri = "https://viacep.com.br/ws/" + cep + "/json";
        EnderecoModel response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(EnderecoModel.class)
                .block();
        log.info("Response: {}", response);
        return response;
    }
}
