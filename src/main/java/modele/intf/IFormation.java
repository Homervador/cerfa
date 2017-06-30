package modele.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IFormation {
    int getId();
    void setId(int id) throws ModelException;
    String getNom() throws ModelException;
    void setNom(String nom) throws ModelException;
    ISpecialite getSpecialite() throws ModelException;
    void setSpecialite(ISpecialite specialite) throws ModelException;
    IObjectif getObjectif() throws ModelException;
    void setObjectif(IObjectif objectif) throws ModelException;
    List<ICreneau> getListCreneaux() throws ModelException;
    void setListCreneaux(List<ICreneau> listCreneaux) throws ModelException;
}
