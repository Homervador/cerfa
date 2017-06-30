package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Creneau;
import modele.intf.ICreneau;
import modele.intf.IFormateur;
import modele.intf.IFormation;
import modele.intf.IStagiaire;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyCreneau implements ICreneau {

    private int id;
    private Creneau instance;

    public ProxyCreneau(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException{
        if (instance == null) {
            DAO<Creneau> dao = DAOFactory.getDAO(DAONames.Creneau);
            this.instance = dao.findById(this.id);
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) throws ModelException {
        this.getInstance();
        this.instance.setId(id);
    }

    @Override
    public LocalDateTime getDateDebut() throws ModelException {
        this.getInstance();
        return this.instance.getDateDebut();
    }

    @Override
    public void setDateDebut(LocalDateTime dateDebut) throws ModelException{
        this.getInstance();
        this.instance.setDateDebut(dateDebut);
    }

    @Override
    public LocalDateTime getDateFin() throws ModelException {
        this.getInstance();
        return this.instance.getDateFin();
    }

    @Override
    public void setDateFin(LocalDateTime dateFin) throws ModelException {
        this.getInstance();
        this.instance.setDateFin(dateFin);
    }

    @Override
    public boolean isInterne() throws ModelException {
        this.getInstance();
        return this.instance.isInterne();
    }

    @Override
    public void setInterne(boolean interne) throws ModelException {
        this.getInstance();
        this.instance.setInterne(interne);
    }

    @Override
    public IFormation getFormation() throws ModelException {
        this.getInstance();
        return this.instance.getFormation();
    }

    @Override
    public void setFormation(IFormation formation) throws ModelException {
        this.getInstance();
        this.instance.setFormation(formation);
    }

    @Override
    public List<IStagiaire> getListStagiaires() throws ModelException {
        this.getInstance();
        return this.instance.getListStagiaires();
    }

    @Override
    public void setListStagiaires(List<IStagiaire> listStagiaires) throws ModelException {
        this.getInstance();
        this.instance.setListStagiaires(listStagiaires);
    }

    @Override
    public List<IFormateur> getListFormateurs() throws ModelException {
        this.getInstance();
        return this.instance.getListFormateurs();
    }

    @Override
    public void setListFormateurs(List<IFormateur> listFormateurs) throws ModelException {
        this.getInstance();
        this.instance.setListFormateurs(listFormateurs);
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
