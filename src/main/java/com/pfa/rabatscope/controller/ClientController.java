package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Client;
import com.pfa.rabatscope.model.Ticket;
import com.pfa.rabatscope.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client")
@CrossOrigin
public class ClientController {
    private final ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @GetMapping
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    @GetMapping("/{idClient}")
    public Optional<Client> getClientbyId(@PathVariable("idClient") Long id) {
        return clientRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveClients(@RequestBody Client clientData) {
        clientRepository.save(clientData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idClient}")
    public void deleteTicket(@PathVariable("idClient") Long id){
        clientRepository.deleteById(id);

    }


}
