package com.art.experience.dev.web;

import com.art.experience.dev.model.Client;
import com.art.experience.dev.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/id/{id_client}")
    @ResponseStatus(HttpStatus.OK)
    public Client getById(@PathVariable("id_client") final Long idClient) {
        return clientService.findByID(idClient);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody final Client client) {
        return clientService.create(client);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody final Client client) {
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByIdUser(@PathVariable("id_user") final Long user) {
        clientService.delete(user);
    }

}
