package modele.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface ISpecialite {
    int getId();
    void setId(int id) throws ModelException;
    String getNom() throws ModelException;
    void setNom(String nom) throws ModelException;
    String getCode() throws ModelException;
    void setCode(String code) throws ModelException;
    List<IFormation> getListFormations() throws ModelException;
    void setListFormations(List<IFormation> listFormations) throws ModelException;

}
