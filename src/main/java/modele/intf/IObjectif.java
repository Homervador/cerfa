package modele.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IObjectif {

    int getId();
    void setId(int id) throws ModelException;
    String getLibelle() throws ModelException;
    void setLibelle(String libelle) throws ModelException;
    List<IFormation> getListFormations() throws ModelException;
    void setListFormations(List<IFormation> listFormations) throws ModelException;
}
