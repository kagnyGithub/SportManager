package sid.org.sportmanager.entities;

import java.util.Date;
import java.util.List;

public class Consultation {
    private Integer id;

    private Date dateConsultation;

    private String notes;

    private String recommandations;

    private Employe employe;

    private Membre membre;

    private List<Questionnaire> questionnaires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(String recommandations) {
        this.recommandations = recommandations;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public Consultation() {
    }

    public Consultation(Integer id, Date dateConsultation, String notes, String recommandations, Employe employe, Membre membre, List<Questionnaire> questionnaires) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.notes = notes;
        this.recommandations = recommandations;
        this.employe = employe;
        this.membre = membre;
        this.questionnaires = questionnaires;
    }
}
