package org.example.logitrack.services;


import org.example.logitrack.entities.*;
import org.example.logitrack.repositories.CommandeRepo;
import org.example.logitrack.repositories.LigneCommandeRepo;
import org.example.logitrack.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    CommandeRepo commandeRepo;

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    LigneCommandeRepo ligneCommandeRepo;

    public List<Commande> listerToutesLesCommandes(){
        return commandeRepo.findAll();
    }

    public Commande save(Commande commande){
        return commandeRepo.save(commande);
    }
    public Commande findById(Long id){
        return commandeRepo.findById(id).orElseThrow(() -> new RuntimeException("Commande avec l'id "+id+" non trouvée"));
    }


    public Commande creerCommande(Client client){
        Commande c = new Commande();
        c.setClient(client);
        c.setDateCommande(LocalDate.now());
        c.setStatut(StatutCommande.EN_ATTENTE);
        return commandeRepo.save(c);
    }


    public LigneCommande ajouterProduitACommande(Long idCommande, Long idProduit, Integer quantite){

        Produit p = produitRepo.findById(idProduit).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        Commande c = commandeRepo.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        if (p!=null && c!= null && p.getQuantiteStock()>=quantite){
            p.setQuantiteStock(p.getQuantiteStock()-quantite);
            produitRepo.save(p);
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setProduit(p);
            ligneCommande.setCommande(c);
            ligneCommande.setQuantite(quantite);
            return ligneCommandeRepo.save(ligneCommande);
        }else {
            throw new RuntimeException("stock insuffisant!");
        }
    }

    public Commande modifierStatut(Long idCommande, StatutCommande nvStatut){
        Commande c = commandeRepo.findById(idCommande).orElse(null);
        if (c!= null){
            c.setStatut(nvStatut);
            return commandeRepo.save(c);
        }
        return null;
    }
}
