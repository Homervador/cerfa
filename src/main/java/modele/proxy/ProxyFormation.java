package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Formation;
import modele.intf.ICreneau;
import modele.intf.IFormation;
import modele.intf.IObjectif;
import modele.intf.ISpecialite;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyFormation implements IFormation{
    private int id;
    private Formation instance;

    public ProxyFormation(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException{
        if (instance == null) {
            DAO<Formation> dao = DAOFactory.getDAO(DAONames.Formation);
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
        getInstance();

        this.instance.setId(id);
    }

    @Override
    public String getNom() throws ModelException {
        getInstance();
        return this.instance.getNom();
    }

    @Override
    public void setNom(String nom) throws ModelException {
        getInstance();
        this.instance.setNom(nom);
    }

    @Override
    public ISpecialite getSpecialite() throws ModelException {
        getInstance();
        return this.instance.getSpecialite();
    }

    @Override
    public void setSpecialite(ISpecialite specialite) throws ModelException {
        getInstance();
        this.instance.setSpecialite(specialite);
    }

    @Override
    public IObjectif getObjectif() throws ModelException {
        getInstance();
        return this.instance.getObjectif();
    }

    @Override
    public void setObjectif(IObjectif objectif) throws ModelException {
        getInstance();
        this.instance.setObjectif(objectif);

    }

    @Override
    public List<ICreneau> getListCreneaux() throws ModelException {
        getInstance();
        return this.instance.getListCreneaux();
    }

    @Override
    public void setListCreneaux(List<ICreneau> listCreneaux) throws ModelException {
        getInstance();
        this.instance.setListCreneaux(listCreneaux);
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
