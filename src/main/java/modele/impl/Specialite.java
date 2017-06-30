package modele.impl;

import modele.intf.IFormation;
import modele.intf.ISpecialite;

import java.util.ArrayList;
import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 27/06/2017.
 */
public class Specialite implements ISpecialite {
    private int id;
    private String nom;
    private String code;
    private List<IFormation> listFormations;

    public Specialite(int id, String nom, String code) throws ModelException {
        this.id = id;
        this.nom = nom;
        this.setCode(code);
        this.listFormations = new ArrayList<>();
    }

    public Specialite(String nom, String code) throws ModelException {
        this.nom = nom;
        this.setCode(code);
        this.listFormations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws ModelException{
    	if(code!= null){
    		if(code.length() == 3){
        		try{
        			int codeInt = Integer.parseInt(code);
            		this.code = code;
        		}
        		catch(Exception e){
        			throw new ModelException("Le code doit être composé de chiffres.", e);
        		}
        	}
        	else{
        		throw new ModelException("Le code doit posséder 3 caractère");
        	}
    	}
    	else{
    		throw new ModelException("Le code ne peut pas être null");
    	}
    }

    public List<IFormation> getListFormations() {
        return listFormations;
    }

    public void setListFormations(List<IFormation> listFormations) {
        this.listFormations = listFormations;
    }

    @Override
    public String toString() {
        return "Specialite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
