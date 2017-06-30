package modele.impl;

import modele.impl.Formation;
import modele.intf.ICreneau;
import modele.intf.IFormateur;
import modele.intf.IFormation;
import modele.intf.IStagiaire;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class Creneau implements ICreneau{

    private int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private boolean interne;
    private IFormation formation;
    private List<IStagiaire> listStagiaires;
    private List<IFormateur> listFormateurs;

    public Creneau(int id, LocalDateTime dateDebut, LocalDateTime dateFin, boolean interne, IFormation formation) throws ModelException {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.interne = interne;
        this.formation = formation;
        this.listStagiaires = new ArrayList<>();
        this.listFormateurs = new ArrayList<>();
        
        this.checkDate();
    }

    public Creneau(LocalDateTime dateDebut, LocalDateTime dateFin, boolean interne, IFormation formation) throws ModelException {
    	this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.interne = interne;
        this.formation = formation;
        this.listStagiaires = new ArrayList<>();
        this.listFormateurs = new ArrayList<>();
        
        this.checkDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) throws ModelException {
        this.dateDebut = dateDebut;
    	this.checkDate();
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) throws ModelException {
    	this.dateFin = dateFin;
    	this.checkDate();
    }

    public boolean isInterne() {
        return interne;
    }

    public void setInterne(boolean interne) {
        this.interne = interne;
    }

    public IFormation getFormation() {
        return formation;
    }

    public void setFormation(IFormation formation) {
        this.formation = formation;
    }

    public List<IStagiaire> getListStagiaires() {
        return listStagiaires;
    }

    public void setListStagiaires(List<IStagiaire> listStagiaires) {
        this.listStagiaires = listStagiaires;
    }

    public List<IFormateur> getListFormateurs() {
        return listFormateurs;
    }

    public void setListFormateurs(List<IFormateur> listFormateurs) {
        this.listFormateurs = listFormateurs;
    }

    @Override
    public String toString() {
        return "Creneau{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", formation=" + formation +
                '}';
    }
    
    private void checkDate() throws ModelException{
    	if(this.dateDebut != null && this.dateFin != null){
        	if(!this.dateDebut.plusHours(3).plusMinutes(30).isEqual(this.dateFin)){
        		throw new ModelException("La date de debut ne peut pas supperieure a la date de fin et l'intervalle doit être de 3h30");
        	}
        }
        else{
        	throw new ModelException("Les dates ne peuvent pas être null");
        }
    }
}
