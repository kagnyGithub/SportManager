package sid.org.sportmanager.entities;

import java.util.Date;

public class Equipement {

    private Integer id;

    private String nom;

    private int quantite;

    private Date dateAchat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Equipement() {
    }

    public Equipement(Integer id, String nom, int quantite, Date dateAchat) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.dateAchat = dateAchat;
    }
}
