package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Creneau;
import modele.impl.Formateur;
import modele.intf.ICreneau;
import modele.intf.IFormateur;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyFormateur implements IFormateur {

    private int id;
    private Formateur instance;

    public ProxyFormateur(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException{
        if (instance == null) {
            DAO<Formateur> dao = DAOFactory.getDAO(DAONames.Formateur);
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
        getInstance();
        return this.getNom();
    }

    @Override
    public void setNom(String nom) throws ModelException {
        getInstance();
        this.instance.setNom(nom);
    }

    @Override
    public String getPrenom() throws ModelException {
        getInstance();
        return this.instance.getPrenom();
    }

    @Override
    public void setPrenom(String prenom) throws ModelException {
        getInstance();
        this.instance.setPrenom(prenom);
    }

    @Override
    public boolean isInterne() throws ModelException {
        getInstance();
        return this.instance.isInterne();
    }

    @Override
    public void setInterne(boolean interne) throws ModelException {
        getInstance();
        this.instance.setInterne(interne);
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
