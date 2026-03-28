package org.example.logitrack.services;

import org.example.logitrack.entities.Client;
import org.example.logitrack.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;


    public List<Client> listerTousLesClients(){
        return clientRepo.findAll();
    }

    public Client ajouterClient(Client client){
        return clientRepo.save(client);
    }

    public Client findById(Long id){
        return clientRepo.findById(id).orElseThrow(()-> new RuntimeException("le client avec l'id "+id+" n'existe pas"));
    }

    public void deleteById(Long id){
        clientRepo.deleteById(id);

    }
}
