package org.example.logitrack.repositories;

import org.example.logitrack.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepo extends JpaRepository<Commande,Long>  {
    List<Commande> findByClientId(Long clientId);


    @Query("select count(c) from Commande c")
    long NombreTotalCommandes();
}
