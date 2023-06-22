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
import dto.PrecoDto;

@RestController
@RequestMapping(value = "preco")
public class PrecoController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PostMapping
    private ResponseEntity alterarPreco(@RequestBody PrecoDto precoDto) {
        rabbitmqService.enviaMenssagem(RabbitMQConstants.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);

    }

}
