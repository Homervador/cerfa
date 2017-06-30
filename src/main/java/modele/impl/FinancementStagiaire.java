package modele.impl;

import modele.intf.IFinancement;
import modele.intf.IFinancementStagiaire;
import modele.intf.IStagiaire;

import java.time.LocalDate;

import exception.model.ModelException;
/**
 * Created by VTanchereau on 28/06/2017.
 */
public class FinancementStagiaire implements IFinancementStagiaire {

    private IStagiaire stagiaire;
    private IFinancement financement;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public FinancementStagiaire(IStagiaire stagiaire, IFinancement financement, LocalDate dateDebut, LocalDate dateFin) throws ModelException {
        this.stagiaire = stagiaire;
        this.financement = financement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        
        this.checkDate();
        this.checkListDate(this.dateDebut);
        this.checkListDate(this.dateFin);
    }

    public FinancementStagiaire(IStagiaire stagiaire, IFinancement financement, LocalDate dateDebut) throws ModelException {
        this.stagiaire = stagiaire;
        this.financement = financement;
        this.dateDebut = dateDebut;
       
        this.checkDate();
        this.checkListDate(this.dateDebut);
        this.checkListDate(this.dateFin);
    }

    public IStagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(IStagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public IFinancement getFinancement() {
        return financement;
    }

    public void setFinancement(IFinancement financement) {
        this.financement = financement;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) throws ModelException {
    	this.checkListDate(dateDebut);
        this.dateDebut = dateDebut;
        this.checkDate();
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) throws ModelException {
    	this.checkListDate(dateFin);
        this.dateFin = dateFin;
        this.checkDate();
    }
    
    private void checkDate() throws ModelException{
    	if(this.dateDebut != null && this.dateFin != null){
        	if(this.dateFin.isBefore(this.dateDebut)){
        		throw new ModelException("");
        	}
        }
        else{
        	throw new ModelException("Les dates ne peuvent pas être null");
        }
    }
    
    private void checkListDate(LocalDate date) throws ModelException{
    	if(!this.getStagiaire().getListFinancementsStagiaires().isEmpty()){
        	for(IFinancementStagiaire financement : this.getStagiaire().getListFinancementsStagiaires()){
        		if(financement != this){
        			if((date.isAfter(financement.getDateDebut()) && date.isBefore(financement.getDateFin())) || date.isEqual(financement.getDateDebut()) || date.isEqual(getDateFin())){
            			throw new ModelException("Les dates ne peuvent pas se chevaucher");
            		}
        		}
        	}
    	}
    }
}
