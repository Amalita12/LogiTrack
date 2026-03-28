package org.example.logitrack.repositories;

import org.example.logitrack.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProduitRepo extends JpaRepository<Produit,Long>  {

    List<Produit> findByCategorie(String Categorie);
   List<Produit> findByPrixLessThan(BigDecimal prix);

   @Query("select p from Produit p where p.quantiteStock < 10")
    List<Produit> findLowStockProducts();


}
