package sid.org.sportmanager.entities;

public class Questionnaire {
    private Integer id;

    private String description;

    private String reponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Questionnaire() {
    }

    public Questionnaire(Integer id, String description, String reponse) {
        this.id = id;
        this.description = description;
        this.reponse = reponse;
    }
}
