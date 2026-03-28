package org.example.logitrack.services;

import org.example.logitrack.entities.LigneCommande;
import org.example.logitrack.repositories.LigneCommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {

    @Autowired
    LigneCommandeRepo ligneCommandeRepo;


    public LigneCommande save (LigneCommande ligne){
        return ligneCommandeRepo.save(ligne);
    }

    public List<LigneCommande> listeLignesCommande(){
        return ligneCommandeRepo.findAll();
    }



}
