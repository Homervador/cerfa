package modele.proxy;

import dao.DAOFactory;
import dao.DAONames;
import dao.intf.DAO;
import exception.model.ModelException;
import modele.impl.Financement;
import modele.intf.IFinancement;
import modele.intf.IFinancementStagiaire;

import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public class ProxyFinancement implements IFinancement{

    private int id;
    private Financement instance;

    public ProxyFinancement(int id) {
        this.id = id;
        this.instance = null;
    }

    private void getInstance() throws ModelException
    {
        if (instance == null) {
            DAO<Financement> dao = DAOFactory.getDAO(DAONames.Financement);
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
    public List<IFinancementStagiaire> getListFinancementsStagiaires() throws ModelException {
        this.getInstance();
        return this.instance.getListFinancementsStagiaires();
    }

    @Override
    public void setListFinancementsStagiaires(List<IFinancementStagiaire> listStagiaires) throws ModelException {
        this.getInstance();
        this.instance.setListFinancementsStagiaires(listStagiaires);
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
