package modele.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IFinancement {
    int getId() throws ModelException;
    void setId(int id) throws ModelException;
    String getLibelle() throws ModelException;
    void setLibelle(String libelle) throws ModelException;
    List<IFinancementStagiaire> getListFinancementsStagiaires() throws ModelException;
    void setListFinancementsStagiaires(List<IFinancementStagiaire> listStagiaires) throws ModelException;
}
