
package gestion_magasin;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pulsar
 */
public class Gestion {
    
    private static int a=0;
    List<String>facture = new ArrayList<>();
    Date date;
    double total;
    List<Integer>qantite = new ArrayList<>();
    List <Produit> Prdui = new ArrayList<>();
    Produit p0 =  new Produit("I-Phone", 350000,20);
    Produit p1 =  new Produit("Pochette", 1500,21);
    Produit p2 =  new Produit("Boulloire", 15000,17);
    Produit p3 =  new Produit("Fouet", 10000,22);
    Produit p4 =  new Produit("Aspirateur", 40000,24);
        
    Rayon r = new Rayon("Telephonie",p0,p1);
    Rayon r1 = new Rayon("Electromenager",p2,p3,p4);
    List <Rayon> ra;
   
    public Gestion(Produit...p){
        this.a = a+1;
        this.date = new Date();
        this.ra = new ArrayList();
        this.Prdui = new ArrayList<>();
        Prdui.add(p0);
        Prdui.add(p1);
        Prdui.add(p2);
        Prdui.add(p3);
        Prdui.add(p4);
        creation();
        
        
    }
    
    Scanner sc = new Scanner(System.in);
    List <Produit> panier = new ArrayList();
    int cpt = 1;
    public void vendre(){
        int p;
        
        Produit prod;
        
        System.out.println("Entrer le nom du produit");
        String nom = sc.next();
        prod = recherche(nom);
        System.out.println("Entrer la quantite");
        int qte = sc.nextInt();
        while (prod.getQt()<qte){
            System.out.println("Le stock est  insuffisant");
            qte = sc.nextInt();
        }
        prod.setQt((prod.getQt()-qte));
        r1.listesdesprod();
        r.listesdesprod();
        total += prod.getPrix()*qte;
        
        qantite.add(qte);
        panier.add(prod);
        
        
        System.out.println("Vouler vous continuer la vente (O/N)");
        String k = sc.next().toUpperCase();
        switch(k){
            case "O": 
                 cpt+= 1;
                vendre();
               
            break;
            case "N":
                //System.out.println("Le montant total de la vente est : "+total);
                facture();
            break;
                
                
        }
  }
   public void creation(){
        System.out.println("Quelle operation souhaitez-vous effectuer ?"
                + "\n1-Effectuer une vente"
                + "\n2-Afficher un rayon"
                + "\n0-Sortir"
                );
        int n = sc.nextInt();
        switch(n){
            case 0 :
                System.exit(0);
                break;
            case 1 :
                r1.listesdesprod();
                r.listesdesprod();
                vendre();
                break;
            case 2 :
                rayon();
                break;
            
        }
    }
    


   public Produit recherche(String nom){
        Produit prod = null;
        for(Produit produit:Prdui){
             if(produit!=null){
                if(nom.equals(produit.getNomProd())){
                    prod = produit;
                    break;
                }
             }
        }
        if(prod!=null) {
            System.out.println("Le rayon :"+prod.getRay().libelle+" Nom : "+prod.getNomProd()+" quantite: "+prod.getQt());
            return prod;
        }
        else{
            System.out.println("Le produit n'a pas ete trouve");
        return prod;
        }
    }
   
   public void facture(){
       double total1 = 0;
       facture.add("            3il Market");
       facture.add("    Facture du " +date);
       for(int i = 0; i < panier.size(); i++){
           facture.add("DESIGNATION     "+ "PRIX UNITAIRE"+"    QUANTITE"+"     PRIX TOTAL");
       facture.add(panier.get(i).getNomProd()+"           "+panier.get(i).getPrix()+"          "+qantite.get(i)+"             "+(qantite.get(i)*panier.get(i).getPrix()));
       total1 += qantite.get(i)*panier.get(i).getPrix();
       }
       if (total1>=50000){
            facture.add("Total sans reduction         "+total1);
            facture.add("Reduction de 5%");
            total1 = total1-(total1*5)/100;
        }
       facture.add("Total                             "+total1);
       //facture.add("Reglement espece                                "+);
       facture.add("                        Merci de votre visite");
       
       creationfact();
   }
   
   public void creationfact(){
       String creer = "";
       
       for (String i : facture){
           if (i != null){
               creer = creer + i + "\n";
           }
       }
       Desktop d = Desktop.getDesktop();
       try{
           FileWriter file = new FileWriter("Facture"+(a)+".txt");
           File f = new File("Facture"+(a)+".txt");
           file.write(creer);
           d.open(f);
           file.close();
       }catch(IOException e){
           e.getStackTrace();
       }
   }
    
    public void rayon (){
        System.out.println("Veuillez choisir un rayon"
                + "\n1- Telephonie"
                + "\n2- Electromenager"
                + "\n0- Quitter"
                );
        int n = sc.nextInt();
        switch(n){
            case 0 :
                System.exit(0);
                break;
            case 1 :
                electromenager();
                break;
            case 2 :
                telephonie();
                break;
            
        }
    }
    
    
    public void electromenager (){
        r1.listesdesprod();
        
    }
    public void telephonie(){
        r.listesdesprod();
        
    }

   
}

