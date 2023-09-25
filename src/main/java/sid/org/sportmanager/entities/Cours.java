package sid.org.sportmanager.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class Cours {
    private Integer id;

    private LocalTime heureDebut;

    private LocalTime heureFin;

    private DayOfWeek jourSemaine;

    private List<Membre> membresInscrits;

    private SalleSport salleSport;

    private Employe employe;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public DayOfWeek getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(DayOfWeek jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public List<Membre> getMembresInscrits() {
        return membresInscrits;
    }

    public void setMembresInscrits(List<Membre> membresInscrits) {
        this.membresInscrits = membresInscrits;
    }

    public SalleSport getSalleSport() {
        return salleSport;
    }

    public void setSalleSport(SalleSport salleSport) {
        this.salleSport = salleSport;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Cours() {
    }

    public Cours(Integer id, LocalTime heureDebut, LocalTime heureFin, DayOfWeek jourSemaine, List<Membre> membresInscrits, SalleSport salleSport, Employe employe) {
        this.id = id;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jourSemaine = jourSemaine;
        this.membresInscrits = membresInscrits;
        this.salleSport = salleSport;
        this.employe = employe;
    }
}
