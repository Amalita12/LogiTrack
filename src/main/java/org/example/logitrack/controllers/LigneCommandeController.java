package org.example.logitrack.controllers;

import org.example.logitrack.entities.LigneCommande;
import org.example.logitrack.services.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lignes")
public class LigneCommandeController {
    @Autowired
    LigneCommandeService ligneCommandeService;

    @GetMapping
    public List<LigneCommande> getListe(){
       return ligneCommandeService.listeLignesCommande();
    }
}
