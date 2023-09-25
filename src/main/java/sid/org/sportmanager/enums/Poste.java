package sid.org.sportmanager.enums;

public enum Poste {
    MANAGER("Manager"),
    COACH("Coach"),
    RECEPTIONNISTE("Réceptionniste"),
    ENTRETIEN("Entretien"),
    AUTRE("Autre");

    private final String libelle;

    Poste(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
