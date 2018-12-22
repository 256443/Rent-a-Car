package com.antoszek.controller;

import com.antoszek.model.Client;
import com.antoszek.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/app")
public class ClientController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }
    @RequestMapping("/all_customers")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getUsers() {
        List<Client> clients = clientService.findAll();

        log.info("Retrieve objects {}", clients);

        return clients;
    }
    @RequestMapping("/register")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Client save(@RequestBody Client client) {
        Client savedCustomer = clientService.save(client);
        log.info("Add user {}", savedCustomer);
        return savedCustomer;
    }

}


