package org.example.logitrack.controllers;

import org.example.logitrack.entities.Client;
import org.example.logitrack.entities.Commande;
import org.example.logitrack.entities.LigneCommande;
import org.example.logitrack.entities.StatutCommande;
import org.example.logitrack.repositories.CommandeRepo;
import org.example.logitrack.services.ClientService;
import org.example.logitrack.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class CommandeController {

    @Autowired
    CommandeService commandeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CommandeRepo commandeRepo;


    @PostMapping
    public Commande  creerCommande(@RequestParam Long idClient){
        Client client = clientService.findById(idClient);
        return commandeService.creerCommande(client);
    }

    @GetMapping
    public List<Commande> listeCommandes(){
        return commandeService.listerToutesLesCommandes();
    }

    @GetMapping("/{id}")
    public Commande consulterCommande(@PathVariable Long id){
        return commandeService.findById(id);
    }

    @PostMapping("/{orderId}/products")
    public LigneCommande ajouterProduitACommande(@PathVariable Long orderId, @RequestParam Long productId, @RequestParam Integer quantite){
        return commandeService.ajouterProduitACommande(orderId,productId,quantite);
    }

    @PutMapping("/{id}/status")
    public Commande modifierStatut(@PathVariable Long id, @RequestParam StatutCommande newStatus){
        return commandeService.modifierStatut(id, newStatus);
    }


    @GetMapping("/client/{clientId}")
    public List<Commande> getCommandesByClient(@PathVariable Long clientId){
        return commandeRepo.findByClientId(clientId);
    }


    @GetMapping("/count")
    public long getNombreTotalDesCommandes(){
        return commandeRepo.NombreTotalCommandes();
    }
}
