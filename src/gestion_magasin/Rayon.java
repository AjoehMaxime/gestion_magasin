package gestion_magasin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pulsar
 */
public class Rayon {
    String libelle;
    List <Produit>listProd;

    public Rayon() {
        this.libelle = null;
        this.listProd = new ArrayList<>();
    }
    
    
    
    public Rayon(String libelle,Produit...p) {
        this.libelle = libelle;
        this.listProd = new ArrayList<>();
        for(Produit produit:p){
            if(produit!=null){
                listProd.add(produit);
                produit.setRay(this);
            }
        }
    }
    
    public void listesdesprod(){
      for(Produit produit:listProd){
          if(produit!=null){
              System.out.println(produit.toString());
          }
      }
    }
  
    
    public Produit recherche(String nom){
        Produit prod = null;
        for(Produit produit:listProd){
             if(produit!=null){
                if(nom.equals(produit.getNomProd())){
                    prod = produit;
                    break;
                }
             }
        }
        if(prod!=null) {
            System.out.println("rayon"+this.libelle.charAt(0)+"Nom : "+prod.getNomProd()+"quantite "+prod.getQt());
            return prod;
        }
        else{
            System.out.println("le produit n'a pas ete trouve");
        return prod;
        }
    }
    public void suppProd(String nom){
        Produit prod1 = recherche(nom);
        if(prod1 != null){
            listProd.remove(prod1);
        }
    }
    
}
