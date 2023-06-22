package com.tota.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tota.estoquepreco.service.RabbitmqService;

import constantes.RabbitMQConstants;
import dto.EstoqueDto;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PostMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto) {
        System.out.println(estoqueDto.codigoProduto);
        this.rabbitmqService.enviaMenssagem(RabbitMQConstants.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity(HttpStatus.OK);

    }
}
