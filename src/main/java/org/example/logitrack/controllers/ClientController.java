package org.example.logitrack.controllers;

import org.example.logitrack.entities.Client;
import org.example.logitrack.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List <Client> listeClients(){
        return clientService.listerTousLesClients();
    }

    @PostMapping
    public Client ajouterClient(@RequestBody Client client){
    return clientService.ajouterClient(client);
    }

    @GetMapping("/{id}")
    public Client ConsulterClient(@PathVariable Long id){
    return clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id){
    clientService.deleteById(id);
    }
}
