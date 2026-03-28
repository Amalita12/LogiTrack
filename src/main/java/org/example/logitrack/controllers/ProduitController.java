package org.example.logitrack.controllers;

import org.example.logitrack.entities.Produit;
import org.example.logitrack.repositories.ProduitRepo;
import org.example.logitrack.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    @Autowired
    ProduitService produitService;
    @Autowired
    private ProduitRepo produitRepo;

    @GetMapping
    public List<Produit> listeProduits(){
        return produitService.listerTousLesProduits();
    }

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit p){
        return produitService.ajouterProduit(p);
    }

    @GetMapping("/{id}")
    public Produit consulterProduit(@PathVariable Long id){
        return produitService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id){
        produitService.deleteById(id);
    }



    @GetMapping("/category/{category}")
    public List<Produit> getProductsByCategory(@PathVariable String category){
        return produitRepo.findByCategorie(category);
    }

    @GetMapping("/price/{price}")
    public List<Produit> getProduitAPrixInferieur(@PathVariable BigDecimal price){
        return produitRepo.findByPrixLessThan(price);
    }

    @GetMapping("/low-stock")
    public List<Produit> getLowStock(){
        return produitRepo.findLowStockProducts();
    }
}
