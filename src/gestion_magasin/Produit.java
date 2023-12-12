
package gestion_magasin;

/**
 *
 * @author Pulsar
 */
public class Produit {
    private String nomProd;
    private double prix;
    private int qt;
    Rayon ray;
    
    public Produit(){
        this.nomProd = null;
        this.prix = 0.0;
        this.qt = 0;
    }
    public Produit(String nom,double px,int qt){
        this.nomProd = nom;
        this.prix = px;
        this.qt = qt;
        
    }
    
    public String getNomProd() {
        return nomProd;
    }


    public double getPrix() {
        return prix;
    }
    public int getQt(){
        return qt;
    }
   
    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
    public void setRay(Rayon ray){
        this.ray = ray;
    }
    public Rayon getRay(){
        return ray;
    }
    
    @Override
    public String toString() {
        return "Produit : " + "nomProd = " + nomProd + ", prix = " + prix + ", qt = " + qt;
    }
   
   
}
