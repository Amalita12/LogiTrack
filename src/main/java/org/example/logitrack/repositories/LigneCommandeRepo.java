package org.example.logitrack.repositories;

import org.example.logitrack.entities.LigneCommande;
import org.example.logitrack.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepo extends JpaRepository <LigneCommande,Long> {


}
