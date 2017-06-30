package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Specialite;
import modele.intf.IFormation;
import modele.intf.ISpecialite;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxySpecialite implements ISpecialite {

    private int id;
    private Specialite instance;

    public ProxySpecialite(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException
    {
        if (instance == null) {
            DAO<Specialite> dao = DAOFactory.getDAO(DAONames.Specialite);
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
        this.instance.setId(this.id);
    }

    @Override
    public String getNom() throws ModelException {
        this.getInstance();
        return this.instance.getNom();
    }

    @Override
    public void setNom(String nom) throws ModelException {
        this.getInstance();
        this.instance.setNom(nom);
    }

    @Override
    public String getCode() throws ModelException {
        this.getInstance();
        return this.instance.getCode();
    }

    @Override
    public void setCode(String code) throws ModelException {
        this.getInstance();
        this.instance.setCode(code);
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
