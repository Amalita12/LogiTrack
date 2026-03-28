package org.example.logitrack.services;


import org.example.logitrack.entities.Produit;
import org.example.logitrack.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProduitRepo produitRepo;

    public List<Produit> listerTousLesProduits(){
        return produitRepo.findAll();
    }

    public Produit ajouterProduit(Produit produit){
        return produitRepo.save(produit);
    }

    public Produit findById(Long id){
        return produitRepo.findById(id).orElseThrow(() -> new RuntimeException("Produit avec l'id "+id+" non trouvé"));
    }

    public void deleteById(Long id){
        produitRepo.deleteById(id);

    }

}

