package sid.org.sportmanager.entities;

import java.util.Date;

public class Produit {
    private Integer id;
    private String produitID;
    private String produitName;
    private String produitType;
    private  Integer produitStock;
    private  Float produitPrice;
    private  String produitStatus;
    private Date produitDate;
    private String produitImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduitID() {
        return produitID;
    }

    public void setProduitID(String produitID) {
        this.produitID = produitID;
    }

    public String getProduitName() {
        return produitName;
    }

    public void setProduitName(String produitName) {
        this.produitName = produitName;
    }

    public String getProduitType() {
        return produitType;
    }

    public void setProduitType(String produitType) {
        this.produitType = produitType;
    }

    public Integer getProduitStock() {
        return produitStock;
    }

    public void setProduitStock(Integer produitStock) {
        this.produitStock = produitStock;
    }

    public Float getProduitPrice() {
        return produitPrice;
    }

    public void setProduitPrice(Float produitPrice) {
        this.produitPrice = produitPrice;
    }

    public String getProduitStatus() {
        return produitStatus;
    }

    public void setProduitStatus(String produitStatus) {
        this.produitStatus = produitStatus;
    }

    public Date getProduitDate() {
        return produitDate;
    }

    public void setProduitDate(Date produitDate) {
        this.produitDate = produitDate;
    }

    public String getProduitImage() {
        return produitImage;
    }

    public void setProduitImage(String produitImage) {
        this.produitImage = produitImage;
    }

    public Produit() {
    }

    public Produit(Integer id, String produitID, String produitName, String produitType, Integer produitStock, Float produitPrice, String produitStatus, Date produitDate, String produitImage) {
        this.id = id;
        this.produitID = produitID;
        this.produitName = produitName;
        this.produitType = produitType;
        this.produitStock = produitStock;
        this.produitPrice = produitPrice;
        this.produitStatus = produitStatus;
        this.produitDate = produitDate;
        this.produitImage = produitImage;
    }
}
