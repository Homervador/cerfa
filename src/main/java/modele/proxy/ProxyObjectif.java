package modele.proxy;

import dao.intf.DAO;
import exception.model.ModelException;
import dao.DAOFactory;
import dao.DAONames;
import modele.impl.Objectif;
import modele.intf.IFormation;
import modele.intf.IObjectif;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyObjectif implements IObjectif{

    private int id;
    private Objectif instance;

    public ProxyObjectif(int id){
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException{
        if (instance == null) {
            DAO<Objectif> dao = DAOFactory.getDAO(DAONames.Objectif);
            this.instance = dao.findById(this.id);
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) throws ModelException {
        this.id = id;
        this.getInstance();
        this.instance.setId(id);
    }

    @Override
    public String getLibelle() throws ModelException {
        this.getInstance();
        return this.instance.getLibelle();
    }

    @Override
    public void setLibelle(String libelle) throws ModelException {
        this.getInstance();
        this.instance.setLibelle(libelle);
    }

    @Override
    public List<IFormation> getListFormations() throws ModelException {
        getInstance();
        return this.instance.getListFormations();
    }

    @Override
    public void setListFormations(List<IFormation> listFormations) throws ModelException {
        getInstance();
        this.instance.setListFormations(listFormations);
    }

    public String toString(){
        try {
			this.getInstance();
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return this.instance.toString();
    }
}
