package test;

import java.util.List;

import DAO.ServiceProduit;
import entities.Produit;

public class TestProduit {

    public static void main(String[] args) {

        ServiceProduit service = new ServiceProduit();

      
        // test ajout
      
        Produit p = new Produit(
            "Imprimante HP",
            600.0,
            5
        );

        service.addProduct(p);


       //test affichage

        System.out.println("\n--- Liste des produits ---");

        List<Produit> produits = service.getAllProducts();

        for (Produit produit : produits) {
            System.out.println(produit);
        }


        // test recherche b id

        System.out.println("\n--- Recherche produit ID 1 ---");

        Produit produit = service.getProduct(1);

        System.out.println(produit);


        //test recherche b mot cle  

        System.out.println("\n--- Recherche contenant 'Souris' ---");

        List<Produit> recherche =
                service.getProductsByMC("Souris");

        for (Produit p2 : recherche) {
            System.out.println(p2);
        }


        // test modification

        System.out.println("\n--- Modification du produit ID 1 ---");

        Produit modification = new Produit(
            "Ordinateur HP Pro",
            2800.0,
            20
        );

        service.updateProduct(1, modification);


       // test affichage

        System.out.println("\n--- Produit ID 1 après modification ---");

        System.out.println(service.getProduct(1));


        

    }
}