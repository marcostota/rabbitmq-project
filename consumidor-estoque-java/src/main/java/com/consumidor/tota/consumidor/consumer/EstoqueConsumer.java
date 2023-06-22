package com.consumidor.tota.consumidor.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import constantes.RabbitMQConstants;
import dto.EstoqueDto;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstants.FILA_ESTOQUE)
    private void consumidor(EstoqueDto estoqueDto) {
        System.out.println(estoqueDto.codigoProduto);
        System.out.println(estoqueDto.quantidade);
        System.out.println("------------------------------------");
    }
}
