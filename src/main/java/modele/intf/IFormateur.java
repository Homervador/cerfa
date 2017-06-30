package modele.intf;

import modele.impl.Creneau;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IFormateur extends IPersonne{

    List<ICreneau> getListCreneaux() throws ModelException;
    void setListCreneaux(List<ICreneau> listCreneaux) throws ModelException;
    boolean isInterne() throws ModelException;
    void setInterne(boolean interne) throws ModelException;
}
