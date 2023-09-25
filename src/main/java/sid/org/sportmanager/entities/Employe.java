package sid.org.sportmanager.entities;

import sid.org.sportmanager.enums.Poste;

public class Employe {
    private Integer id;

    private String nom;

    private String prenom;

    private String telephone;

    private Poste poste;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Employe() {
    }

    public Employe(Integer id, String nom, String prenom, String telephone, Poste poste) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.poste = poste;
    }
}
