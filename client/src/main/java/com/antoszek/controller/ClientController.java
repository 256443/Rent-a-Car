package com.antoszek.controller;

import com.antoszek.model.Client;
import com.antoszek.modelDTO.ClientDTO;
import com.antoszek.services.ClientService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/app/client")
public class ClientController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

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
    @RequestMapping("/edit/{id}")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Client update(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Client clientUpdate = clientService.findById(id);
        modelMapper.map(clientDTO,clientUpdate);
        clientService.save(clientUpdate);
        log.info("Update date of client Client[]","ID Client: " ,clientUpdate.getId());
        return clientUpdate;
    }
    @DeleteMapping("/delete_Client/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return "Pomyślnie wyrejestrowano z systemu użytkownika.. ";
    }
    @RequestMapping("/find_clientById/{id}")
    @GetMapping(value = APPLICATION_JSON_VALUE)
    public Client findById(@PathVariable Long id){
        return clientService.findById(id);
    }

}


