package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Stagiaire;
import modele.intf.ICreneau;
import modele.intf.IFinancementStagiaire;
import modele.intf.IStagiaire;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyStagiaire implements IStagiaire {

    private int id;
    private Stagiaire instance;

    public ProxyStagiaire(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException
    {
        if (instance == null) {
            DAO<Stagiaire> dao = DAOFactory.getDAO(DAONames.Stagiaire);
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
        return this.getNom();
    }

    @Override
    public void setNom(String nom) throws ModelException {
        this.getInstance();
        this.instance.setNom(nom);
    }

    @Override
    public String getPrenom() throws ModelException {
        this.getInstance();
        return this.getPrenom();
    }

    @Override
    public void setPrenom(String prenom) throws ModelException {
        this.getInstance();
        this.instance.setPrenom(prenom);
    }

    @Override
    public boolean isInterne() throws ModelException {
        this.getInstance();
        return this.isInterne();
    }

    @Override
    public void setInterne(boolean interne) throws ModelException {
        this.getInstance();
        this.instance.setInterne(interne);
    }

    @Override
    public List<IFinancementStagiaire> getListFinancementsStagiaires() throws ModelException {
        this.getInstance();
        return this.instance.getListFinancementsStagiaires();
    }

    @Override
    public void setListFinancementsStagiaires(List<IFinancementStagiaire> listFinancementsStagiaires) throws ModelException {
        this.getInstance();
        this.instance.setListFinancementsStagiaires(listFinancementsStagiaires);
    }

    @Override
    public List<ICreneau> getListCreneaux() throws ModelException {
        this.getInstance();
        return this.instance.getListCreneaux();
    }

    @Override
    public void setListCreneaux(List<ICreneau> listCreneaux) throws ModelException {
        this.getInstance();
        this.instance.setListCreneaux(listCreneaux);
    }

    @Override
    public String toString() {
        try {
			this.getInstance();
		} 
        catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return this.instance.toString();
    }
}
