package sid.org.sportmanager.dao;

import sid.org.sportmanager.entities.Membre;
import sid.org.sportmanager.entities.Produit;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Produit produit = new Produit();
        produit.setProduitID("P001");
        produit.setProduitDate(new Date());
        produit.setProduitImage("");
        produit.setProduitName("Eau potable");
        produit.setProduitPrice(100.0F);
        produit.setProduitStatus("disponible");
        produit.setProduitStock(10);
        produit.setProduitType("Alimentation");

        //ProduitDAO.createProduit(produit);

        Membre membre = new Membre();
        membre.setNom("Penda");
        membre.setPrenom("Thiao");
        membre.setAdresse("Fann");
        membre.setDateNaissance(new Date());
        membre.setDateInscription(new Date());
        membre.setStatus(1);
        membre.setTelephone("784579936");

        MembreDAO.createMembre(membre);

      /* Produit produit = ProduitDAO.readProduitById(1);

        List<Produit> tousLesProduits = ProduitDAO.readAllProduits();

        // Affichage des produits dans la console
       // System.out.println("Liste de tous les produits :");
        //for (Produit produit : tousLesProduits) {
            System.out.println("ID : " + produit.getId());
            System.out.println("Produit ID : " + produit.getProduitID());
            System.out.println("Nom du produit : " + produit.getProduitName());
            System.out.println("Type de produit : " + produit.getProduitType());
            System.out.println("Stock du produit : " + produit.getProduitStock());
            System.out.println("Prix du produit : " + produit.getProduitPrice());
            System.out.println("Statut du produit : " + produit.getProduitStatus());
            System.out.println("Date du produit : " + produit.getProduitDate());
            System.out.println("Image du produit : " + produit.getProduitImage());
            System.out.println("---------------------------------------");*/
        //ProduitDAO.deleteProduit(1);


    }
}
