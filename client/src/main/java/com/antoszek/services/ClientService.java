package com.antoszek.services;

import com.antoszek.model.Client;
import com.antoszek.repository.ClientRepository;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }
    public Client save(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
    public List<Client> findAll() {
        Iterable<Client> clientsIterable = clientRepository.findAll();
        List<Client> clients = Lists.newArrayList(clientsIterable);

        return clients;
    }
//
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        }
        return null;
    }
//
//    public Customer update(Customer user) {
//        Customer updatedUser = customerRepository.save(user);
//
////        runEvent(UPDATE, updatedUser.getId(), "Successfull User Update");
//
//        return updatedUser;
//    }
//
//    public void deleteCustomer(Long id) {
//        customerRepository.deleteById(id);
//
////        runEvent(DELETE, id, "Successfullll User Delete");
//    }
}
