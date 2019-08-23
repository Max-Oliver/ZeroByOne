package com.art.experience.dev.service;

import com.art.experience.dev.data.ClientRepository;
import com.art.experience.dev.data.UserRepository;
import com.art.experience.dev.model.Client;
import com.art.experience.dev.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private static final Logger LOGGER = LogManager.getLogger(ClientService.class);
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @Autowired
    private ClientService(final ClientRepository clientRepository,
                          final UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }


    public Client findByID(final Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
         if (!Objects.nonNull(client)) {
            LOGGER.error("Barber ID Not found. " + clientId);
            throw new ResourceNotFoundException("Barber ID Not found. " + clientId);
        }
        return client;
    }

    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            LOGGER.error("Data Not found in the database");
            throw new ResourceNotFoundException("No data of Clients in the Database.");
        }
        return clients.stream()
                .map(client -> (Client) client)
                .collect(Collectors.toList());
    }

    public Client create(final Client client) {
        Client newClient = new Client();
        try {
            newClient.setName(client.getName());
            newClient.setCel(client.getCel());
            newClient.setEmail(client.getEmail());
            newClient.setStartDate(Instant.now());
            newClient.setPassword(client.getPassword());
            newClient.setUsername(client.getUsername());
            User user = createUser(client);
            newClient.setInteractions(client.getInteractions());
            newClient.setAmountReservas(client.getAmountReservas());
            newClient.setUserId(user.getUserId());
            newClient.setClientType(client.getClientType());
            newClient.setStatus(Boolean.TRUE);
            return clientRepository.save(newClient);
        } catch (Exception e) {
            LOGGER.error("Something failed on the creation of Client. " + e.getMessage());
            throw new IllegalArgumentException("Something failed on the creation of Client. " + e.getMessage());
        }
    }

    public Client update(final Client clie){
        Optional<Client> client = clientRepository.findById(clie.getClientId());
        if(!client.isPresent()){
            LOGGER.error("Client not found with the ID " + clie.getClientId());
            throw new ResourceNotFoundException("Client not found with the ID " + clie.getClientId());
        }
        client.get().setUserId(clie.getUserId());
        client.get().setUsername(clie.getUsername());
        client.get().setPassword(clie.getPassword());
        client.get().setName(clie.getName());
        client.get().setCel(client.get().getCel());
        client.get().setEmail(client.get().getEmail());
        if(Objects.nonNull(clie.getEndDate())){
            client.get().setEndDate(Instant.now());
        }
        User user = updateUser(client.get());
        client.get().setAmountReservas(clie.getAmountReservas());
        client.get().setUserId(user.getUserId());
        client.get().setClientType(clie.getClientType());
        if(Objects.nonNull(clie.getStatus())){
            client.get().setStatus(clie.getStatus());
        }
        return clientRepository.save(client.get());
    }

    public void delete(final Long clientID){
        Optional<Client> client = clientRepository.findById(clientID);
        if (!client.isPresent()){
            LOGGER.error("Client not Found by this ID" + clientID);
            throw new ResourceNotFoundException("Client not Found by this ID" + clientID);
        }else{
            clientRepository.delete(client.get());
        }
    }

    private User updateUser(final Client updateClient) {
        User user = userRepository.findById(updateClient.getUserId()).orElse(null);
        if(Objects.isNull(user)){
            LOGGER.error("User not Found");
            throw new ResourceNotFoundException("User not Found with this ID " + updateClient.getUserId());
        }
        user.setUsername(updateClient.getUsername());
        user.setPassword(updateClient.getPassword());
        user.setEmail(updateClient.getEmail());
        user.setCel(updateClient.getCel());
        user.setFullName(updateClient.getName());
        user.setCreateOn(updateClient.getStartDate());
        if(Objects.nonNull(updateClient.getEndDate())){
            user.setDeleteOn(Instant.now());
        }
        return userRepository.save(user);
    }

    private User createUser(final Client client) {
        User user = new User();
        try {
            user.setUsername(client.getUsername());
            user.setPassword(client.getPassword());
            user.setBarberId(client.getClientId());
            user.setStatus(true);
            user.setFullName(client.getName());
            user.setCel(client.getCel());
            user.setCreateOn(Instant.now());
            user.setClientId(null);
            user.setEmail(client.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error("Error creating the user. " + e.getMessage());
            throw new IllegalArgumentException("Error creating the user. " + e.getMessage());
        }
    }
}
